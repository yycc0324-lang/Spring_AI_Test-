package com.sias.spring_ai_test.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//加入这个注解就可以自己定义Bean，用户定义大于SpringBoot自动注入，不加入用户无法自己定义Bean
    /*
    *
    自动配置给了你一个能用的 Bean，但参数是写死的。比如，Spring AI 自动配置的 ChatClient 默认超时可能是 60 秒，你想改成 10 秒。
    自动配置方式：你无法控制，它使用默认超时。
    手动定义方式：你创建 ChatClient 的 @Bean，在构建时设置超时。
    *
    */
public class CommonConfiguration {
    @Bean
    public ChatMemory chatMemory() {
        return MessageWindowChatMemory.builder().build();
    }

    @Bean
    public ChatClient chatClient(OllamaChatModel model, ChatMemory chatMemory) {
        return ChatClient.builder(model)
                .defaultSystem("你是贾维斯，高度智能化的AI助手，说话客观严谨")
                .defaultAdvisors(//添加两个Advisor，Advisor是Spring AI提供的一个功能，可以给ChatClient添加一些功能，比如记录聊天记录，记录聊天记录，方便后续查询。
                        new SimpleLoggerAdvisor(),
                        MessageChatMemoryAdvisor.
                                builder(chatMemory)
                                .build())
                .build();
    }
}

