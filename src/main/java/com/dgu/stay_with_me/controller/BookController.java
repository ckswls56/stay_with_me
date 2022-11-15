package com.dgu.stay_with_me.controller;

import com.dgu.stay_with_me.model.Book;
import com.dgu.stay_with_me.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Book> getBook(@PathVariable("bookId") Integer bookid){
        Optional<Book> book = bookService.findById(bookid);
        return new ResponseEntity<Book>(book.get(),HttpStatus.OK);
    }

    // 시작날짜와 끝날짜로 조회
    @GetMapping()
}
