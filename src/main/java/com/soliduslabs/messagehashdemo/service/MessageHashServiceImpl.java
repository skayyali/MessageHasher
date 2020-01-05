package com.soliduslabs.messagehashdemo.service;

import com.soliduslabs.messagehashdemo.dao.MessageDAO;
import com.soliduslabs.messagehashdemo.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MessageHashServiceImpl implements MessageHashService {

    @Autowired
    private MessageDAO messageDAO;

    @Transactional
    @Override
    public void saveMessage(Message m) {
        messageDAO.addMessage(m);

    }

    @Override
    public String getMessage(String hash) {
        return messageDAO.getMessage(hash);
    }
}
