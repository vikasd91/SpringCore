package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.ScheduleRemainder;

public class ClientApp {
	public static void main(String[] args) {
		
		ApplicationContext ctx=null;
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		
		ScheduleRemainder remainder=ctx.getBean("remainder",ScheduleRemainder.class);
		
		System.out.println(remainder);
	}

}
