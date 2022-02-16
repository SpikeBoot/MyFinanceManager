package org.spikeboot.myfinancemanager.dao;

import org.spikeboot.myfinancemanager.entity.CategoryTransaction;
import org.spikeboot.myfinancemanager.entity.UserTransaction;

import java.util.List;

public interface CategoryTransactionDao {
    public void addCategoryTransaction(CategoryTransaction categoryTransaction);
    public void updateCategoryTransaction(CategoryTransaction categoryTransaction);
    public void removeCategoryTransaction(int id);
    public CategoryTransaction getCategoryTransactionById(int id);
    public List<CategoryTransaction> getCategoryTransactions();
}
