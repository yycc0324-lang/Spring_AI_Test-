package com.sias.spring_ai_test.repository;

import java.util.List;


public interface ChatHistoryRepository {


    //此处的保存会话历史需要用到多个场景下，比如后续的PDF功能和接下来需要使用到的聊天模拟器功能等，需要Type去约定类型来区别不同的功能使用场景
    /*
    * 保存会话纪录
    */
    void save(String type,String chatId);//此处的保存不需要返回只需要把应存的数据存起来就好，查询才需要



    /*
    * 获取/查询会话ID列表
    */
    List<String> getChatIds(String type);

}
