package com.codewithkishan.onlinestore.service;

//@Service("paypal")
//@Primary
public class PaypalPaymentService implements PaymentService {

    public void processPayment(Double amount){
        System.out.println("PAYPAL");
        System.out.println("AMOUNT : "+ amount);
    }

}
