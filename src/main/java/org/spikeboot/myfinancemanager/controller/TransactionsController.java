package org.spikeboot.myfinancemanager.controller;

import org.spikeboot.myfinancemanager.entity.UserTransaction;
import org.spikeboot.myfinancemanager.service.CategoryTransactionService;
import org.spikeboot.myfinancemanager.service.UserTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String addNewUserTransaction(Model model) {
        UserTransaction userTransaction = new UserTransaction();
        model.addAttribute("newUserTransaction", userTransaction);

        model.addAttribute("categoryTransactions", categoryTransactionService.getCategoryTransactions());
        return "transactions-add-view";
    }

    @RequestMapping("/saveNewUserTransaction")
    public String saveNewUserTransaction(@ModelAttribute("newUserTransaction") UserTransaction userTransaction) {
        userTransactionService.addUserTransaction(userTransaction);

        return "redirect:/transactions/view";
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
