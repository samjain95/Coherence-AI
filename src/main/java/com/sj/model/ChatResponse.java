package com.sj.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class ChatResponse {

    @JsonProperty("response")
    private final String response;

    public ChatResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

}
