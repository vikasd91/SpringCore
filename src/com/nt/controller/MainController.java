package com.nt.controller;

import com.nt.dto.CustomerDTO;
import com.nt.service.CustomerService;
import com.nt.vo.CustomerVO;

public class MainController {
	private CustomerService service;
	
	public MainController(CustomerService service) {
		this.service=service;
	}
	public String processResult(CustomerVO vo) throws Exception {
		//
		String result=null;
		CustomerDTO dto=null;
		dto=new CustomerDTO();
		//convert  VO object to DTO object
		dto.setCname(vo.getCname());
		dto.setPrinciple(Double.parseDouble(vo.getPrinciple()));
		dto.setPeriod(Integer.parseInt(vo.getPeriod()));
		dto.setRate(Double.parseDouble(vo.getRate()));
		result=service.generateInterest(dto);
		return result;
	}
	

	

}
