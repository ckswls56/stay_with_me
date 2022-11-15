package com.dgu.stay_with_me.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

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
    @JoinColumn(name="roomId")
    private int roomId;

    @Column(nullable = false)
    private LocalDateTime checkInDate;

    @Column(nullable = false)
    private LocalDateTime checkOutDate;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String userPhone;

    @Column
    private String bookOption;

    @Column(nullable = false)
    private int bookPrice;

    @JoinColumn(name = "paymentId")
    @Column(nullable = false)
    private int paymentId;
}
