package com.soliduslabs.messagehashdemo.model;

import javax.persistence.*;

@Entity
@Table(name = "messagehash")
public class Message {
    @Id
    @Column(name = "message")
    private String message;
    @Column(name = "digest")
    private String hash;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}

