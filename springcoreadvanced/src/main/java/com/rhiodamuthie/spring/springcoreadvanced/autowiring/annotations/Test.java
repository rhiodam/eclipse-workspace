package com.rhiodamuthie.spring.springcoreadvanced.autowiring.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/rhiodamuthie/spring/springcoreadvanced/autowiring/annotations/conf.xml");
		
		Employee e = (Employee) context.getBean("emp");
		
		System.out.println(e);
		

	}

}
