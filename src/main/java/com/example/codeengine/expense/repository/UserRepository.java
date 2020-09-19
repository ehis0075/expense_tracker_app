package com.example.codeengine.expense.repository;

import com.example.codeengine.expense.model.Category;
import com.example.codeengine.expense.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
