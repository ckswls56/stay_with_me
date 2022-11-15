package com.dgu.stay_with_me.service;

import com.dgu.stay_with_me.model.Room;
import com.dgu.stay_with_me.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> findAll(){
        List<Room> rooms = new ArrayList<>();
        roomRepository.findAll().forEach(e->rooms.add(e));
        return rooms;
    }

    public Optional<Room> findById(int roomId){
        Optional<Room> room = roomRepository.findById(roomId);
        return room;
    }

    public void deleteById(int roomId){
        roomRepository.deleteById(roomId);
    }

    public Room save(Room room){
        roomRepository.save(room);
        return room;
    }

    public void updateById(int roomId, Room room){
        Optional<Room> e = roomRepository.findById(roomId);

        if(e.isPresent()){
            e.get().setRoomId(room.getRoomId());
            e.get().setRoomName(room.getRoomName());
            e.get().setRoomPrice(room.getRoomPrice());
            e.get().setRoomCapacity(room.getRoomCapacity());
            e.get().setRoomDetail(room.getRoomDetail());
        }
    }
}
