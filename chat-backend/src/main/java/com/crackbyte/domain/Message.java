package com.crackbyte.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@ToString(callSuper = true)
@Getter
@Setter
@Entity
public class Message extends Base {
    private String message;
    private String sender;
    private String receiver;
    private long timestamp;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    private ChatRoom chatRoom;
}
