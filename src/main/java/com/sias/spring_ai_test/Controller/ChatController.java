package com.sias.spring_ai_test.Controller;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import java.util.*;
@RequiredArgsConstructor
@RestController
@RequestMapping("/ai")
@CrossOrigin(origins = "http://localhost:5173")
public class ChatController {
    private final ChatClient chatClient;
    // 改为 POST 方法，接收 JSON 请求体
    //@PostMapping(value = "/chat",consumes = {"multipart/form-data"},  produces = "text/html;charset=utf-8")
    @PostMapping(value = "/chat", produces = "text/event-stream")
    public Flux<String> chat(@RequestParam String prompt,String chatId) { // 改为 RequestParam 接收 form 数据,chatId为每段对话的会话Id
        return chatClient.prompt(prompt)
                .user(prompt)
                .advisors(a ->a.param(ChatMemory.CONVERSATION_ID, chatId))//每一段对话除了会话记忆还有一个会话Id
                .stream()
                .content();
    }
    /*public Flux<String> chat(@RequestBody Map<String, String> request) {
        String message = request.get("message");
        return chatClient
                .prompt(message)
                .user(message)
                .stream()
                .content();
    }*/
    // 添加历史记录接口（GET 方法）、
}