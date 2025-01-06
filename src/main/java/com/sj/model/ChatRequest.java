package com.sj.model;

import jakarta.validation.constraints.NotBlank;

public class ChatRequest {
    @NotBlank
    private String prompt;

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
}