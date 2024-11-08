package com.example.splitwise.repository;

import com.example.splitwise.models.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseUserRepository extends JpaRepository<UserExpense, Long> {
}
