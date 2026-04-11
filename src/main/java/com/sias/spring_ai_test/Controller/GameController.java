package com.sias.spring_ai_test.Controller;

import com.sias.spring_ai_test.repository.ChatHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/ai")
public class GameController {
    private final ChatClient gamechatClient;

    @GetMapping(value = "/game", produces = "text/event-stream")
    public Flux<String> game(@RequestParam String prompt, @RequestParam String chatId) {
        return gamechatClient.prompt(prompt)
                .user(prompt)
                .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, chatId))
                .stream()
                .content();
    }
}
