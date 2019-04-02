package com.nt.test;

import java.util.Scanner;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.nt.controller.MainController;
import com.nt.vo.CustomerVO;

public class ClientTest {

	public static void main(String[] args) {
		Scanner sc=null;
		String cname=null;
		CustomerVO vo=null;
		MainController controller=null;
		String result=null;
		String principle=null, rate=null, period=null;
		sc=new Scanner(System.in);
		System.out.println("Enter Customer Name");
		cname=sc.next();
		System.out.println("Enter Amount ::");
		principle=sc.next();
		System.out.println("Eneter period in years");
		period=sc.next();
		System.out.println("Enter Rate of Interest");
		rate=sc.next();
		vo=new CustomerVO();
		vo.setCname(cname);
		vo.setPrinciple(principle);
		vo.setPeriod(period);
		vo.setRate(rate);
		
		@SuppressWarnings("deprecation")
		BeanFactory factory=new XmlBeanFactory(new ClassPathResource("com/nt/cnfg/applicationContext.xml"));
	  controller=factory.getBean("main",MainController.class);
	  try {
		result=controller.processResult(vo);
		System.out.println(result);
	} catch (Exception e) {
		System.out.println("Internal Problem: Try again");
		e.printStackTrace();
	}
		
	
	}

}
