package com.priya.expense;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.priya.expense.*")
public class ExpenseTrackerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerServiceApplication.class, args);
	}

}
