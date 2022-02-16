package org.spikeboot.myfinancemanager;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.spikeboot.myfinancemanager.dao.CategoryTransactionDaoImpl;
import org.spikeboot.myfinancemanager.dao.UserTransactionDaoImpl;
import org.spikeboot.myfinancemanager.entity.CategoryTransaction;
import org.spikeboot.myfinancemanager.entity.UserTransaction;


public class Test {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(UserTransaction.class)
                .addAnnotatedClass(CategoryTransaction.class)
                .buildSessionFactory();

        CategoryTransactionDaoImpl categoryTransactionDao = new CategoryTransactionDaoImpl();
        UserTransactionDaoImpl userTransactionDao = new UserTransactionDaoImpl();

        categoryTransactionDao.setSessionFactory(sessionFactory);
        userTransactionDao.setSessionFactory(sessionFactory);

        CategoryTransaction categoryTransactionZarplata = categoryTransactionDao.getCategoryTransactionById(1);

        UserTransaction userTransaction = new UserTransaction();
        userTransaction.setTypeTransaction(true);
        userTransaction.setCategoryTransaction(categoryTransactionZarplata);
        userTransaction.setDescription("Moya pervaya ZP v IT");
        userTransaction.setValue(800);

        userTransactionDao.addUserTransaction(userTransaction);

        }
}
