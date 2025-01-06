package com.sj.client;

import com.sj.model.ChatResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Map;


@Service
public class CoherenceClient implements ChatClient {

    private final String apiKey;
    private final RestTemplate restTemplate;
    private final String apiUrl;
    private final String model;

    public CoherenceClient(RestTemplateBuilder restTemplateBuilder,
                           @Value("${coherence.api-key}") String apiKey,
                           @Value("${coherence.api-url}") String apiUrl,
                           @Value("${coherence.model}") String model) {
        this.restTemplate = restTemplateBuilder.build();
        this.apiKey = apiKey;
        this.apiUrl = apiUrl;
        this.model = model;
    }

    @Override
    public ChatResponse getChatResponse(String prompt) {
        // Build the request body according to the new API structure
        Map<String, Object> requestBody = buildRequestBody(prompt);
        HttpHeaders headers = buildHeaders();

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

        try {
            // Send request to Cohere API
            ResponseEntity<Map> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, Map.class);
            return extractResponse(responseEntity.getBody());
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch chat response: " + e.getMessage(), e);
        }
    }

    private Map<String, Object> buildRequestBody(String prompt) {
        // The structure for Cohere's chat API
        return Map.of(
                "model", model,
                "message", prompt,
                "preamble", "You are an AI-assistant chatbot. You are trained to assist users by providing thorough and helpful responses to their queries."
        );
    }

    private HttpHeaders buildHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);
        return headers;
    }

    private ChatResponse extractResponse(Map<String, Object> responseBody) {
        if (responseBody == null || responseBody.isEmpty()) {
            throw new RuntimeException("Empty response from Cohere API");
        }

        // Correct extraction of the "text" field from the API response
        String generatedText = (String) responseBody.get("text");
        if (generatedText == null) {
            throw new RuntimeException("Missing 'text' field in the API response");
        }
        return new ChatResponse(generatedText);
    }
}

