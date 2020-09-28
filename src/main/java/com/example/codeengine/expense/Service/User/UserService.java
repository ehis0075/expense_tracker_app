package com.example.codeengine.expense.Service.User;

import com.example.codeengine.expense.model.User;

import java.util.Collection;
import java.util.Optional;

public interface UserService {

    User save(User user);

    Optional<User> findById(Long id);

    User update(User user);

    void deleteById(Long id);

    Collection<User> findAll();
}
