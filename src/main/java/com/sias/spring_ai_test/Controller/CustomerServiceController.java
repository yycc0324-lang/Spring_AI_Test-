package com.sias.spring_ai_test.Controller;

import com.sias.spring_ai_test.repository.ChatHistoryRepository;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/ai")
@CrossOrigin(origins = "http://localhost:5173")

public class CustomerServiceController {

    private final ChatClient serviceChatClient;
    private final ChatHistoryRepository chatHistoryRepository;

    public CustomerServiceController(
            @Qualifier("servicechatClient") ChatClient serviceChatClient,
            ChatHistoryRepository chatHistoryRepository) {
        this.serviceChatClient = serviceChatClient;
        this.chatHistoryRepository = chatHistoryRepository;
    }
        @PostMapping(value = "/service", produces = "text/event-stream")
        public Flux<String> service(@RequestParam String prompt, @RequestParam String chatId) {
            chatHistoryRepository.save("Service", chatId);

            return serviceChatClient.prompt(prompt)
                    .user(prompt)
                    .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, chatId))
                    .stream()
                    .content();
        }

    }
