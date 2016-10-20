package Main;

import jdbc.*;
import logic.Account;
import logic.Client;
import logic.Document;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClientDao clientDao = utilContext.getApplicationContext().getBean(ClientDaoImpl.class);
        AccountDao accountDao = utilContext.getApplicationContext().getBean(AccountDaoImpl.class);
        DocumentDao documentDao = utilContext.getApplicationContext().getBean(DocumentDaoImpl.class);

//        Client client =  utilContext.getApplicationContext().getBean(Client.class);
//        client.setName("Петров Иван Иванович");
//        clientDao.saveIntoDb(client);
//
//        Client client2 =  utilContext.getApplicationContext().getBean(Client.class);
//        client2.setName("Сидоров Петр Алксеевич");
//        clientDao.saveIntoDb(client2);
//
//        Account accDT =  utilContext.getApplicationContext().getBean(Account.class);
//        Account accCT =  utilContext.getApplicationContext().getBean(Account.class);
//        accDT.setData("125478", client, BigDecimal.valueOf(2000.00));
//        accCT.setData("254789", client2, BigDecimal.valueOf(1000.00));
//        accountDao.saveIntoDb(accDT);
//        accountDao.saveIntoDb(accCT);
//
//        Document document = utilContext.getApplicationContext().getBean(Document.class);
//        document.setData(accDT, accCT, BigDecimal.valueOf(500.00), "Перевод средств....", new Date());
//        documentDao.saveIntoDb(document);


        List<Account> accounts = accountDao.getAccountList();
        for(Account account : accounts){
            System.out.println(account.toString());
        }

        System.out.println("--------------------------------------------");

        List<Document> documents = documentDao.getDocumentList();
        System.out.println("operations:");
        for(Document doc : documents){
            System.out.println("Client DT : " + doc.getAccDT().getClient().getName() + " will receive " + doc.getSumma());
            System.out.println("Client CT : " + doc.getAccCT().getClient().getName()+ " will give " + doc.getSumma());
//            doc.moneyTransfer();
//            accountDao.saveIntoDb(doc.getAccDT());
//            accountDao.saveIntoDb(doc.getAccCT());
//            documentDao.saveIntoDb(doc);
        }

        System.out.println("--------------------------------------------------");
        accounts = accountDao.getAccountList();
        for(Account account : accounts){
            System.out.println(account.toString());
        }
    }
}
