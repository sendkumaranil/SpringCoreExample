package org.springexamples.bean;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Account implements ApplicationContextAware,BeanNameAware {

	private int accountno;
	private String accountname;
	
	private ApplicationContext context;
	
	public int getAccountno() {
		return accountno;
	}


	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}


	public String getAccountname() {
		return accountname;
	}


	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}


	@Override
	public void setApplicationContext(ApplicationContext appContext)
			throws BeansException {
		this.context=appContext;
	}

	public void display(){
		System.out.println("Account No:"+accountno);
		System.out.println("Name:"+accountname);
		System.out.println("Application Start Date:"+convertTime(context.getStartupDate()));
		System.out.println("Application ID:"+context.getId());
		System.out.println("Application display Name:"+context.getDisplayName());
	}
	public String convertTime(long time){
	    Date date = new Date(time);
	    Format format = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
	    return format.format(date);
	}


	@Override
	public void setBeanName(String beanName) {
		System.out.println("Hey! following is your bean name:");
		System.out.println("Bean Name:"+beanName);
	}
}
