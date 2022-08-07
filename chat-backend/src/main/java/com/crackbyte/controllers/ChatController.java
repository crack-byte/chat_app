package com.crackbyte.controllers;

import com.crackbyte.dto.MessageDTO;
import com.crackbyte.services.ChatService;
import com.crackbyte.util.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/send")
    public void send(@RequestBody MessageDTO message) {
         chatService.send(message);
    }
}
