package com.dgu.stay_with_me;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCTest {

    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testConnection(){
        try(Connection con = DriverManager.getConnection(

                "jdbc:mysql://localhost:3306/hotel","root","As000712!")){

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
