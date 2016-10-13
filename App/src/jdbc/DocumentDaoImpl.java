package jdbc;


import logic.Account;
import logic.Document;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class DocumentDaoImpl implements DocumentDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Document document) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(document);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Document document){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(document);
        tx.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Document> getByAccDT(Account account){
        Session session = this.sessionFactory.openSession();
        List<Document> documents = session.createQuery("from Document where accDT = :account")
                .setParameter("account", account).list();
        session.close();
        return documents;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Document> getByAccCT(Account account){
        Session session = this.sessionFactory.openSession();
        List<Document> documents = session.createQuery("from Document where accCT = :account")
                .setParameter("account", account).list();
        session.close();
        return documents;
    }

    @Override
    public List<Document> getDocuments() {
        Session session = this.sessionFactory.openSession();
        List<Document> documentList = session.createQuery("from Document").list();
        session.close();
        return documentList;
    }

    @Override
    public void delete(Document document){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(document);
        tx.commit();
        session.close();
    }
}