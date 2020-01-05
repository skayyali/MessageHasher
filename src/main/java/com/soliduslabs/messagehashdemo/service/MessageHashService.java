package com.soliduslabs.messagehashdemo.service;

import com.soliduslabs.messagehashdemo.model.Message;

public interface MessageHashService {

    public void saveMessage (Message m);
    public String getMessage (String hash);

}
