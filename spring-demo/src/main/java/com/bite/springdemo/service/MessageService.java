package com.bite.springdemo.service;

import com.bite.springdemo.mapper.MessageMapper;
import com.bite.springdemo.model.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-01
 * Time: 2:03
 */
@Service
public class MessageService {

    @Autowired
    private MessageMapper messageMapper;

    public void addMessage(MessageInfo messageInfo) {
        messageMapper.insertMessage(messageInfo);
    }

    public List<MessageInfo> queryAll() {
        return messageMapper.QueryAll();
    }
}
