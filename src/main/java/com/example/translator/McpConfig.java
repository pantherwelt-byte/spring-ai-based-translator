package com.example.translator;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class McpConfig {

    @Bean
    public ToolCallbackProvider translationTools(@Lazy TranslationService translationService) {
        return MethodToolCallbackProvider.builder()
                .toolObjects(translationService)
                .build();
    }
}