package com.cydeo.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "userAccount")
@NoArgsConstructor
public class User extends BaseEntity{
    private String email;
    private String password;
    private String username;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountDetailsId")
    private Account account;
}
