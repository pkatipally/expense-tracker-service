package com.priya.expense.service;

import com.priya.expense.model.Spending;
import com.priya.expense.repositary.ExpensesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;


@Service
public class ExpenseService {

    @Autowired
    ExpensesRepo expensesRepo;

    public List<Spending> getExpenseByDate(String input){
        LocalDate date = LocalDate.parse(input);
        return expensesRepo.findAllByPaymentDate(date);
    }

    public Spending addSpending(Spending spending) {

        return expensesRepo.save(spending);
    }
}

