package com.crackbyte.controllers;

import com.crackbyte.services.ChatRoomService;
import com.crackbyte.util.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/chatroom")
public class ChatRoomController {
    private final ChatRoomService chatRoomService;

    @GetMapping("/{uuid}/members")
    public ResponseEntity<Response> getRecentChats(@PathVariable String uuid) {
        return Response.build(chatRoomService.getChatRoomMembers(uuid));
    }
}
