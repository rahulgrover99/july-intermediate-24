package com.example.splitwise.strategy;

import com.example.splitwise.models.Expense;
import com.example.splitwise.models.User;
import com.example.splitwise.models.UserExpense;

import java.util.*;

public class SettleUpStrategy {


    List<Transaction> settleUp(List<Expense> expenses) {
        // 1. For each user we will find out the total amount
        // owed.
        // 2. Divide the users into 2 groups, positive and negative
        // 3. Insert all users with amounts in Max Heap.
        // 4. Pop from both the queues.
        // 5. Create a transaction from owed -> getBackUser
        // 6. Keep doing this until the list is empty.

        Map<User, Double> userExpenses = new HashMap<>();

        for (Expense expense: expenses) {
            for (UserExpense userExpense: expense.getUserExpenseList()) {
                User user = userExpense.getUser();
                if (!userExpenses.containsKey(user)) {
                    userExpenses.put(user, 0.0);
                }
                userExpenses.put(user, userExpenses.get(user) +
                        userExpense.getAmountOwed());
            }
        }

        PriorityQueue<UserExpense> priorityQueueOwedBy = new PriorityQueue<>();
        PriorityQueue<UserExpense> priorityQueueOwedTo = new PriorityQueue<>();

        userExpenses.forEach((user, amount) -> {
            if (amount < 0) {
                priorityQueueOwedTo.add(new UserExpense(user, -amount));
            } else {
                priorityQueueOwedBy.add(new UserExpense(user, amount));
            }
        });

        List<Transaction> transactions = new ArrayList<>();

        while (!priorityQueueOwedBy.isEmpty()) {
            UserExpense owedBy = priorityQueueOwedBy.poll();
            UserExpense owedTo = priorityQueueOwedTo.poll();

            if (owedBy.getAmountOwed() > owedTo.getAmountOwed()) {
                transactions.add(new Transaction(owedBy.getUser(), owedTo.getUser(), owedTo.getAmountOwed()));
                priorityQueueOwedBy.add(new UserExpense(owedBy.getUser(),
                        (owedBy.getAmountOwed()) - owedTo.getAmountOwed()));
            } else {
                transactions.add(new Transaction(owedBy.getUser(), owedTo.getUser(), owedBy.getAmountOwed()));
                priorityQueueOwedBy.add(new UserExpense(owedTo.getUser(),
                        (owedTo.getAmountOwed()) - owedBy.getAmountOwed()));
            }
        }

        return transactions;
    }

}
