package org.spikeboot.myfinancemanager.service;

import org.spikeboot.myfinancemanager.dao.CategoryTransactionDao;
import org.spikeboot.myfinancemanager.entity.CategoryTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryTransactionServiceImpl implements CategoryTransactionService{

    private CategoryTransactionDao categoryTransactionDao;

    @Override
    @Transactional
    public void addCategoryTransaction(CategoryTransaction categoryTransaction) {
        categoryTransactionDao.addCategoryTransaction(categoryTransaction);
    }

    @Override
    @Transactional
    public void updateCategoryTransaction(CategoryTransaction categoryTransaction) {
        categoryTransactionDao.updateCategoryTransaction(categoryTransaction);
    }

    @Override
    @Transactional
    public void removeCategoryTransaction(int id) {
        categoryTransactionDao.removeCategoryTransaction(id);
    }

    @Override
    @Transactional
    public CategoryTransaction getCategoryTransactionById(int id) {
        return categoryTransactionDao.getCategoryTransactionById(id);
    }

    @Override
    @Transactional
    public List<CategoryTransaction> getCategoryTransactions() {
        return categoryTransactionDao.getCategoryTransactions();
    }

    @Override
    @Transactional
    public List<CategoryTransaction> getProfitCategoryTransactions() {
        List<CategoryTransaction> profitCategoryTransaction = categoryTransactionDao.getCategoryTransactions();
        for(CategoryTransaction i: profitCategoryTransaction){
            if(!i.getTypeTransaction()){
                profitCategoryTransaction.remove(i);
            }
        }
        return profitCategoryTransaction;
    }

    @Override
    @Transactional
    public List<CategoryTransaction> getSpendCategoryTransactions() {
        List<CategoryTransaction> spendCategoryTransaction = categoryTransactionDao.getCategoryTransactions();
        for(CategoryTransaction i: spendCategoryTransaction){
            if(i.getTypeTransaction()){
                spendCategoryTransaction.remove(i);
            }
        }
        return spendCategoryTransaction;
    }


    @Autowired
    public void setCategoryTransactionDao(CategoryTransactionDao categoryTransactionDao) {
        this.categoryTransactionDao = categoryTransactionDao;
    }
}
