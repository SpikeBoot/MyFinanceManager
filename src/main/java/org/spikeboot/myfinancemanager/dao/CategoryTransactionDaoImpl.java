package org.spikeboot.myfinancemanager.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.spikeboot.myfinancemanager.entity.CategoryTransaction;
import org.spikeboot.myfinancemanager.entity.UserTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CategoryTransactionDaoImpl implements CategoryTransactionDao {

    private SessionFactory sessionFactory;

    @Override
    public void addCategoryTransaction(CategoryTransaction categoryTransaction) {
        Session session = sessionFactory.getCurrentSession();
        session.save(categoryTransaction);
    }

    @Override
    public void updateCategoryTransaction(CategoryTransaction categoryTransaction) {
        Session session = sessionFactory.getCurrentSession();
        session.update(categoryTransaction);
    }

    @Override
    public void removeCategoryTransaction(int id) {
        Session session = sessionFactory.getCurrentSession();
        CategoryTransaction categoryTransaction = session.get(CategoryTransaction.class, id);
        if (categoryTransaction != null) {
            session.delete(categoryTransaction);
        }
    }

    @Override
    public CategoryTransaction getCategoryTransactionById(int id) {
        Session session = sessionFactory.getCurrentSession();
        CategoryTransaction categoryTransaction = session.get(CategoryTransaction.class, id);

        return categoryTransaction;
    }

    @Override
    public List<CategoryTransaction> getCategoryTransactions() {
        Session session = sessionFactory.getCurrentSession();
        String HQLQuery = "FROM CategoryTransaction";
        List<CategoryTransaction> categoryTransactions = session.createQuery(HQLQuery).getResultList();

        return categoryTransactions;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
