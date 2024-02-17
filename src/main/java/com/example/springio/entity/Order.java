package com.example.springio.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.annotation.Id;

import java.util.Date;
@Data
@AllArgsConstructor
public class Order {
    @Id
    private int id;
    private String owner;
    @Column("created")
    private Date creationDate;
}
