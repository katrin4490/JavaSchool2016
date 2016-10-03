package ru.sbertech.homework.jee_jdbc;

// id long
//         account accDT (счет по дебету - с котрого спесивывется)
//         account accCT (счет по кредиту, куда списываются)
//         summa bigdecimal
//         naz string (назначение платежа)
//         docDate date (дата документа)

import java.math.BigDecimal;
import java.util.Date;

public class DocumentManager {

    public static Document run(long id, Account accDT, Account accCT, BigDecimal summa, String purpose, Date date){

        BigDecimal s = DataConnection.getAccountSaldoById(accDT.getId());
        if (summa.compareTo(s) == 1) {
            System.out.println("Недостаточно средств на счете " + accDT.getAccNumber());
            return null;
        }
        if (DataConnection.insertDocument(id, accDT.getId(), accCT.getId(), summa, purpose, date)) {
            Document document = new Document(id, accDT, accCT, summa, purpose, date);
            return document;
        }
        return null;
    }
}
