package com.soliduslabs.messagehashdemo.dao;

import com.soliduslabs.messagehashdemo.model.Message;

public interface MessageDAO {

    public void addMessage(Message m);
    public String getMessage(String hash);

}
