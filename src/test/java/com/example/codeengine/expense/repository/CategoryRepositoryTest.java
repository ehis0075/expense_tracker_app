package com.example.codeengine.expense.repository;

import com.example.codeengine.expense.model.Category;
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
class CategoryRepositoryTest {

    Logger log = Logger.getLogger(getClass().getName());

    Category category;

    @Autowired
    CategoryRepository categoryRepository;

    Category testCategory;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createCategoryObject_Then_SaveToDbTest() {

        Category category = new Category();
        category.setName("house rent");

        log.info("Created Category Object -> "+ category);
        assertThat(category.getId()).isNull();

        //save Category object to database
        category = categoryRepository.save(category);

        log.info("After saving Category Object to database -> "+ category);
        assertThat(category.getId()).isNotNull();

       Collection<Category> getCategoryList = categoryRepository.findAll();
        //assertThat(getCategoryList.size()).isEqualTo(2);

        // log.info("After adding Category Object to database -> "+ category);

    }

    @Test
    void findAllCategoryInDatabaseTest() {

        Collection<Category> categorySet = categoryRepository.findAll();
        assertThat(categorySet.size()).isEqualTo(2);

        log.info("All Category Objects from database -> "+ categorySet);

    }

    @Test
    void findACategoryById() {

        Collection<Category> allCategory = categoryRepository.findAll();
        assertThat(allCategory).isNotNull();
        assertThat(allCategory.size()).isEqualTo(6);

        testCategory = categoryRepository.findById((long) 5).orElse(null);
        assertThat(testCategory).isNotNull();
        log.info("Test to retrieve category data by ID from database -> "+ testCategory);

    }

    @Test
    void updateACategoryInDatabaseTest() {

        assertThat(testCategory.getName()).isEqualTo("Housing");
        testCategory.setName("Rent and Housing");

        testCategory = categoryRepository.save(testCategory);
        assertThat(testCategory.getName()).isEqualTo("Rent and Housing");

        log.info("After updating Category Object in database -> "+ testCategory);

        Collection<Category> getAllCategory = categoryRepository.findAll();
        assertThat(getAllCategory.size()).isEqualTo(6);

        log.info("After updating Category Object in database -> "+ getAllCategory);

    }

    @Test
    void deleteCategoryByIdTest() {

        Collection<Category> allCategory = categoryRepository.findAll();
        assertThat(allCategory).isNotNull();
        assertThat(allCategory.size()).isEqualTo(6);

        testCategory = categoryRepository.findById((long) 5).orElse(null);
        assertThat(testCategory).isNotNull();
        log.info("Test to retrieve category data by ID from database -> "+ testCategory);

        categoryRepository.deleteById((long) 5);

        Category deleteCategory = categoryRepository.findById((long) 5).orElse(null);
        assertThat(deleteCategory).isNull();

        allCategory = categoryRepository.findAll();
        assertThat(allCategory).isNotNull();
        assertThat(allCategory.size()).isEqualTo(5);

        log.info("After deleting category data by ID from database -> "+ allCategory);

    }

}