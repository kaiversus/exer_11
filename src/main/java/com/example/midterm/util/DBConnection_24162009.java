package com.example.midterm.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection_24162009 {
    private static final String URL = "jdbc:mysql://localhost:3306/MidtermDB?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASS = "123456";

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
