package com.springbootbasics.springBootPractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPracticeApplication.class, args);
	}

	//this is tightly coupled
	//RazorPayService payment = new RazorPayService();

	// RazorPayService payment;

	// //injecting bean through constructor
	// public SpringBootPracticeApplication(RazorPayService payment) {
	// 	this.payment = payment;
	// }


	// @Override
	// public void run(String... args) throws Exception {
	// 	String salary = payment.pay();
	// 	System.out.println("salary" + salary);
		
	// }



	
}
