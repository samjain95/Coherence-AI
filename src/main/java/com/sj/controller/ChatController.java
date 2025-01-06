package com.sj.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sj.client.ChatClient;
import com.sj.model.ChatRequest;
import com.sj.model.ChatResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private ChatClient chatClient;

    @Autowired
    private ObjectMapper objectMapper; // Jackson ObjectMapper for debugging



    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ChatResponse> getChatResponse(@RequestBody @Valid ChatRequest chatRequest) {

        String prompt = chatRequest.getPrompt();

        // Validate prompt
        if (prompt == null || prompt.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(new ChatResponse("Error: Prompt must not be empty or whitespace"));
        }

        try {
            ChatResponse response = chatClient.getChatResponse(chatRequest.getPrompt());

            // Debug: Log the response as JSON
            System.out.println("Generated response (JSON): " + objectMapper.writeValueAsString(response));

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ChatResponse("Error: " + e.getMessage()));
        }
    }
}
