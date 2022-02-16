package org.spikeboot.myfinancemanager.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.spikeboot.myfinancemanager.entity.UserTransaction;

import java.util.List;

public class UserTransactionDaoImpl implements UserTransactionDao {

    private SessionFactory sessionFactory;

    @Override
    public void addUserTransaction(UserTransaction userTransaction) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(userTransaction);
        session.getTransaction().commit();
    }

    @Override
    public void updateUserTransaction(UserTransaction userTransaction) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(userTransaction);
        session.getTransaction().commit();
    }

    @Override
    public void removeUserTransaction(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        UserTransaction userTransaction = session.get(UserTransaction.class, id);

        if (userTransaction != null) {
            session.delete(userTransaction);
        }

        session.getTransaction().commit();
    }

    @Override
    public UserTransaction getUserTransactionById(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        UserTransaction userTransaction = session.get(UserTransaction.class, id);
        session.getTransaction().commit();

        return userTransaction;
    }

    @Override
    public List<UserTransaction> getUserTransactions() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        String HQL = "FROM UserTransaction";
        List<UserTransaction> userTransactions = session.createQuery(HQL).getResultList();
        session.getTransaction().commit();

        return userTransactions;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
