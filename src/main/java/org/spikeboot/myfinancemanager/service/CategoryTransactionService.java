package org.spikeboot.myfinancemanager.service;

import org.spikeboot.myfinancemanager.entity.CategoryTransaction;

import java.util.List;

public interface CategoryTransactionService {
    public void addCategoryTransaction(CategoryTransaction categoryTransaction);
    public void updateCategoryTransaction(CategoryTransaction categoryTransaction);
    public void removeCategoryTransaction(int id);
    public CategoryTransaction getCategoryTransactionById(int id);
    public List<CategoryTransaction> getCategoryTransactions();
}
