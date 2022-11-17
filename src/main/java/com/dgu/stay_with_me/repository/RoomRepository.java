package com.dgu.stay_with_me.repository;

import com.dgu.stay_with_me.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    public Optional<Room> findByRoomName(String name);
    public Optional<Room> findByRoomPrice(int price);


}
