package com.example.sales.models.user;

import com.example.sales.models.transaction.Transaction;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String fullname;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String wishes;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Transaction> transactions;
}
