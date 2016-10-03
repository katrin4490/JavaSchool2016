package ru.sbertech.homework.jee_jdbc;


import java.math.BigDecimal;
import java.sql.*;
import java.util.Date;

public class DataConnection {
    private static final String CLIENT_TABLE = "CLIENT";
    private static final String ACCOUNT_TABLE = "ACCOUNT";
    private static final String DOCUMENT_TABLE = "DOCUMENT";

    public static boolean createClientTable() {
        try (PreparedStatement preparedStatement = DBConnection.conn.prepareStatement("create table " + CLIENT_TABLE + " (id BIGINT PRIMARY KEY AUTO_INCREMENT, name varchar2(2000))");) {
            preparedStatement.execute();
            preparedStatement.close();
            return true;
        } catch (SQLException e){
            System.err.println("Не удалось создать таблицу: " + CLIENT_TABLE);
            return false;
    }
    }
    public static boolean createAccountTable() {
        try (PreparedStatement preparedStatement = DBConnection.conn.prepareStatement("create table " + ACCOUNT_TABLE + " (id BIGINT PRIMARY KEY AUTO_INCREMENT, saldo DECIMAL, number VARCHAR2(2000), idClient BIGINT)")) {
            preparedStatement.execute();
            preparedStatement.close();
            return true;
        } catch (SQLException e){
            System.err.println("Не удалось создать таблицу: " + ACCOUNT_TABLE);
            return false;
        }
    }
    public static boolean createDocumentTable() {
        try (PreparedStatement preparedStatement = DBConnection.conn.prepareStatement("create table " + DOCUMENT_TABLE + " (id BIGINT PRIMARY KEY AUTO_INCREMENT, accDT BIGINT, accCT BIGINT, summa DECIMAL, purpose VARCHAR2(2000), date DATE)")) {
            preparedStatement.execute();
            preparedStatement.close();
            return true;
        } catch (SQLException e){
            System.err.println("Не удалось создать таблицу: " + DOCUMENT_TABLE);
            return false;
        }
    }

    public static boolean insertClient(long id, String name) {
        try (PreparedStatement preparedStatement = DBConnection.conn.prepareStatement("insert into " + CLIENT_TABLE + " (id , name) values(?, ?)")) {
            preparedStatement.setLong(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.execute();
            preparedStatement.close();
            return true;
        } catch (SQLException e){
            System.err.println("Ошибка добавления данных в таблицу: " + CLIENT_TABLE);
            return false;
        }
    }
    public static boolean insertAccount(long id, BigDecimal saldo, String number, long idClient) {
        try (PreparedStatement preparedStatement = DBConnection.conn.prepareStatement("insert into " + ACCOUNT_TABLE + " (id , saldo, number, idClient) values(?, ?, ?, ?)")) {
            preparedStatement.setLong(1, id);
            preparedStatement.setBigDecimal(2, saldo);
            preparedStatement.setString(3, number);
            preparedStatement.setLong(4, idClient);
            preparedStatement.execute();
            preparedStatement.close();
            return true;
        } catch (SQLException e){
            System.err.println("Ошибка добавления данных в таблицу: " + ACCOUNT_TABLE);
            return false;
        }
    }
    public static boolean insertDocument(long id, long accDT,long accCT,BigDecimal summa, String purpose, Date date) {
        try (PreparedStatement preparedStatement = DBConnection.conn.prepareStatement("insert into " + DOCUMENT_TABLE + " (id , accDT, accCT, summa, purpose, date) values(?, ?, ?, ?, ?, ?)")) {
            preparedStatement.setLong(1, id);
            preparedStatement.setLong(2, accDT);
            preparedStatement.setLong(3, accCT);
            preparedStatement.setBigDecimal(4, summa);
            preparedStatement.setString(5, purpose);
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            preparedStatement.setDate(6, sqlDate);
            preparedStatement.execute();
            preparedStatement.close();
            return true;
        } catch (SQLException e){
            System.err.println("Ошибка добавления данных в таблицу: " + DOCUMENT_TABLE);
            return false;
        }
    }

    public static BigDecimal getAccountSaldoById(long id) {
        try (PreparedStatement preparedStatement = DBConnection.conn.prepareStatement("SELECT saldo FROM " + ACCOUNT_TABLE + " WHERE id = ?")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getBigDecimal("saldo");
            } else {
                return null;
            }
        } catch (SQLException e){
            System.err.println("Ошибка получения данных с таблицы: " + ACCOUNT_TABLE);
            return null;
        }
    }
}
