package org.spikeboot.myfinancemanager.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.spikeboot.myfinancemanager.entity.UserTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserTransactionDaoImpl implements UserTransactionDao {

    private SessionFactory sessionFactory;

    @Override
    public void addUserTransaction(UserTransaction userTransaction) {
        Session session = sessionFactory.getCurrentSession();
        session.save(userTransaction);
    }

    @Override
    public void updateUserTransaction(UserTransaction userTransaction) {
        Session session = sessionFactory.getCurrentSession();
        session.update(userTransaction);
    }

    @Override
    public void removeUserTransaction(int id) {
        Session session = sessionFactory.getCurrentSession();
        UserTransaction userTransaction = session.get(UserTransaction.class, id);
        if (userTransaction != null) {
            session.delete(userTransaction);
        }
    }

    @Override
    public UserTransaction getUserTransactionById(int id) {
        Session session = sessionFactory.getCurrentSession();
        UserTransaction userTransaction = session.get(UserTransaction.class, id);

        return userTransaction;
    }

    @Override
    public List<UserTransaction> getUserTransactions() {
        Session session = sessionFactory.getCurrentSession();
        String HQL = "FROM UserTransaction";
        List<UserTransaction> userTransactions = session.createQuery(HQL).getResultList();

        return userTransactions;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
