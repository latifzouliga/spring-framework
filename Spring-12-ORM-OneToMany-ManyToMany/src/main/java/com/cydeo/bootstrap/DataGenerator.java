package com.cydeo.bootstrap;

import com.cydeo.entity.Payment;
import com.cydeo.entity.PaymentDetail;
import com.cydeo.enums.Status;
import com.cydeo.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
@AllArgsConstructor
public class DataGenerator implements CommandLineRunner {

    private final PaymentRepository paymentRepository;
    @Override
    public void run(String... args) throws Exception{


        Payment payment1 = new Payment(new BigDecimal("150000"),LocalDate.of(2022,4,19), Status.SUCCESS);
        PaymentDetail paymentDetail1 = new PaymentDetail(new BigDecimal("10000"),new BigDecimal("140000"),LocalDate.of(2022,4,24));

        Payment payment2 = new Payment(new BigDecimal("100000"),LocalDate.of(2022,4,25), Status.FAILURE);
        PaymentDetail paymentDetail2 = new PaymentDetail(new BigDecimal("90000"),new BigDecimal("5000"),LocalDate.of(2022,4,29));

        payment1.setPaymentDetail(paymentDetail1);
        payment2.setPaymentDetail(paymentDetail2);

        paymentRepository.save(payment1);
        paymentRepository.save(payment2);

    }




}
