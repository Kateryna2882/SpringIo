package com.example.springio.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class Order {
    @Id
    private int id;
    private String owner;
    @Column("created")
    private Date creationDate;
}
