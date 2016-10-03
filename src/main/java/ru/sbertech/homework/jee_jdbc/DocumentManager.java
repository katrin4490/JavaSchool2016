package ru.sbertech.homework.jee_jdbc;

// id long
//         account accDT (счет по дебету - с котрого спесивывется)
//         account accCT (счет по кредиту, куда списываются)
//         summa bigdecimal
//         naz string (назначение платежа)
//         docDate date (дата документа)

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Date;

public class DocumentManager {

    public static Document run(long id, Account accDT, Account accCT, BigDecimal summa, String purpose, Date date){

        BigDecimal s = DataConnection.getAccountSaldoById(accDT.getId());
        if (summa.compareTo(s) == 1) {
            System.out.println("Недостаточно средств на счете " + accDT.getAccNumber());
            return null;
        }
        try (Connection conn = DBConnection.newConnection()){
            conn.setAutoCommit(false);
            Savepoint savepoint = conn.setSavepoint("SAVE POINT DOCUMENT");
            if (!DataConnection.reduceSaldoByIdAccount(accDT.getId(), summa)){
                conn.rollback(savepoint);
                System.err.println("Ошибка проводки документа: " + purpose);
                return null;
            }
            if (!DataConnection.addedSaldoByIdAccount(accCT.getId(), summa)){
                conn.rollback(savepoint);
                System.err.println("Ошибка проводки документа: " + purpose);
                return null;
            }
            if (!DataConnection.insertDocument(id, accDT.getId(), accCT.getId(), summa, purpose, date)){
                conn.rollback(savepoint);
                System.err.println("Ошибка проводки документа: " + purpose);
                return null;
            }
            conn.commit();
            conn.close();
            System.out.println("Документ: " + purpose + " успешно проведен!");
            Document document = new Document(id, accDT, accCT, summa, purpose, date);
            return document;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void printHistory(Client client){
        ResultSet resultSetCredit = DataConnection.getHistoryCreditClient(client.getId());
        ResultSet resultSetDebit = DataConnection.getHistoryDebitClient(client.getId());
        return;
//        if (resultSetCredit == null || resultSetDebit == null){
//            System.out.println("По клиенту: " + client.getName() + "   нет никаких операций");
//            return;
//        }
//        try {
//            System.out.println("Выписка по клиенту: " + client.getName() + " :");
//            while (resultSetCredit.next()) {
//                System.out.println("Номер счета: " + resultSetCredit.getString("number"));
//                System.out.println("Тип операции: Зачисление");
//                System.out.println("Сумма: " + resultSetCredit.getBigDecimal("summa"));
//            }
//
//            while (resultSetDebit.next()) {
//                System.out.println("Номер счета: " + resultSetDebit.getString("number"));
//                System.out.println("Тип операции: Снятие");
//                System.out.println("Сумма: " + resultSetDebit.getBigDecimal("summa"));
//            }
//
////            System.out.println("");
////            System.out.println("Остаток : " + resultSetDebit.getBigDecimal("summa"));
//        } catch (SQLException e){
//            e.printStackTrace();
//        }
    }
}
