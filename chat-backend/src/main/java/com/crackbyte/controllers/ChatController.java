package com.crackbyte.controllers;

import com.crackbyte.services.ChatService;
import com.crackbyte.util.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/chats")
public class ChatController {
    private final ChatService chatService;

    @GetMapping("/recent")
    public ResponseEntity<Response> getRecentChats(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int limit) {
        return Response.build(chatService.getRecentChats());
    }

    @GetMapping("/send")
    public void send(@RequestParam String message) {
         chatService.send(message);
    }
}
