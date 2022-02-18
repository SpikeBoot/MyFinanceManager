package org.spikeboot.myfinancemanager.service;

import org.spikeboot.myfinancemanager.dao.UserTransactionDao;
import org.spikeboot.myfinancemanager.entity.UserTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserTransactionServiceImpl implements UserTransactionService {

    private UserTransactionDao userTransactionDao;

    @Override
    @Transactional
    public void addUserTransaction(UserTransaction userTransaction) {
        userTransactionDao.addUserTransaction(userTransaction);
    }

    @Override
    @Transactional
    public void updateUserTransaction(UserTransaction userTransaction) {
        userTransactionDao.updateUserTransaction(userTransaction);
    }

    @Override
    @Transactional
    public void removeUserTransaction(int id) {
        userTransactionDao.removeUserTransaction(id);
    }

    @Override
    @Transactional
    public UserTransaction getUserTransactionById(int id) {
        return userTransactionDao.getUserTransactionById(id);
    }

    @Override
    @Transactional
    public List<UserTransaction> getUserTransactions() {
        return userTransactionDao.getUserTransactions();
    }

    @Autowired
    public void setUserTransactionDao(UserTransactionDao userTransactionDao) {
        this.userTransactionDao = userTransactionDao;
    }
}
