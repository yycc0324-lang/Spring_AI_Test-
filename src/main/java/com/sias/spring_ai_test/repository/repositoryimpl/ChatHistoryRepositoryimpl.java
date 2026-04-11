package com.sias.spring_ai_test.repository.repositoryimpl;
import com.sias.spring_ai_test.repository.ChatHistoryRepository;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ChatHistoryRepositoryimpl implements ChatHistoryRepository {



    private final Map<String, List<String>> chatHistory = new HashMap<>();


    @Override
    public void save(String type, String chatId) {//此处保存适合用map的key-value存储，1:n
       /* if(!chatHistory.containsKey(type)){
            chatHistory.put(type,new ArrayList<>());
        }
        List<String> chatIds = chatHistory.get(type);*///获取当前类型的所有会话Id,但是每一段调用get的时候会扫描所有的type，比较耗时,还有一种写法只需要一行但是性能没有优化，只是写的少一些

        List<String> chatIds = chatHistory.computeIfAbsent(type, k -> new ArrayList<>());//但是可读性差些

        if (chatIds.contains(chatId)){
            return;
        }

        chatIds.add(chatId);

    }

    @Override
    public List<String> getChatIds(String type) {

        List<String> strings = chatHistory.get(type);//key为type的value
        if (strings == null) {
            return new ArrayList<>();
        }
        return strings;
    }
}
