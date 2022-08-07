package com.crackbyte.services;

import com.crackbyte.domain.ChatRoom;
import com.crackbyte.dto.MessageDTO;
import com.crackbyte.repositories.ChatRoomRepository;
import org.springframework.data.domain.Sort;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ChatService {
    public ChatService(ChatRoomRepository chatRoomRepository, SimpMessagingTemplate simpMessagingTemplate) {
        this.chatRoomRepository = chatRoomRepository;
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    private final SimpMessagingTemplate simpMessagingTemplate;
    private final ChatRoomRepository chatRoomRepository;

    @Transactional
    public List<Map<String, Object>> getRecentChats() {
        List<ChatRoom> chatRooms = chatRoomRepository.findAll(Sort.by(Sort.Direction.DESC, "messages.createdDate"));
        return chatRooms.stream().map(chatRoom -> {
            Map<String, Object> map = new HashMap<>();
            map.put("name", chatRoom.getName());
            map.put("uuid", chatRoom.getUuid());
            if (chatRoom.getMessages() != null && !chatRoom.getMessages().isEmpty()) {
                map.put("message", chatRoom.getMessages().get(0).getMessage());
                map.put("timestamp", chatRoom.getMessages().get(0).getTimestamp());
            } else map.put("message", "");
            return map;
        }).collect(Collectors.toList());
    }

    public void send(MessageDTO message) {
        simpMessagingTemplate.convertAndSend("/room/test", message);
    }
}
