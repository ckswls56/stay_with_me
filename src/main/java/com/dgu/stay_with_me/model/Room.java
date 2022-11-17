package com.dgu.stay_with_me.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본키 생성 데이터베이스에 위임
    @Column(name="roomId")
    private int roomId;

    @Column(nullable = false)
    private String roomName;

    @Column(nullable = false)
    private int roomPrice;

    @Column(nullable = false)
    private int roomCapacity;

    @Column(nullable = false)
    private String roomDetail;
}
