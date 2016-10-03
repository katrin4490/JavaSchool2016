package ru.sbertech.homework.jee_jdbc;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        DBConnection dbConnection = new DBConnection();
        DataConnection.createAccountTable();
        DataConnection.createClientTable();
        DataConnection.createDocumentTable();

        Client client = new Client(3, "Иванов Иван Иванович");
        DataConnection.insertClient(client.getId(), client.getName());

        Client client2 = new Client(4, "Петров Петр Петрович");
        DataConnection.insertClient(client2.getId(), client2.getName());

        Account account = new Account(1, "N1", client, new BigDecimal(500));
        DataConnection.insertAccount(account.getId(), account.getSaldo(), account.getAccNumber(), account.getClient().getId());

        Account account2 = new Account(2, "N2", client2, new BigDecimal(1000));
        DataConnection.insertAccount(account2.getId(), account2.getSaldo(), account2.getAccNumber(), account2.getClient().getId());

        DocumentManager.run(1, account, account2, new BigDecimal(800), "Перевод денежных средств", new Date());

        dbConnection.disconnect();
    }
}
