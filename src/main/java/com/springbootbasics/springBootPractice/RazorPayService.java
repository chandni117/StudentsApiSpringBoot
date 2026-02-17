package com.springbootbasics.springBootPractice;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;


@Component
public class RazorPayService {

    @GetMapping("/")
    public String pay() {
        String payment = "payment through razorpay";
        System.out.println(payment);
        return payment;
    }

}
