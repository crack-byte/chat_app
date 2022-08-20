package com.crackbyte.services;

import com.crackbyte.domain.ChatRoom;
import com.crackbyte.domain.Message;
import com.crackbyte.dto.MessageDTO;
import com.crackbyte.repositories.ChatRoomRepository;
import com.crackbyte.repositories.MessageRepository;
import com.crackbyte.util.CommonUtil;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ChatService {
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final ChatRoomRepository chatRoomRepository;
    private final MessageRepository messageRepository;

    @Transactional
    public List<Map<String, Object>> getRecentChats() {
        List<Object[]> chatRooms = chatRoomRepository.findLatestChats();
        return chatRooms.stream()
                .map(obj -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("name", obj[2]);
                    map.put("uuid", obj[1]);
                    map.put("message", "");
                    map.put("timestamp", obj[3]);
                    return map;
                }).collect(Collectors.toList());
    }

    public void send(MessageDTO message) {
        simpMessagingTemplate.convertAndSend("/room/"+message.getReceiver(), message);
        CommonUtil.getExecutor().execute(() -> saveMessage(message));
    }

    private void saveMessage(MessageDTO messageDTO) {
        chatRoomRepository.findChatRoomByUuid(messageDTO.getReceiver())
                .ifPresent(chatRoom -> {
                    Message message = new Message();
                    message.setMessage(messageDTO.getMessage());
                    message.setTimestamp(messageDTO.getTimestamp());
                    message.setSender(messageDTO.getSender());
                    message.setChatRoom(chatRoom);
                    messageRepository.save(message);
                });
    }


}
