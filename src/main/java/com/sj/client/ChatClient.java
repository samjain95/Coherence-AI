package com.sj.client;

import com.sj.model.ChatResponse;

public interface ChatClient {
    ChatResponse getChatResponse(String prompt);
}
