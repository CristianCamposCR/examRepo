package com.example.sales.models.product;

import com.example.sales.models.transaction.Transaction;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String category;
    @Column
    private double price;
    @Column(name = "status",nullable = false,columnDefinition = "tinyint default 1")
    private Boolean status;
    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private Set<Transaction> transactions;
}
