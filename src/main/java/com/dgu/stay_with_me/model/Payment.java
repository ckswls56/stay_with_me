package com.dgu.stay_with_me.model;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본키 생성 데이터베이스에 위임
    @Column(name="paymentId")
    private int paymentId ; //pk

    @Column(nullable = false)
    @JoinColumn(name="bookId")
    private  int bookId ; //fk

    @Column(nullable = false)
    private  String cardNum ;

    @Column(nullable = false)
    private  String cardCompany ;

    @CreationTimestamp
    private Date confirmedDate ;

    @ColumnDefault("true")
    private Boolean type ; // 1이면 예약 0이면 취소

}
