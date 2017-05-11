package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserTest {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");// scan this package and find out where the
									// Annotations

		context.refresh();

		// if you need any instance,do not create.
		// you can ask context to get the particular bean getBean()

		context.getBean("category"); // generally bean will be class name but
										// the first character will be lower
										// case.

		System.out.println("The  instannce is created sucessfully");
	}
}
