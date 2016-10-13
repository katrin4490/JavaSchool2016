package jdbc;

import logic.Account;
import logic.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class AccountDaoImpl implements AccountDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Account account) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(account);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Account account){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(account);
        tx.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Account> getByClient(Client client){
        Session session = this.sessionFactory.openSession();
        List<Account> accounts = session.createQuery("from Account where client = :client")
                .setParameter("client", client).list();
        session.close();
        return accounts;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Account> getAccounts() {
        Session session = this.sessionFactory.openSession();
        List<Account> accountList = session.createQuery("from Account").list();
        session.close();
        return accountList;
    }

    @Override
    public void delete(Account account){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(account);
        tx.commit();
        session.close();
    }
}
