package org.spikeboot.myfinancemanager.controller;

import org.spikeboot.myfinancemanager.entity.UserTransaction;
import org.spikeboot.myfinancemanager.service.CategoryTransactionService;
import org.spikeboot.myfinancemanager.service.UserTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/transactions")
public class TransactionsController {

    private CategoryTransactionService categoryTransactionService;
    private UserTransactionService userTransactionService;

    /**
     * showAllCategoryTransaction
     * This mapping use for visual representation all users transaction
     */

    @RequestMapping("/view")
    public String showAllCategoryTransaction(Model model) {
        List<UserTransaction> userTransactions = userTransactionService.getUserTransactions();

        model.addAttribute("userTransactions", userTransactions);

        return "transactions-view";
    }

    /**
     * addNewUserTransaction
     * This mapping use for create new transaction and
     * use same view 'transactions-info-view' with updateTransaction mapping
     */

    @RequestMapping("/addTransaction")
    public String addNewUserTransaction(Model model) {
        UserTransaction userTransaction = new UserTransaction();
        model.addAttribute("userTransaction", userTransaction);

        model.addAttribute("categoryTransactions", categoryTransactionService.getCategoryTransactions());
        return "transactions-info-view";
    }

    @RequestMapping("/updateTransaction")
    public String updateTransaction(@RequestParam("transactionId") int id, Model model) {
        UserTransaction userTransaction = userTransactionService.getUserTransactionById(id);
        userTransaction.setCategoryTransactionId(userTransaction.getCategoryTransaction().getId());

        model.addAttribute("userTransaction", userTransaction);
        model.addAttribute("categoryTransactions", categoryTransactionService.getCategoryTransactions());

        return "transactions-info-view";
    }

    /**
     * saveUserTransaction
     * This mapping get transaction from transactions-info-view.
     * If transaction is present in DataBase - update him, or create new instance.
     * */

    @RequestMapping("/saveUserTransaction")
    public String saveUserTransaction(@ModelAttribute("userTransaction") UserTransaction userTransaction) {
        userTransaction.setCategoryTransaction(categoryTransactionService
                .getCategoryTransactionById(userTransaction
                        .getCategoryTransactionId()));

        if (userTransaction.getId() != 0) {
            userTransactionService.updateUserTransaction(userTransaction);
        } else {
            userTransactionService.addUserTransaction(userTransaction);
        }

        return "redirect:/transactions/view";
    }

    /**
     * deleteTransaction
     * This mapping use for delete instance transaction from database
     * */

    @RequestMapping("/deleteTransaction")
    public String deleteTransaction(@RequestParam("transactionId") int id) {
        userTransactionService.removeUserTransaction(id);

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
