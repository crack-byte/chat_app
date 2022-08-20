package com.crackbyte.services;

import com.crackbyte.domain.UserProfile;
import com.crackbyte.repositories.ChatRoomRepository;
import com.crackbyte.repositories.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;

    @Transactional
    public List<Map<String, Object>> getChatRoomMembers(String uuid) {
        List<Map<String, Object>> members = new LinkedList<>();
        chatRoomRepository.findChatRoomByUuid(uuid).ifPresent(chatRoom -> {
            List<UserProfile> chatRoomMembers = chatRoom.getMembers();
            chatRoomMembers
                    .forEach(userProfile -> {
                        Map<String, Object> map = new HashMap<>();
                        map.put("name", userProfile.getFirstName() + " " + userProfile.getLastName());
                        map.put("uuid", userProfile.getUuid());
                        members.add(map);
                    });
        });
        return members;
    }
}