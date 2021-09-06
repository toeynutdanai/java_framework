package com.example.demoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoappApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoappApplication.class, args);
//		Beans
		System.out.println(context.getBeanDefinitionCount());
		String[] names = context.getBeanDefinitionNames();
		
		for(String str : names) {
			System.out.println(str);
		}
		System.out.println(context.getBeanDefinitionCount());
	}

}
