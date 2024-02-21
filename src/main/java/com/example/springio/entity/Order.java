package com.example.springio.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.sql.Date;

@Data
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name = "order")
@Entity
public class Order {
    @Getter
    @Setter
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String owner;
    @Column("createdDate")
    private Date createdDate;

}
