package com.example.splitwise.strategy;

import com.example.splitwise.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Transaction {
    User paidBy;
    User paidTo;
    Double amount;
}
