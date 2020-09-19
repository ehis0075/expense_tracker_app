package com.example.codeengine.expense.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="expense")
public class Expense {

    @Id
    private Long id;

    private Instant expensedate;

    private String description;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;

}
