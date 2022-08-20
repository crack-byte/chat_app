package com.crackbyte.repositories;

import com.crackbyte.domain.ChatRoom;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {

    Optional<ChatRoom> findChatRoomByUuid(String uuid);

    @Query(nativeQuery = true, value = "select cr.id as id, cr.uuid as uuid, cr.name as name, max(m.last_updated_date) as lastMessageTimestamp" +
            " from chat_room cr inner join message m on cr.id = m.chat_room_id" +
            " group by cr.id order by lastMessageTimestamp desc")
    List<Object[]> findLatestChats();

}