package com.example.splitwise.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "splitwise_group")
public class Group extends BaseModel{
    private String name;
    @ManyToMany
    @JoinTable
    private List<User> users;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "group")
    private List<Expense> expenses;
}
