package com.nt.service;

import java.text.DecimalFormat;
import java.util.Formatter;

import com.nt.bo.CustomerBO;
import com.nt.dao.CustomerDAO;
import com.nt.dto.CustomerDTO;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDAO dao;
	private CustomerBO bo;
	public CustomerServiceImpl(CustomerDAO dao) {
		this.dao=dao;
	}
	@Override
	public String generateInterest(CustomerDTO dto) throws Exception {
	//	(p*n*r)/100;
		double si=0.0;
		double amount=0.0;
		double ci=0.0;
		//simple   interest (p*n*r)/100
		si=(dto.getPrinciple()*dto.getPeriod()*dto.getRate())/100;
		
		//calculate compound interest total amount 
		//double CI = principle *  (Math.pow((1 + rate / 100), time));
		//a=p*(1+r/100) power t;
		amount=dto.getPrinciple()*Math.pow(1+dto.getRate()/100, dto.getPeriod());
		
		//compound interest is
		ci=amount-dto.getPrinciple();
		
		bo=new CustomerBO();
		bo.setName(dto.getCname());
		bo.setPrinciple(dto.getPrinciple());
		bo.setPeriod(dto.getPeriod());
		bo.setRate(dto.getRate());
		bo.setSi(si);
		bo.setCi(ci);
		int count=dao.insert(bo);
		if(count!=0)
		return "Simple Interest and Compound Interest for  amount "+dto.getPrinciple()+" and duration  " +dto.getPeriod()+" is SI="+ si+ "CI="+ci;
		else {
			return "Invalid Entry: Plese Try Again";
		}
	}

}
