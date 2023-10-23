package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "customers")
@NoArgsConstructor
@Data
public class Customer extends BaseEntity{

    private String name;
    private String surName;
    private String userName;
    private String email;
    private String address;

    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY)
    private List<Payment> paymentList;

    public Customer(String name, String surName, String userName, String email, String address) {
        this.name = name;
        this.surName = surName;
        this.userName = userName;
        this.email = email;
        this.address = address;
    }
}
