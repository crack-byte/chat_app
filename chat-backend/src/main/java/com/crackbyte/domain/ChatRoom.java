package com.crackbyte.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class ChatRoom extends Base {
    private String name;
    private String uuid;
    @ManyToMany(
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "chat_members",
            joinColumns = @JoinColumn(name = "chat_room_id"),
            inverseJoinColumns = @JoinColumn(name = "user_profile_id")
    )
    private List<UserProfile> members;
    @OneToMany(
            mappedBy = "chatRoom",
            fetch = FetchType.LAZY
    )
    private List<Message> messages;
}
