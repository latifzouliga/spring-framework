package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "payment_details")
@NoArgsConstructor
@Data
public class PaymentDetail extends BaseEntity{
    private BigDecimal commissionAmount;
    private BigDecimal merchantPaymentAmount;
    @Column(columnDefinition = "date")
    private LocalDate payoutDate;
    @OneToOne(mappedBy = "paymentDetail",cascade = CascadeType.ALL)
    private Payment payment;

    public PaymentDetail(BigDecimal commissionAmount, BigDecimal merchantPaymentAmount, LocalDate payoutDate) {
        this.commissionAmount = commissionAmount;
        this.merchantPaymentAmount = merchantPaymentAmount;
        this.payoutDate = payoutDate;
    }
}
