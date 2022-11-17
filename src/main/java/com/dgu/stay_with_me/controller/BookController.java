package com.dgu.stay_with_me.controller;

import com.dgu.stay_with_me.model.Book;
import com.dgu.stay_with_me.model.Room;
import com.dgu.stay_with_me.service.BookService;
import com.dgu.stay_with_me.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;
import java.util.*;

@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    RoomService roomService;

    //모든 예약정보 조회
    @GetMapping()
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> book = bookService.findAll();
        return new ResponseEntity<List<Book>>(book, HttpStatus.OK);
    }
    // 예약id로 조회
    @GetMapping(value = "/{bookId}")
    public ResponseEntity<Book> getBook(@PathVariable("bookId") Integer bookId){
        Optional<Book> book = bookService.findById(bookId);
        return new ResponseEntity<Book>(book.get(),HttpStatus.OK);
    }

    // 예약id and CardNum 조회
    @GetMapping("/check")
    public ResponseEntity<Book> getBook(@RequestParam(value = "bookId") Integer bookId,@RequestParam(value = "cardNum") String cardNum){
        Optional<Book> book = bookService.findByBookIdAndCardNum(bookId,cardNum);
        return new ResponseEntity<Book>(book.get(),HttpStatus.OK);
    }

    // 시작날짜와 끝날짜로 조회 시작날짜와 끝날짜 사이에있으면 조회됨. 비어있는 방들 반환
    @GetMapping("/date")
    public ResponseEntity<List<Room>> getBook(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")@RequestParam(value = "start")LocalDateTime start,
                                                  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")@RequestParam(value = "end") LocalDateTime end){
        List<Book> book = bookService.findAllByCheckInDateBetween(start,end);
        List<Book> book2 = bookService.findAllByCheckOutDateBetween(start,end);
        //예약된 방 번호들
        Set<Integer> reservedRoomIds = new LinkedHashSet<>();
        for(Book b : book)
            reservedRoomIds.add(b.getRoomId());
        for(Book b : book2)
            reservedRoomIds.add(b.getRoomId());

        List<Room> rooms = roomService.findAll();
        for(Integer i : reservedRoomIds){
            rooms.removeIf(room -> room.getRoomId() == i);
        }

        return new ResponseEntity<List<Room>>(rooms,HttpStatus.OK); //필터
    }

    // 예약정보 입력
    @PostMapping
    public ResponseEntity<Book> save(Book book){
        return new ResponseEntity<Book>(bookService.save(book),HttpStatus.OK);
    }

    //bookId 삭제
    @DeleteMapping(value = "/{bookId}")
    public ResponseEntity<Room> deleteRoom(@PathVariable("bookId") Integer bookId){
        bookService.deleteById(bookId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //bookId로 수정
    @PutMapping(value = {"/{bookId}"})
    public ResponseEntity<Book> updateRoom(@PathVariable("bookId") Integer bookId,Book book){
        bookService.updateById(bookId,book);
        return new ResponseEntity<Book>(book,HttpStatus.OK);
    }


}
