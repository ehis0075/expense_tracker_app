//package com.example.codeengine.expense.repository;
//
//import com.example.codeengine.expense.model.Category;
//import com.example.codeengine.expense.model.Expense;
//import com.example.codeengine.expense.model.User;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.Instant;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import java.util.logging.Logger;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class ExpenseRepositoryTest {
//
//    Logger log = Logger.getLogger(getClass().getName());
//
//    @Autowired
//    ExpenseRepository expenseRepository;
////    UserRepository userRepository;
////    CategoryRepository categoryRepository;
//
//    Expense testExpense;
//    User testUser;
//    Category testCategory;
//
//    @BeforeEach
//    void setUp() {
//    }
//
//    @AfterEach
//    void tearDown() {
//    }
//
//    @Test
//    void createAnNewExpenseAndSaveToDb(){
//
//        Expense expense = new Expense();
//        User user = new User();
//        Category category = new Category();
//
//        user.setName("Angela Yu");
//        user.setEmail("angelayu@gmail.com");
//
//        category.setName("Equipment");
//
//        expense.setUser(user);
//        expense.setCategory(category);
//        expense.setDescription("For mechanical equipments");
//        expense.setExpenseDate(Instant.now());
//
//        log.info("Created Expense Object -> "+ expense);
//        assertThat(expense.getId()).isNull();
//
//        //Save Expense Object to database
//        expense = expenseRepository.save(expense);
//
//        log.info("After saving Expense Object to database -> "+ expense);
//        assertThat(expense.getId()).isNotNull();
//
//        Collection<Expense> getAllExpense = expenseRepository.findAll();
//        assertThat(getAllExpense.size()).isEqualTo(5);
//
//        log.info("After getting all expense from database ->"+ getAllExpense);
//
//    }
//
//}

package com.example.codeengine.expense.repository;

import com.example.codeengine.expense.model.Category;
import com.example.codeengine.expense.model.Expense;
import com.example.codeengine.expense.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.Collection;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExpenseRepositoryTest {

    Logger log = Logger.getLogger(getClass().getName());

    @Autowired
    ExpenseRepository expenseRepository;

    Expense testExpense;

    User testUser;

    Category testCategory;


    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAllExpenseInDatabaseTest() {

        Collection<Expense> getAllExpense = expenseRepository.findAll();
        assertThat(getAllExpense).isNotNull();
        assertThat(getAllExpense.size()).isEqualTo(5);

        log.info("All Expense data in database -> "+ getAllExpense);

    }

    @Test
    void findExpenseInDatabaseByIdTest() {

        findAllExpenseInDatabaseTest();

        testExpense = expenseRepository.findById(testExpense.getId()).orElse(null);
        assertThat(testExpense).isNotNull();

        log.info("Get expense in database by Id ->"+ testExpense);

    }

    @Test
    void deleteExpenseInDatabaseTest() {

        Collection<Expense> getAllExpense = expenseRepository.findAll();
        assertThat(getAllExpense).isNotNull();
        assertThat(getAllExpense.size()).isEqualTo(5);

        log.info("All Expense data in database -> "+ getAllExpense);

        expenseRepository.deleteById((long) 6);
        Expense deleteExpense = expenseRepository.findById((long) 6).orElse(null);
        assertThat(deleteExpense).isNull();

        getAllExpense = expenseRepository.findAll();
        assertThat(getAllExpense).isNotNull();
        assertThat(getAllExpense.size()).isEqualTo(4);

        log.info("After deleting Expense object from database -> "+ getAllExpense);

    }

    @Test
    void createExpenseObject_ThenSaveToDatabaseTest() {

        Expense expense = new Expense();
        User user = new User();
        Category category = new Category();

        user.setName("Angela Yu");
        user.setEmail("angelayu@gmail.com");

        category.setName("Equipment");

        expense.setUser(user);
        expense.setCategory(category);
        expense.setDescription("For mechanical equipments");
        expense.setExpenseDate(Instant.now());

        log.info("Created Expense Object -> "+ expense);
        assertThat(expense.getId()).isNull();

        //Save Expense Object to database
        expense = expenseRepository.save(expense);

        log.info("After saving Expense Object to database -> "+ expense);
        assertThat(expense.getId()).isNotNull();

        Collection<Expense> getAllExpense = expenseRepository.findAll();
        //assertThat(getAllExpense.size()).isEqualTo(5);

        log.info("After getting all expense from database ->"+ getAllExpense);

    }

    @Test
    void updateExpenseInDatabaseTest() {

        testExpense = expenseRepository.findById((long) 7).orElse(null);
        assertThat(testExpense).isNotNull();

        log.info("After checking for required Expense object -> "+ testExpense);

        assertThat(testExpense.getDescription()).isEqualTo("For mechanical equipments");
        testExpense.setDescription("For electrical equipments");

        testExpense = expenseRepository.save(testExpense);
        assertThat(testExpense.getDescription()).isEqualTo("For electrical equipments");

        log.info("After updating Expense object -> "+ testExpense);

        Collection<Expense> expenses = expenseRepository.findAll();
        assertThat(expenses).isNotNull();
        assertThat(expenses.size()).isEqualTo(2);

        log.info("Getting all Expense object -> "+ expenses);

    }
}