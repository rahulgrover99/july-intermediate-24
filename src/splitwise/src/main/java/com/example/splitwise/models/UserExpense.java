package com.example.splitwise.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_expense")
@AllArgsConstructor
@NoArgsConstructor
public class UserExpense extends BaseModel implements Comparable {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private Double amountOwed;


    @Override
    public int compareTo(Object o) {
        if (!(o instanceof UserExpense)) {
            throw new RuntimeException();
        }

        UserExpense other = (UserExpense) o;
        return Double.compare(amountOwed, other.amountOwed);

    }
}