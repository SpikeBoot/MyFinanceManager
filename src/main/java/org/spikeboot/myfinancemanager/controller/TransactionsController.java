package org.spikeboot.myfinancemanager.controller;

import org.spikeboot.myfinancemanager.entity.CategoryTransaction;
import org.spikeboot.myfinancemanager.entity.UserTransaction;
import org.spikeboot.myfinancemanager.service.CategoryTransactionService;
import org.spikeboot.myfinancemanager.service.UserTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/transactions")
public class TransactionsController {

    private CategoryTransactionService categoryTransactionService;
    private UserTransactionService userTransactionService;


    @RequestMapping("/view")
    public String showAllCategoryTransaction(Model model) {
        List<UserTransaction> userTransactions = userTransactionService.getUserTransactions();

        model.addAttribute("userTransactions", userTransactions);

        return "transactions-view";
    }

    @RequestMapping("/addTransaction")
    public String addNewTransaction(Model model){
        model.addAttribute("newUserTransaction", new UserTransaction());

        return "transactions-add-view";
    }

















    @Autowired
    public void setCategoryTransactionDao(CategoryTransactionService categoryTransactionDao) {
        this.categoryTransactionService = categoryTransactionDao;
    }

    @Autowired
    public void setUserTransactionDao(UserTransactionService userTransactionDao) {
        this.userTransactionService = userTransactionDao;
    }
}
