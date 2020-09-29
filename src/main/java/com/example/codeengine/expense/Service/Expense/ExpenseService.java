package com.example.codeengine.expense.Service.Expense;

import com.example.codeengine.expense.model.Expense;

import java.util.Collection;
import java.util.Optional;

public interface ExpenseService {

    Expense save(Expense expense);

    Optional<Expense> findById(Long expenseId);

    Expense update(Expense expense);

    void deleteById(Long expenseId);

    Collection<Expense> findAll();

}
