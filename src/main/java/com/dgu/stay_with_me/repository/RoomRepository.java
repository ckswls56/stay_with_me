package com.dgu.stay_with_me.repository;

import com.dgu.stay_with_me.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    public List<Room> findByRoomId(int id);
    public List<Room> findByRoomName(String name);
    public List<Room> findByRoomPrice(int price);

}
