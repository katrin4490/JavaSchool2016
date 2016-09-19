package ru.sbertech.jdbc_lesson21;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        try (Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from songs where id=25");
            while (resultSet.next()){
                System.out.println("Song Name: " + resultSet.getString("name")
                                 + " Time: " + resultSet.getBigDecimal("song_time"));
            }

            PreparedStatement preparedStatement = conn.prepareStatement("select * from songs where id = ?");
            preparedStatement.setString(1, "25");

            ResultSet resultSet1 = preparedStatement.executeQuery();
            while (resultSet1.next()){
                System.out.println("Song Name: " + resultSet1.getString("name")
                        + " Time: " + resultSet1.getBigDecimal("song_time"));
            }

            conn.close();
            System.out.println("OK");
        }


    }
}
