package com.example.codeengine.expense.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.codeengine.expense.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

//    Category findByName(String name);
}
