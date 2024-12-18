package com.example.splitwise.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "splitwise_user")
@Data
public class User extends BaseModel{
    private String name;
    private String email;
    private long mobile;
}
