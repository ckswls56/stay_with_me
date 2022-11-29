package com.dgu.stay_with_me.repository;

import com.dgu.stay_with_me.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    public List<Book> findAllByCheckInDateBetween(LocalDateTime start, LocalDateTime end);
    public List<Book> findAllByCheckOutDateBetween(LocalDateTime start, LocalDateTime end);
    List<Book> findAllByCheckInDateBeforeAndCheckOutDateAfter(LocalDateTime start, LocalDateTime end);
    public Optional<Book> findByUserName(String userName);
    public Optional<Book> findByBookIdAndCardNum(int bookId,String cardNum);

}
