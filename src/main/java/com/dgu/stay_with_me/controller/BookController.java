package com.dgu.stay_with_me.controller;

import com.dgu.stay_with_me.model.Book;
import com.dgu.stay_with_me.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    BookService bookService;

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

    // 시작날짜와 끝날짜로 조회 시작날짜와 끝날짜 사이에있으면 조회됨.
    @GetMapping("/date")
    public ResponseEntity<Optional<Book>> getBook(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")@RequestParam(value = "start")LocalDateTime start,
                                                  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")@RequestParam(value = "end") LocalDateTime end){
        Optional<Book> book = bookService.findAllByCheckInDateAfterOrCheckOutDateBefore(start,end);
        return new ResponseEntity<Optional<Book>>(book,HttpStatus.OK);
    }
    // 예약정보 입력
    @PostMapping
    public ResponseEntity<Book> save(Book book){
        return new ResponseEntity<Book>(bookService.save(book),HttpStatus.OK);
    }


}
