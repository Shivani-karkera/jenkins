package com.example.demo;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Customer;
import com.example.demo.model.CustomerList;
import com.example.demo.model.Invoice;
@SpringBootApplication
public class Quickstart1Application {

   public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Quickstart1Application.class, args);
       // Customer ram = (Customer)ctx.getBean("customer");
        Customer ram =ctx.getBean("customer",Customer.class);
        
         System.out.println(ram);
         
 //Customer shyam= (Customer)ctx.getBean("shyam");
         
 Customer shyam= ctx.getBean("shyam",Customer.class);
 
         System.out.println(shyam);
        
         ctx.getBean(CustomerList.class).getCustList().forEach(System.out::println);
    }
   
@Bean
	public Customer shyam() {
	return new Customer(202,"Shyam", "shyam@abc.com");
}
   
@Bean
public Invoice shyamInvoice() {
	return new Invoice(120,shyam(),LocalDate.of(2022,9,26),26000);
}

@Bean
public Invoice vikas() {
	return new Invoice(120,vikas(),LocalDate.of(2022,9,26),26000);
}
}


