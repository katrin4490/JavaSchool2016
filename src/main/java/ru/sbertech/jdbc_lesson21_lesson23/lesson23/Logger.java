package ru.sbertech.jdbc_lesson21_lesson23.lesson23;

import java.sql.*;

public class Logger implements Runnable {

    public void setStr(String str) {
        this.str = str;
    }

    String str;

    @Override
    public void run() {
        try (Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {


            PreparedStatement preparedStatement = conn.prepareStatement("insert into log(STR) values (?)");

            preparedStatement.setString(1, str);

            preparedStatement.execute();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
