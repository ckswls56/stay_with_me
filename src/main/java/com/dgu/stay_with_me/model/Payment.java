package com.dgu.stay_with_me.model;

import java.sql.Date;

public class Payment {
    private  int paymentId ; //pk
    private  int bookId ; //fk
    private  String cardNum ;
    private  String cardCompany ;
    private Date confirmedDate ;
    private  char type ;
}
