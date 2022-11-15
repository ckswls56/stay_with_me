package com.dgu.stay_with_me.model;

import java.sql.Date;

public class Book {
    private int bookId; //pk
    private int roomId;
    private Date checkInDate;
    private Date checkOutDate;
    private String userName;
    private String userPhone;
    private String bookOption;
    private int bookPrice;
    private int paymentId;
}
