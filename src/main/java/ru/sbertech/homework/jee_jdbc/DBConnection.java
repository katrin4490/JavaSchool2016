package ru.sbertech.homework.jee_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:h2:tcp://localhost/~/test";
    private static final String LOGIN = "sa";
    private static final String PASSWORD = "";
    public static Connection conn = null;

    public DBConnection(){
        connect();
    }

    public void connect(){
        try {
            conn = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (SQLException e){
            System.err.println("Не удается соединиться с БД h2");
        }
    }

    public static void disconnect(){
        if (conn != null){
            try{
                conn.close();
                System.out.println("Соединение с БД H2 остановлено");
            } catch (SQLException e){
                System.err.println("Не удалось закрыть соединение");
            }
        }
    }

    public static Connection newConnection()throws SQLException{
        return DriverManager.getConnection(URL, LOGIN, PASSWORD);
    }
}
