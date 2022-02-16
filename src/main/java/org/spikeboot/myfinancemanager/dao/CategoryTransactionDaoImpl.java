package org.spikeboot.myfinancemanager.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.spikeboot.myfinancemanager.entity.CategoryTransaction;
import org.spikeboot.myfinancemanager.entity.UserTransaction;

import java.util.List;

public class CategoryTransactionDaoImpl implements CategoryTransactionDao {

    SessionFactory sessionFactory;

    @Override
    public void addCategoryTransaction(CategoryTransaction categoryTransaction) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(categoryTransaction);
        session.getTransaction().commit();
    }

    @Override
    public void updateCategoryTransaction(CategoryTransaction categoryTransaction) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(categoryTransaction);
        session.getTransaction().commit();
    }

    @Override
    public void removeCategoryTransaction(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        CategoryTransaction categoryTransaction = session.get(CategoryTransaction.class, id);
        if (categoryTransaction != null) {
            session.delete(categoryTransaction);
        }
        session.getTransaction().commit();
    }

    @Override
    public CategoryTransaction getCategoryTransactionById(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        CategoryTransaction categoryTransaction = session.get(CategoryTransaction.class, id);
        session.getTransaction().commit();

        return categoryTransaction;
    }

    @Override
    public List<CategoryTransaction> getCategoryTransactions() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        String HQL = "FROM CategoryTransaction";
        List<CategoryTransaction> categoryTransactions = session.createQuery(HQL).getResultList();
        session.getTransaction().commit();

        return categoryTransactions;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
