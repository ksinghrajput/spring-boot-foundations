package com.codewithkishan.onlinestore.config;

import com.codewithkishan.onlinestore.service.OrderService;
import com.codewithkishan.onlinestore.service.PaymentService;
import com.codewithkishan.onlinestore.service.PaypalPaymentService;
import com.codewithkishan.onlinestore.service.StripePaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${payment-gatway:stripe}")
    private String paymentGatway;

    @Bean
    public PaymentService stripe(){
      return new StripePaymentService();
    }

    @Bean
    public PaymentService paypal(){
        return new PaypalPaymentService();
    }

    @Beangit
    public OrderService orderService(){
        if (paymentGatway.equals("stripe")) {
            return new OrderService(stripe());
        } else {
            return new OrderService(paypal());
        }
    }
}
