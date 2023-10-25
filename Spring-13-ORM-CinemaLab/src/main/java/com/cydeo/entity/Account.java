package com.cydeo.entity;

import com.cydeo.enums.Role;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "accountDetails")
public class Account extends BaseEntity{

    private String name;
    private Integer age;
    private String address;
    private String country;
    private String state;
    private String city;
    private String postalCode;
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;
    @OneToOne(mappedBy = "account", fetch = FetchType.LAZY)
    @JoinColumn(name = "userAccountId")
    private User user;
}
