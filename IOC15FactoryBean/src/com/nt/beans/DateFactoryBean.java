package com.nt.beans;

import java.util.Date;

import org.springframework.beans.factory.FactoryBean;

public class DateFactoryBean implements FactoryBean<Date> {
	private int year, date, month;
	public DateFactoryBean(int year, int date, int month) {
		System.out.println("3-  param constructor");
		this.year = year;
		this.date = date;
		this.month = month;
	}

	@Override
	public Date getObject() throws Exception {
		// TODO Auto-generated method stub
		return new Date(year,date,month);
	}

	@Override
	public Class<Date> getObjectType() {
		// TODO Auto-generated method stub
		return Date.class;
	}

}
