package com.crackbyte.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@ToString
@Getter
@Setter
@MappedSuperclass
public class Base implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime createdDate;
    private LocalDateTime lastUpdatedDate;
    private boolean deleted;

    @PrePersist
    void prePersist() {
        this.createdDate = LocalDateTime.now();
        this.lastUpdatedDate = this.createdDate;
    }

    @PreUpdate
    void preUpdate() {
        this.lastUpdatedDate = LocalDateTime.now();
    }

}
