//package com.example.codeengine.expense.controller;
//
//import com.example.codeengine.expense.model.Category;
//import com.example.codeengine.expense.repository.CategoryRepository;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Collection;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api")
//public class CategoryController {
//
//    private CategoryRepository categoryRepository;
//
//    public CategoryController(CategoryRepository categoryRepository) {
//
//        super();
//        this.categoryRepository = categoryRepository;
//    }
//
//    @GetMapping("/categories")
//    Collection<Category> category(){
//
//        return categoryRepository.findAll();
//        //select * from category
//    }
//
//    //category/2
//    @GetMapping("/category/{id}")
//    ResponseEntity<?> getCategory(@PathVariable Long id){
//        Optional<Category> category = categoryRepository.findById(id);
//        return category.map(response -> ResponseEntity.ok().body(response)).
//                orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    //
//    @PostMapping("/category")
//    ResponseEntity<Category> createCategory(@Valid @RequestBody Category category ) {
//
//    }
//}
