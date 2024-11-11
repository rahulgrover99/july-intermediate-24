package com.example.splitwise.strategy;

import com.example.splitwise.models.Expense;
import com.example.splitwise.models.User;
import com.example.splitwise.models.UserExpense;

import java.util.*;

public class SettleUpStrategy {


    public static List<Transaction> settleUp(List<Expense> expenses) {
        // 1. For each user we will find out the total amount
        // owed.
        // 2. Divide the users into 2 groups, positive and negative
        // 3. Insert all users with amounts in Max Heap.
        // 4. Pop from both the queues.
        // 5. Create a transaction from owed -> getBackUser
        // 6. Keep doing this until the list is empty.

//        System.out.println(expenses);

        // { user1: 1000, user2: -700, user3: -400, user4: 100 }
        Map<User, Double> userExpenses = getUserOwedAmount(expenses);

        PriorityQueue<UserExpense> priorityQueueOwedBy = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<UserExpense> priorityQueueOwedTo = new PriorityQueue<>(Collections.reverseOrder());

        userExpenses.forEach((user, amount) -> {
            if (amount < 0) {
                priorityQueueOwedTo.add(new UserExpense(user, -amount));
            } else {
                priorityQueueOwedBy.add(new UserExpense(user, amount));
            }
        });

        // PQOwedBy = [user1: 1000, user4: 100]
        // PQ2OwedTo = [user2: 700, user3: 400]

        // PQOwedBy = [ user4: 100]
        // PQ2OwedTo = [user3: 400]
        // Transaction (user1 -> user2 {700})

        // PQOwedBy = [user1: 300, user4: 100]
        // PQ2OwedTo = [user3: 400]

        // PQOwedBy = [ user4: 100]
        // PQ2OwedTo = []
        // Transaction (user1 -> user2 {700}, user1 -> user3 {300})

        // PQOwedBy = [ user4: 100]
        // PQ2OwedTo = [user3: 100]

        // Transaction (user1 -> user2 {700}, user1 -> user3 {300}, user4 -> user3 {100})

        List<Transaction> transactions = new ArrayList<>();

        while (!priorityQueueOwedBy.isEmpty()) {
            UserExpense owedBy = priorityQueueOwedBy.poll();
            UserExpense owedTo = priorityQueueOwedTo.poll();

            if (owedBy.getAmountOwed() > owedTo.getAmountOwed()) {
                transactions.add(new Transaction(owedBy.getUser(), owedTo.getUser(), owedTo.getAmountOwed()));
                priorityQueueOwedBy.add(new UserExpense(owedBy.getUser(),
                        (owedBy.getAmountOwed()) - owedTo.getAmountOwed()));
            } else if (owedBy.getAmountOwed().equals(owedTo.getAmountOwed())) {
                transactions.add(new Transaction(owedBy.getUser(), owedTo.getUser(), owedTo.getAmountOwed()));
            }
            else {
                transactions.add(new Transaction(owedBy.getUser(), owedTo.getUser(), owedBy.getAmountOwed()));
                priorityQueueOwedBy.add(new UserExpense(owedTo.getUser(),
                        (owedTo.getAmountOwed()) - owedBy.getAmountOwed()));
            }
        }

        return transactions;
    }

    private static Map<User, Double> getUserOwedAmount(List<Expense> expenses) {
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
        return userExpenses;
    }

}
