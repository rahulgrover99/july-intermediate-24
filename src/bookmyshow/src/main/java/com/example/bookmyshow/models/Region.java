package com.example.bookmyshow.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Region extends BaseModel {
    private String name;
    @OneToMany(mappedBy = "region")
    private List<Theatre> theatreList;
    @Column(nullable = true)
    private double longitude;
    @Column(nullable = true)
    private double latitude;
}