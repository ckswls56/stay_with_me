package com.dgu.stay_with_me.repository;

import com.dgu.stay_with_me.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {

    public List<Room> findById(String id);
    public List<Room> findByName(String name);
    public List<Room> findByCost(int price);

}
