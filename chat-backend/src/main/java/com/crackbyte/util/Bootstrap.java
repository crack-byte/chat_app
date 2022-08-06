package com.crackbyte.util;

import com.crackbyte.domain.ChatRoom;
import com.crackbyte.domain.User;
import com.crackbyte.domain.UserProfile;
import com.crackbyte.repositories.ChatRoomRepository;
import com.crackbyte.repositories.MessageRepository;
import com.crackbyte.repositories.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class Bootstrap {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserProfileRepository userProfileRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ChatRoomRepository chatRoomRepository;

    @EventListener(classes = {ContextRefreshedEvent.class})
    public void handleMultipleEvents() {
        if (userProfileRepository.count() == 0) {
            List<UserProfile> userProfiles = new ArrayList<>(2);
            UserProfile userProfile = UserProfile.builder()
                    .firstName("admin")
                    .lastName("")
                    .age((short) 0)
                    .userName("admin").build();
            userProfile.setEmail("admin@chat.com");
            userProfile.setEncryptedPassword(passwordEncoder.encode("admin"));
            userProfiles.add(userProfile);
            userProfile = UserProfile.builder()
                    .firstName("admin")
                    .lastName("2")
                    .age((short) 0)
                    .userName("admin2").build();
            userProfile.setEmail("admin2@chat.com");
            userProfile.setEncryptedPassword(passwordEncoder.encode("admin2"));
            userProfiles.add(userProfile);
            userProfiles = userProfileRepository.saveAllAndFlush(userProfiles);
            ChatRoom chatRoom = new ChatRoom();
            chatRoom.setName("Admin Group");
            chatRoom.setMembers(userProfiles);
            chatRoom.setUuid(UUID.randomUUID().toString());
            chatRoomRepository.save(chatRoom);
        }
    }
}
