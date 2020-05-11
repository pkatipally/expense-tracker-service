package com.priya.expense.controller;

import com.priya.expense.model.Spending;
import com.priya.expense.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/tracker")
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @GetMapping("/hello")
    public String health(){
        return "Hello Expense Tracker";
    }

    @PostMapping("/add")
    public Spending addExpenses(@RequestBody Spending spending){
        return expenseService.addSpending(spending);
    }

    @GetMapping("/get/{input}")
    public List<Spending> getExpenseByDate(@PathVariable String input){
        return expenseService.getExpenseByDate(input);
    }
}
