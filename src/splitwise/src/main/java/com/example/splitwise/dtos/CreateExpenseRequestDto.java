package com.example.splitwise.dtos;

import lombok.Data;

import java.util.Map;

@Data
public class CreateExpenseRequestDto {
    private String name;
    private Double totalAmount;
    // {1: 200, 2: 100}
    private Map<Long, Double> userExpense;
    private Long groupId;
}
