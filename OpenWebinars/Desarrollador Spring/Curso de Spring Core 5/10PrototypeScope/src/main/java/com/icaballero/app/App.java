package com.icaballero.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icaballero.app.beans.IEmailService;

public class App {

	public static void main(String[] args) {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");


		IEmailService emailService1 = appContext.getBean(IEmailService.class);
		IEmailService emailService2 = appContext.getBean(IEmailService.class);

		System.out.println(emailService1);
		System.out.println(emailService2);

		((ClassPathXmlApplicationContext) appContext).close();

	}

}
