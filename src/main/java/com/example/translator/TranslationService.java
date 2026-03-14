package com.example.translator;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
public class TranslationService {

    private final ChatClient chatClient;

    public TranslationService(ChatClient.Builder builder) {
        this.chatClient = builder
                .defaultSystem("You are a professional translator. Translate the given German text to English. " +
                               "Return only the translated text, without explanations or additional comments.")
                .build();
    }

    @Tool(description = "Translates German text to English")
    public String translate(String germanText) {
        return chatClient.prompt()
                .user(germanText)
                .call()
                .content();
    }
}
