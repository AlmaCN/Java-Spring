package co.develhope.websocket1.controller;

import co.develhope.websocket1.entities.ClientMessageDTO;
import co.develhope.websocket1.entities.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class NotificationController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @PostMapping("/broadcast-message")
    public ResponseEntity sendNotificationToClients(@RequestBody MessageDTO message){
        simpMessagingTemplate.convertAndSend("/topic/broadcast", message);
        return ResponseEntity.accepted().body("Message " + message.getMessage() + " sent to " + "/topic/broadcast");
    }

    @MessageMapping("/hello")
    @SendTo("/topic/broadcast")
    public MessageDTO messageFromWebSocket(ClientMessageDTO message){
        return new MessageDTO("From " + message.getFrom(), "Text: " + message.getText());

    }
}