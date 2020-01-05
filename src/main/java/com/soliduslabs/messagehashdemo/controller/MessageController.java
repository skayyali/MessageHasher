package com.soliduslabs.messagehashdemo.controller;

import org.apache.log4j.Logger;
import com.soliduslabs.messagehashdemo.model.Message;
import com.soliduslabs.messagehashdemo.service.MessageHashService;
import com.soliduslabs.messagehashdemo.service.ResourceNotFoundException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Controller
public class MessageController {

    private static final Logger logger = Logger.getLogger(MessageController.class);

    @Autowired
    private MessageHashService messageHashService;

    @RequestMapping(value = "/messages", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody String message) throws NoSuchAlgorithmException {
        Message m = new Message();
        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        JSONObject jsonMessage = new JSONObject(message);
        byte[] encodedhash = digest.digest(jsonMessage.getString("message").getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < encodedhash.length; i++) {
            sb.append(String.format("%02x", encodedhash[i] & 0xFF));
        }

        m.setMessage(jsonMessage.getString("message"));
        m.setHash(sb.toString());
        try {
            messageHashService.saveMessage(m);
            String responseJSON = new JSONObject().put("digest", sb.toString()).toString();
            logger.info("Added Message \"" + m.getMessage() + " : " + m.getHash() + "\" to DB");
            return ResponseEntity.ok().body(responseJSON);
        } catch (Exception e) {
            logger.error("Error while trying to save Message in DB : " + e.getMessage());
        }

        return null;
    }

    @RequestMapping(value = "/messages/{hash}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> get(@PathVariable("hash") String hash) {
        String message = messageHashService.getMessage(hash);
        if (message == null) {
            logger.error("Could not find Message for Digest : " + hash);
            throw new ResourceNotFoundException();
        }
        logger.info("Successfully retrieved Message : " + message);
        String responseJSON = new JSONObject().put("message", message).toString();
        return ResponseEntity.ok().body(responseJSON);
    }
}