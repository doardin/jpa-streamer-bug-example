package com.example.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Example {
    
    @Id
    private Long id;

    private String name;

    private Boolean active;
    
}