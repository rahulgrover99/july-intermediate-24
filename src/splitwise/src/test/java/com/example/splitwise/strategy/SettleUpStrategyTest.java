package com.example.splitwise.strategy;

import com.example.splitwise.models.Expense;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SettleUpStrategyTest {

    private SettleUpStrategy settleUpStrategy;
    
    @BeforeEach
    void setUp() {
        settleUpStrategy = new SettleUpStrategy();
    }
    
    @Test
    void settleUp() {
        // Arrange
        List<Expense> expenses = new ArrayList<>();

        // Act
        List<Transaction> transactionList = settleUpStrategy.settleUp(expenses);

        // Assert
        assertEquals(0, transactionList.size());
    }

}