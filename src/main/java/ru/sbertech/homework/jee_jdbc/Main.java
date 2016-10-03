package ru.sbertech.homework.jee_jdbc;

import java.math.BigDecimal;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        DBConnection dbConnection = new DBConnection();
        DataConnection.createAccountTable();
        DataConnection.createClientTable();
        DataConnection.createDocumentTable();

        Client client1 = new Client(1, "Петров Петр Петрович");
        Account account1 = new Account(1, "001", client1, new BigDecimal(1000));

        Client client2 = new Client(2, "Иванов Иван Иванович");
        Account account2 = new Account(2, "002", client2, new BigDecimal(500));

        DocumentManager.run(1, account1, account2, new BigDecimal(150), "Операция перевода денежных средств", new Date());

        System.out.println("Выписка для клиента: " + client1.getName());
        DocumentManager.printHistory(client1);
        System.out.println("////////////////////////////////////////////////////");
        System.out.println("Выписка для клиента: " + client2.getName());
        DocumentManager.printHistory(client2);

        dbConnection.disconnect();
    }
}
