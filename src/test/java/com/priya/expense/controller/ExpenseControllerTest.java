package com.priya.expense.controller;


import com.priya.expense.model.Spending;
import com.priya.expense.model.TypeOfExpense;
import com.priya.expense.repositary.ExpensesRepo;
import com.priya.expense.service.ExpenseService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.*;

import static org.mockito.Mockito.verify;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ExpenseControllerTest {
    @InjectMocks
    ExpenseController expenseController;

    @Mock
    ExpenseService expenseService;

    @BeforeAll
    void setup(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void addExpensesTest(){
        Spending spending = spendingData();
        when(expenseService.addSpending(any(Spending.class))).thenReturn(spending);
        Spending actualSpending = expenseController.addExpenses(spending);

        verify(expenseService,times(1)).addSpending(any(Spending.class));
        assertThat(actualSpending, is((spending)));
    }

    @Test
    public void getExpenseByDateTest(){
        Spending spending = spendingData();
        List<Spending> expectedSpending = new ArrayList<>();
        expectedSpending.add(spending);
        when(expenseService.getExpenseByDate(anyString())).thenReturn(expectedSpending);
        List<Spending> actualSpending = expenseController.getExpenseByDate("12-03-2012");

        verify(expenseService,times(1)).getExpenseByDate(anyString());
        assertThat(actualSpending, is(expectedSpending));

    }

    public Spending spendingData() {
        Spending spending = new Spending();
        spending.setAmount(1000);
        spending.setId("1");
        spending.setPaymentDate(LocalDate.now());
        spending.setExpenseType(TypeOfExpense.CAR_PAYMENT);
        spending.setLocation("VA");
        spending.setName("Raj");
        return spending;
    }
}
