package com.dgu.stay_with_me.service;

import com.dgu.stay_with_me.model.Book;
import com.dgu.stay_with_me.model.Room;
import com.dgu.stay_with_me.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    // 모든 예약 정보
    public List<Book> findAll(){
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(e->books.add(e));
        return books;
    }

    // bookId로 조회
    public Optional<Book> findById(int bookId){
        Optional<Book> book = bookRepository.findById(bookId);
        return book;
    }
    
    // checkIn , checkOut 기준으로 조회
    public Optional<Book> findAllByCheckInDateAfterOrCheckOutDateBefore(LocalDateTime start, LocalDateTime end){
        Optional<Book> book = bookRepository.findAllByCheckInDateAfterOrCheckOutDateBefore(start,end);
        return book;
    }
    
    // username 으로 조회
    public Optional<Book> findByUserName(String userName){
        Optional<Book> book = bookRepository.findByUserName(userName);
        return book;
    }

    public void deleteById(int bookId){
        bookRepository.deleteById(bookId);
    }

    public Book save(Book book){
        bookRepository.save(book);
        return book;
    }

    public void updateById(int bookId, Book book){
        Optional<Book> e = bookRepository.findById(bookId);

        if(e.isPresent()){
            e.get().setBookId(book.getBookId());
            e.get().setRoomId(book.getRoomId());
            e.get().setCheckInDate(book.getCheckInDate());
            e.get().setCheckOutDate(book.getCheckOutDate());
            e.get().setUserName(book.getUserName());
            e.get().setUserPhone(book.getUserPhone());
            e.get().setBookOption(book.getBookOption());
            e.get().setBookPrice(book.getBookPrice());
            e.get().setPaymentId(book.getPaymentId());
        }
    }



}
