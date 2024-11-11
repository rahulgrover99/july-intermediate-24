package com.example.splitwise.controllers;

import com.example.splitwise.dtos.CreateExpenseRequestDto;
import com.example.splitwise.models.Expense;
import com.example.splitwise.service.ExpenseService;
import com.example.splitwise.strategy.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Expense createExpense(@RequestBody CreateExpenseRequestDto requestDto) {
        return expenseService.
                addExpense(requestDto.getName(),
                        requestDto.getTotalAmount(),
                        requestDto.getUserExpense(),
                        requestDto.getGroupId() == 0?
                                Optional.empty() : Optional.of(requestDto.getGroupId()));
    }

    @GetMapping("/group/{id}")
    public List<Transaction> getSettleUpTransactions(@PathVariable("id") Long id) {
        return expenseService.settleUp(id);
    }

}
