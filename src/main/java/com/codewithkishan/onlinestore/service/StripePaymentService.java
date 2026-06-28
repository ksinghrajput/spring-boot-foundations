package com.codewithkishan.onlinestore.service;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

//@Service("stripe")
public class StripePaymentService implements PaymentService {

    @Value("${stripe.apiUrl}")
    private String apiUrl;

    @Value("${stripe.enable}")
    private boolean enabled;

    @Value("${stripe.timeout:3000}")
    private int timeout;

    @Value("${stripe.supported-currency}")
    private List<String> supportedCurrency;

    public void processPayment(Double amount){
        System.out.println("STRIPE");

        System.out.println("API URL : "+ apiUrl);
        System.out.println("enabled : " + enabled);
        System.out.println("TIMEOUT : "+ timeout);
        System.out.println("SUPPORTED CURRENCY : " + supportedCurrency);

        System.out.println("AMOUNT : "+ amount);






    }
}
