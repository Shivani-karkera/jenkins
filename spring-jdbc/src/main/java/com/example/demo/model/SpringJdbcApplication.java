package com.example.demo.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import com.example.demo.services.CustomerService;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=SpringApplication.run(SpringJdbcApplication.class, args);
	int key=2;
		
		//obj={0,null,null}
		if(key==1) {
			Customer obj= ctx.getBean(Customer.class);
		
		obj.setCustomer_id(Integer.parseInt(args[0]));
		obj.setCustomer_name(args[1]);
		obj.setEmail(args[2]);
		//obj={101,"ram","ram@abc.com"}
		CustomerService service= ctx.getBean(CustomerService.class);
		
		System.out.println("Is Added:=" + service.save(obj));
		
	}
		if(key==2) {
			service.findAll().forEach(System.out::println);
		}
		ctx.close();
	}
}
