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
            return true;
        } catch (SQLException e){
            System.err.println("Не удалось создать таблицу: " + CLIENT_TABLE);
            return false;
    }
    }
    public static boolean createAccountTable() {
        try (PreparedStatement preparedStatement = DBConnection.conn.prepareStatement("create table " + ACCOUNT_TABLE + " (id BIGINT PRIMARY KEY AUTO_INCREMENT, saldo DECIMAL, number VARCHAR2(2000), idClient BIGINT)")) {
            preparedStatement.execute();
            return true;
        } catch (SQLException e){
            System.err.println("Не удалось создать таблицу: " + ACCOUNT_TABLE);
            return false;
        }
    }
    public static boolean createDocumentTable() {
        try (PreparedStatement preparedStatement = DBConnection.conn.prepareStatement("create table " + DOCUMENT_TABLE + " (id BIGINT PRIMARY KEY AUTO_INCREMENT, accDT BIGINT, accCT BIGINT, summa DECIMAL, purpose VARCHAR2(2000), date DATE)")) {
            preparedStatement.execute();
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
    public static boolean reduceSaldoByIdAccount(long id, BigDecimal reduceSaldo) {
        try (PreparedStatement preparedStatement = DBConnection.conn.prepareStatement("UPDATE " + ACCOUNT_TABLE + " SET saldo = saldo - ? WHERE id = ?")) {
            preparedStatement.setBigDecimal(1, reduceSaldo);
            preparedStatement.setLong(2, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e){
            System.err.println("Не удалось снять : " + reduceSaldo + " с счета ID = " + id);
            return false;
        }
    }
    public static boolean addedSaldoByIdAccount(long id, BigDecimal reduceSaldo) {
        try (PreparedStatement preparedStatement = DBConnection.conn.prepareStatement("UPDATE " + ACCOUNT_TABLE + " SET saldo = saldo + ? WHERE id = ?")) {
            preparedStatement.setBigDecimal(1, reduceSaldo);
            preparedStatement.setLong(2, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e){
            System.err.println("Не удалось зачислить : " + reduceSaldo + " на счет ID = " + id);
            return false;
        }
    }

    public static void printHistoryCreditClient(long idClient) {
        try (PreparedStatement preparedStatement = DBConnection.conn.prepareStatement(
                "SELECT " + CLIENT_TABLE + ".id, " + CLIENT_TABLE + ".name, " + ACCOUNT_TABLE + ".number, " + DOCUMENT_TABLE + ".summa, " + ACCOUNT_TABLE + ".saldo" +
                " FROM "+ CLIENT_TABLE + " INNER JOIN " + ACCOUNT_TABLE + " ON " + CLIENT_TABLE + ".id = " + ACCOUNT_TABLE + ".idclient" +
                " INNER JOIN " + DOCUMENT_TABLE + " ON " +DOCUMENT_TABLE + ".accCT = " + ACCOUNT_TABLE + ".id" +
                " WHERE "+ CLIENT_TABLE + ".id = ?"

        )) {
            preparedStatement.setLong(1, idClient);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("-----------------------");
                System.out.println("Номер счета: " + resultSet.getString("number"));
                System.out.println("Тип операции: Зачисление");
                System.out.println("Сумма: " + resultSet.getBigDecimal("summa"));
            }
           // return preparedStatement.executeQuery();
            //ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                return resultSet;
//            } else {
//                return null;
//            }
        } catch (SQLException e){
            System.err.println("Ошибка распечатки высписки по клиенту ID = " + idClient);
        }
    }
    public static void printHistoryDebitClient(long idClient) {
        try (PreparedStatement preparedStatement = DBConnection.conn.prepareStatement(
                "SELECT " + CLIENT_TABLE + ".id, " + CLIENT_TABLE + ".name, " + ACCOUNT_TABLE + ".number, " + DOCUMENT_TABLE + ".summa, " + ACCOUNT_TABLE + ".saldo" +
                        " FROM "+ CLIENT_TABLE + " INNER JOIN " + ACCOUNT_TABLE + " ON " + CLIENT_TABLE + ".id = " + ACCOUNT_TABLE + ".idclient" +
                        " INNER JOIN " + DOCUMENT_TABLE + " ON " +DOCUMENT_TABLE + ".accDT = " + ACCOUNT_TABLE + ".id" +
                        " WHERE "+ CLIENT_TABLE + ".id = ?"

        )) {
            preparedStatement.setLong(1, idClient);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("-----------------------");
                System.out.println("Номер счета: " + resultSet.getString("number"));
                System.out.println("Тип операции: Снятие");
                System.out.println("Сумма: " + resultSet.getBigDecimal("summa"));
            }
            //return preparedStatement.executeQuery();
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                return resultSet;
//            } else {
//                return null;
//            }
        } catch (SQLException e){
            System.err.println("Ошибка распечатки высписки по клиенту ID = " + idClient);

        }
    }

    public static Client getClientById(long id) {
        try (PreparedStatement preparedStatement = DBConnection.conn.prepareStatement("SELECT * FROM " + CLIENT_TABLE + " WHERE id = ?")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                Client client = new Client(id, resultSet.getString("name"));
                return client;
            }
            return null;
        } catch (SQLException e){
            System.err.println("Не найти в БД клиента с ID = " + id);
            return null;
        }
    }
    public static Account getAccountById(long id) {
        try (PreparedStatement preparedStatement = DBConnection.conn.prepareStatement("SELECT * FROM " + ACCOUNT_TABLE + " WHERE id = ?")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                Client client = getClientById(resultSet.getLong("idClient"));
                Account account = new Account(id,  resultSet.getString("number"), client, resultSet.getBigDecimal("saldo"));
                return account;
            }
            return null;
        } catch (SQLException e){
            System.err.println("Не найти в БД счет с ID = " + id);
            return null;
        }
    }

    public static boolean updateClient(String name) {
        try (PreparedStatement preparedStatement = DBConnection.conn.prepareStatement("UPDATE " + CLIENT_TABLE + " SET name = ? WHERE id = ?)")) {
            preparedStatement.setString(1, name);
            preparedStatement.execute();
            return true;
        } catch (SQLException e){
            System.err.println("Ошибка обновления данных в таблице: " + CLIENT_TABLE);
            return false;
        }
    }
}
