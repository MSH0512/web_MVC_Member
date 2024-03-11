package com.example.jdbcex.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTests {
    @Test
    public void test1(){
        int v1= 10;
        int v2 =10;
        Assertions.assertEquals(v1,v2);
    }
    @Test
    public void testConnection() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");


        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb?serverTimezone=Asia/Seoul","root","2015krfebctp@@");
        Assertions.assertNotNull(conn);
        conn.close();

    }
}