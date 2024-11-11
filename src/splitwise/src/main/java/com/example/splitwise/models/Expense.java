package com.example.splitwise.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "expense")
@Data
public class Expense extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    private String name;
    private Double totalAmount;
    @OneToMany(fetch = FetchType.EAGER)
    List<UserExpense> userExpenseList;
}