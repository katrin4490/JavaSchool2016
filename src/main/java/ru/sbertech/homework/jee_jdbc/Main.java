package ru.sbertech.homework.jee_jdbc;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        DBConnection dbConnection = new DBConnection();
       // DataConnection.createAccountTable();
        //DataConnection.createClientTable();
        //DataConnection.createDocumentTable();
        Client client = new Client(8, "Иванов Иван Иванович", false);
        DocumentManager.printHistory(client);
//        Client client2 = new Client(8, "Иванов Иван Иванович", false);
//        Client client = new Client(12, "Петров Петр Петрович", false);
//        Account account2 = new Account(11, "N1", client2, new BigDecimal(500), false);
//        Account account = new Account(22, "N2", client, new BigDecimal(1000), false);
//
//        DocumentManager.run(5, account, account2, new BigDecimal(5), "Перевод денежных средств", new Date());

        dbConnection.disconnect();
    }
}
