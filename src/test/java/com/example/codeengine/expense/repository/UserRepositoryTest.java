package com.example.codeengine.expense.repository;

import com.example.codeengine.expense.model.Category;
import com.example.codeengine.expense.model.Expense;
import com.example.codeengine.expense.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    Logger log = Logger.getLogger(getClass().getName());

    @Autowired
    UserRepository userRepository;

    User testUser;


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void createAUser_And_SaveToDbTest() {

        User user = new User();
        user.setEmail("kelvin@gmail.com");
        user.setName("kelvin ted");

        log.info("Created User Object -> "+ user);
        assertThat(user.getId()).isNull();

        //Save User object to database
        user = userRepository.save(user);

        log.info("After saving User object to database -> "+ user);
        assertThat(user.getId()).isNotNull();

        Collection<User> getAllUser = userRepository.findAll();
        log.info("After getting all Users in database -> "+ getAllUser);

    }

    @Test
    void findAllUsersInDbTest() {

        Collection<User> getAllUser = userRepository.findAll();
        assertThat(getAllUser).isNotNull();
        assertThat(getAllUser.size()).isEqualTo(2);

        log.info("All Users in database -> "+ getAllUser);

    }

    @Test
    void findAUserByIdInDbTest() {

        Collection<User> getAllUser = userRepository.findAll();
        assertThat(getAllUser).isNotNull();
        assertThat(getAllUser.size()).isEqualTo(2);

        log.info("After checking database for Users -> "+ getAllUser);

        testUser = userRepository.findById((long) 1).orElse(null);
        assertThat(testUser).isNotNull();

        log.info("After getting User by Id in database  ->"+ testUser);

    }

    @Test
    void updateUserInDatabaseTest() {

        testUser = userRepository.findById((long) 4).orElse(null);
        assertThat(testUser).isNotNull();

        assertThat(testUser.getName()).isEqualTo("Netlinc Technologies");
        testUser.setName("Netlinc");

        testUser = userRepository.save(testUser);
        assertThat(testUser.getName()).isEqualTo("Netlinc");

        log.info("After updating name of User object ->"+ testUser);

        Collection<User> getAllUser = userRepository.findAll();
        assertThat(getAllUser).isNotNull();
        assertThat(getAllUser.size()).isEqualTo(4);

        log.info("After checking database for Users -> "+ getAllUser);

    }

    @Test
    void deleteUserInDatabaseTest() {

        Collection<User> getAllUser = userRepository.findAll();
        assertThat(getAllUser).isNotNull();
        assertThat(getAllUser.size()).isEqualTo(4);

        testUser = userRepository.findById((long) 4).orElse(null);
        assertThat(testUser).isNotNull();
        log.info("After getting User by Id in database  ->"+ testUser);

        userRepository.deleteById((long) 4);

        User deleteUser = userRepository.findById((long) 4).orElse(null);
        assertThat(deleteUser).isNull();

        getAllUser = userRepository.findAll();
        assertThat(getAllUser).isNotNull();
        assertThat(getAllUser.size()).isEqualTo(3);

        log.info("After deleting User object from database ->"+ getAllUser);

    }
}