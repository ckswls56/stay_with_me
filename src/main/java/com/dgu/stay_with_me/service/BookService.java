package com.dgu.stay_with_me.service;

import com.dgu.stay_with_me.model.Book;
import com.dgu.stay_with_me.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Optional<Book> findByBookIdAndCardNum(int bookId, String cardNum){
        Optional<Book> book = bookRepository.findByBookIdAndCardNum(bookId,cardNum);
        return book;
    }
    
    // checkIn기준으로 조회
    public List<Book> findAllByCheckInDateBetween(LocalDateTime start, LocalDateTime end){
        List<Book> book = bookRepository.findAllByCheckInDateBetween(start,end);
        return book;
    }

    // checkOut기준으로 조회
    public List<Book> findAllByCheckOutDateBetween(LocalDateTime start, LocalDateTime end){
        List<Book> book = bookRepository.findAllByCheckOutDateBetween(start,end);
        return book;
    }
    public List<Book> findAllByCheckInDateBeforeAndCheckOutDateAfter(LocalDateTime start, LocalDateTime end){
        List<Book> book = bookRepository.findAllByCheckInDateBeforeAndCheckOutDateAfter(start,end);
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
            //e.get().setBookId(book.getBookId());
            e.get().setRoomId(book.getRoomId());
            e.get().setCheckInDate(book.getCheckInDate());
            e.get().setCheckOutDate(book.getCheckOutDate());
            e.get().setUserName(book.getUserName());
            e.get().setUserPhone(book.getUserPhone());
            e.get().setBookOption(book.getBookOption());
            e.get().setBookPrice(book.getBookPrice());
            e.get().setCardNum(book.getCardNum());
            e.get().setCardCompany(book.getCardCompany());
            //e.get().setConfirmedDate(book.getConfirmedDate());
            bookRepository.save(e.get());
        }
    }



}
