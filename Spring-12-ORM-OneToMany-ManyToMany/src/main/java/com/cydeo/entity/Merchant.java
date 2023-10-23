package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "merchants")
@NoArgsConstructor
@Data
public class Merchant extends BaseEntity{
    private String name;
    private String code;
    private BigDecimal commissionRate;
    private BigDecimal transactionFee;
    private Integer payoutDelayCount;

    @OneToMany(mappedBy = "merchant") // in OneToMany relationship ownership belongs to Many side
    private List<Payment> paymentList;

    public Merchant(String name, String code, BigDecimal commissionRate, BigDecimal transactionFee, Integer payoutDelayCount) {
        this.name = name;
        this.code = code;
        this.commissionRate = commissionRate;
        this.transactionFee = transactionFee;
        this.payoutDelayCount = payoutDelayCount;
    }
}
