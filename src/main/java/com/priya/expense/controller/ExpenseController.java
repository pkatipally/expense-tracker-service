package com.priya.expense.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tracker")
public class ExpenseController {

    @GetMapping("/hello")
    public String health(){
        return "Hello Expense Tracker";
    }
}
