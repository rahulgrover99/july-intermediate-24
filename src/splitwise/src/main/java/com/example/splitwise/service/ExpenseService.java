package com.example.splitwise.service;

import com.example.splitwise.models.Expense;
import com.example.splitwise.models.Group;
import com.example.splitwise.models.User;
import com.example.splitwise.models.UserExpense;
import com.example.splitwise.repository.ExpenseRepository;
import com.example.splitwise.repository.ExpenseUserRepository;
import com.example.splitwise.repository.GroupRepository;
import com.example.splitwise.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ExpenseService {
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final ExpenseRepository expenseRepository;
    private final ExpenseUserRepository expenseUserRepository;

    public ExpenseService(UserRepository userRepository, GroupRepository groupRepository, ExpenseRepository expenseRepository, ExpenseUserRepository expenseUserRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.expenseRepository = expenseRepository;
        this.expenseUserRepository = expenseUserRepository;
    }

    public Expense addExpense(String name,
                              Double amount,
                              Map<Long, Double> userExpenseList,
                              Optional<Long> groupId) {
        Optional<Group> optionalGroup = Optional.empty();
        if (groupId.isPresent()) {
             optionalGroup = groupRepository.findById(groupId.get());
        }

        List<User> userList = userRepository.findAllById(userExpenseList.keySet());

        List<UserExpense> userExpenses = new ArrayList<>();
        for (User user: userList) {
            UserExpense userExpense = new UserExpense();
            userExpense.setUser(user);
            userExpense.setAmountOwed(userExpenseList.get(user.getId()));

            expenseUserRepository.save(userExpense);

            userExpenses.add(userExpense);
        }

        Expense expense = new Expense();
        expense.setUserExpenseList(userExpenses);
        expense.setTotalAmount(amount);
        expense.setName(name);
        optionalGroup.ifPresent(expense::setGroup);

        return expenseRepository.save(expense);
    }

}
