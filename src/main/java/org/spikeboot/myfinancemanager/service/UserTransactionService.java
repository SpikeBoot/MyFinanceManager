package org.spikeboot.myfinancemanager.service;

import org.spikeboot.myfinancemanager.entity.UserTransaction;

import java.util.List;

public interface UserTransactionService {
    public void addUserTransaction(UserTransaction userTransaction);
    public void updateUserTransaction(UserTransaction userTransaction);
    public void removeUserTransaction(int id);
    public UserTransaction getUserTransactionById(int id);
    public List<UserTransaction> getUserTransactions();
}
