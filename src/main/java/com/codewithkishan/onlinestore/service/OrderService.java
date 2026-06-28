package com.codewithkishan.onlinestore.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

//@Service
public class OrderService {

    private PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
        System.out.println("OrderService created.");
    }

    public void placeOrder(){
        paymentService.processPayment(10.0);

    }

    @PostConstruct
    public void init(){
        System.out.println("OrderService post construct");
    }

    @PreDestroy
    public void cleanup(){
        System.out.println("OrderService onlinestore destroy");
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
