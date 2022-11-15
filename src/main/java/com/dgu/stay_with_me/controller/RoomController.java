package com.dgu.stay_with_me.controller;


import com.dgu.stay_with_me.model.Room;
import com.dgu.stay_with_me.repository.RoomRepository;
import com.dgu.stay_with_me.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("room")
public class RoomController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RoomService roomService;

    //모든 방 조회

    @GetMapping()
    public ResponseEntity<List<Room>> getAllRooms(){
        List<Room> rooms = roomService.findAll();
        return new ResponseEntity<List<Room>>(rooms, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Room> save(Room room){
        return new ResponseEntity<Room>(roomService.save(room),HttpStatus.OK);
    }

}
