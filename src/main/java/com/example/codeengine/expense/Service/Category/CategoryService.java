package com.example.codeengine.expense.Service.Category;

import com.example.codeengine.expense.model.Category;

import java.util.Collection;
import java.util.Optional;

public interface CategoryService {

    Category save(Category category);

    Optional<Category> findById(Long categoryId);

    Category update(Category category);

    void deleteById(Long categoryId);

    Collection<Category> findAll();

}
