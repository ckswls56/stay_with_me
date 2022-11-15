package com.dgu.stay_with_me.repository;

import com.dgu.stay_with_me.model.Book;
import net.bytebuddy.asm.Advice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    public Optional<Book> findById(int bookId);
    public Optional<Book> findAllByCheckInDateAfterOrCheckOutDateBefore(LocalDateTime start, LocalDateTime end);
    public Optional<Book> findByUserName(String userName);
}
