package com.priya.expense.repositary;

import com.priya.expense.model.Spending;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpensesRepo extends MongoRepository<Spending, String> {

    public List<Spending> findAllByPaymentDate(LocalDate date);

    public List<Spending> getAllByOOrderByAmountAmountAsc();
}
