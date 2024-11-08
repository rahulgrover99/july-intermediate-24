package com.example.splitwise.dtos;

import lombok.Data;

import java.util.List;

@Data
public class CreateGroupRequestDto {
    private String name;
    private List<Long> users;
}
