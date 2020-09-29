package com.example.codeengine.expense.Service.Expense;

import com.example.codeengine.expense.model.Expense;
import com.example.codeengine.expense.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;

    @Override
    public Expense save(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public Optional<Expense> findById(Long expenseId) {
        return expenseRepository.findById(expenseId);
    }

    @Override
    public Expense update(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public void deleteById(Long expenseId) {
        expenseRepository.deleteById(expenseId);
    }

    @Override
    public Collection<Expense> findAll() {
        return expenseRepository.findAll();
    }
}
