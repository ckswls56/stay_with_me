package com.dgu.stay_with_me.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본키 생성 데이터베이스에 위임
    @Column(name="bookId")
    private int bookId; //pk

    @Column(nullable = false)
    private int roomId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false)
    private LocalDateTime checkInDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false)
    private LocalDateTime checkOutDate;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String userPhone;

    @Column
    private String bookOption;

    @Column()
    private int bookPrice;

    @Column(nullable = false)
    private  String cardNum ;

    @Column(nullable = false)
    private  String cardCompany ;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @UpdateTimestamp
    private LocalDateTime confirmedDate ;
}
