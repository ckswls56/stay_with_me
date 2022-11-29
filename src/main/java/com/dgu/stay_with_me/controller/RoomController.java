package com.dgu.stay_with_me.controller;


import com.dgu.stay_with_me.model.Room;
import com.dgu.stay_with_me.repository.RoomRepository;
import com.dgu.stay_with_me.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
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
    
    // roomId로 방하나 조회
    @GetMapping(value = "/{roomId}")
    public ResponseEntity<Room> getRoom(@PathVariable("roomId")Integer roomId){
        Optional<Room> room = roomService.findById(roomId);
        return new ResponseEntity<Room>(room.get(),HttpStatus.OK);
    }
    //roomName으로 조회
    @GetMapping(value = "/name/{roomName}")
    public ResponseEntity<Room> getRoom(@PathVariable("roomName")String roomName){
        Optional<Room> room = roomService.findByName(roomName);
        return new ResponseEntity<Room>(room.get(),HttpStatus.OK);
    }

    // roomId로 방 삭제
    @DeleteMapping(value = "/{roomId}")
    public ResponseEntity<Room> deleteRoom(@PathVariable("roomId") Integer roomId){
        roomService.deleteById(roomId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // roomId로 방 수정

    @PutMapping(value = {"/{roomId}"})
    public ResponseEntity<Room> updateRoom(@PathVariable("roomId") Integer roomId,Room room){
        roomService.updateById(roomId,room);
        return new ResponseEntity<Room>(room,HttpStatus.OK);
    }

    //방 입력
    @PostMapping
    public ResponseEntity<Room> save(Room room){
        return new ResponseEntity<Room>(roomService.save(room),HttpStatus.OK);
    }

    @RequestMapping(value = "/saveRoom",method = RequestMethod.GET)
    public ResponseEntity<Room> save(HttpServletRequest req, Room room){
        return new ResponseEntity<Room>(roomService.save(room),HttpStatus.OK);
    }


}
