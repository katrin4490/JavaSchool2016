package ru.sbertech.jdbc_lesson21_lesson23.lesson23;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        try (Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {

//            System.out.println("TYPE_FORWARD_ONLY = " + conn.getMetaData().supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY));
//            System.out.println("TYPE_SCROLL_INSENSITIVE = " + conn.getMetaData().supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE));
//            System.out.println("TYPE_SCROLL_SENSITIVE = " + conn.getMetaData().supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE));

            Statement statement = conn.createStatement();
            conn.setAutoCommit(false);

            PreparedStatement preparedStatement = conn.prepareStatement("insert into songs(NAME) values (?)");

            Savepoint savepoint = conn.setSavepoint("MY FIRST SAVE POINT");

            preparedStatement.setString(1, "MySong");
            preparedStatement.execute();

            //Logger logger = new Logger();
            //logger.setStr("MySong2");
//            Thread t = new Thread(logger);
//            t.start();
//            try {
//                t.join();
//            } catch (InterruptedException e){
//                e.printStackTrace();
//            }

            conn.rollback(savepoint);

            preparedStatement.setString(1, "MySong2");
            preparedStatement.execute();

            //conn.rollback();
            conn.commit();

            conn.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
