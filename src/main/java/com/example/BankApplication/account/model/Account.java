package com.example.BankApplication.account.model;

import com.example.BankApplication.registration.models.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double balance;
    private Long aadharNo;
    private String panNo;
    @OneToOne (mappedBy = "account", cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "Account_id")
    private User user;
}
