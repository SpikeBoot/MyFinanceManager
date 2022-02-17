package org.spikeboot.myfinancemanager.controller;

import org.spikeboot.myfinancemanager.entity.CategoryTransaction;
import org.spikeboot.myfinancemanager.service.CategoryTransactionService;
import org.spikeboot.myfinancemanager.service.UserTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MyController {

    private CategoryTransactionService categoryTransactionService;
    private UserTransactionService userTransactionService;


    @RequestMapping("/show-all-category-transaction-view")
    public String showAllCategoryTransaction(Model model) {
        List<CategoryTransaction> categoryTransactions = categoryTransactionService.getCategoryTransactions();
        model.addAttribute("allCategoryTransactions", categoryTransactions);

        return "show-all-category-transaction-view";
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
