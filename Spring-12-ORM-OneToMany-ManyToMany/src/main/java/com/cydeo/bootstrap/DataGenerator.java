package com.cydeo.bootstrap;

import com.cydeo.entity.*;
import com.cydeo.enums.Status;
import com.cydeo.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

@Component
@AllArgsConstructor
public class DataGenerator implements CommandLineRunner {

    private final PaymentRepository paymentRepository;
    private final MerchantRepository merchantRepository;
    private final CustomerRepository customerRepository;
    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;

    @Override
    public void run(String... args) throws Exception {


        Payment payment1 = new Payment(new BigDecimal("150000"), LocalDate.of(2022, 4, 19), Status.SUCCESS);
        PaymentDetail paymentDetail1 = new PaymentDetail(new BigDecimal("10000"), new BigDecimal("140000"), LocalDate.of(2022, 4, 24));

        Payment payment2 = new Payment(new BigDecimal("100000"), LocalDate.of(2022, 4, 25), Status.FAILURE);
        PaymentDetail paymentDetail2 = new PaymentDetail(new BigDecimal("90000"), new BigDecimal("5000"), LocalDate.of(2022, 4, 29));

        Merchant merchant1 = new Merchant("AmazonSubMerchant", "M123", new BigDecimal("0.25"), new BigDecimal("3.25"), 5);

        Customer customer1 = new Customer("msmith", "Mike", "Smith", "msmith@cydeo.com", "VA");


        Item item1 = new Item("Milk", "M01");
        Item item2 = new Item("Sugar", "S01");
        Item item3 = new Item("Bread", "B01");


        Cart cart1 = new Cart();
        Cart cart2 = new Cart();

        // set cart
        cart1.setItemList(Arrays.asList(item1, item2, item3));
        cart2.setItemList(Arrays.asList(item1, item2));

        // set payment details
        payment1.setPaymentDetail(paymentDetail1);
        payment2.setPaymentDetail(paymentDetail2);

        // set merchant
        payment1.setMerchant(merchant1);
        payment2.setMerchant(merchant1);

        // set customer
        payment1.setCustomer(customer1);
        payment2.setCustomer(customer1);



        // persist merchant
        merchantRepository.save(merchant1);

        // persist customer
        customerRepository.save(customer1);

        // persist payment
        paymentRepository.save(payment1);
        paymentRepository.save(payment2);

        // persist item
        itemRepository.save(item1);
        itemRepository.save(item2);
        itemRepository.save(item3);

        // persist cart
        cartRepository.save(cart1);
        cartRepository.save(cart2);

    }


}
