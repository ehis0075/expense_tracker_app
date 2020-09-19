package com.example.codeengine.expense.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Data
@Table(name="category")
public class Category {

    @Id
    private Long id;

    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;


}
