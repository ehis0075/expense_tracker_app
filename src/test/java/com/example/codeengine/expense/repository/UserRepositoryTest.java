package com.example.codeengine.expense.repository;

import com.example.codeengine.expense.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    Logger log = Logger.getLogger(getClass().getName());

    @Autowired
    UserRepository userRepository;

    User user;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createNewUserAndSaveToDb(){

        User user = new User();
        user.setId(1L);
        user.setName("ehis");
        user.setEmail("ehis@gmail.com");

        List<User> userList  = userRepository.findAll();
        assertThat(userList.isEmpty());

        User savedUser;
        savedUser = userRepository.save(user);
        userList  = userRepository.findAll();
        assertThat(userList.contains(savedUser));

    }
}