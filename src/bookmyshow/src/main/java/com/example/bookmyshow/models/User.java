package com.example.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class User extends BaseModel{
    private String username;
    private String password;
}
