package com.cydeo.entity;

import com.cydeo.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "payments")
@NoArgsConstructor
@Data
public class Payment extends BaseEntity{

    private BigDecimal amount;
    @Column(columnDefinition = "date")
    private LocalDate createDate;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToOne(cascade = CascadeType.ALL)
    private PaymentDetail paymentDetail; // foreignKey

    public Payment(BigDecimal amount, LocalDate createDate, Status status) {
        this.amount = amount;
        this.createDate = createDate;
        this.status = status;
    }
}
