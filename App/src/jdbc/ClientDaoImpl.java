package jdbc;

import logic.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ClientDaoImpl implements ClientDao{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void save(Client client) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(client);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Client client){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(client);
        tx.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Client> getByName(String clientName){
        Session session = this.sessionFactory.openSession();
        List<Client> clients = session.createQuery("from Client where name = :name")
                .setParameter("name", clientName).list();
        session.close();
        return clients;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Client> getClients() {
        Session session = this.sessionFactory.openSession();
        List<Client> personList = session.createQuery("from Client").list();
        session.close();
        return personList;
    }

    @Override
    public void delete(Client client){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(client);
        tx.commit();
        session.close();
    }
}