package org.springexamples.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.MessageSource;

public class Person implements InitializingBean,DisposableBean {
	private int personid;
	private String personName;
	
	private MessageSource messageSource;
	
	public int getPersonid() {
		return personid;
	}
	public void setPersonid(int personid) {
		this.personid = personid;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("All properties of Person destroyed from memories...");
		
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("All properties of Person has been injected successfully!!");		
	}
	
	public void display(){
		System.out.println("PersonId:"+personid+" Person name:"+personName);		
	}
	public MessageSource getMessageSource() {
		return messageSource;
	}
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	public void displayCustomMsg(){
		System.out.println("PersonId:"+personid+" Person name:"+personName);
		System.out.println(messageSource.getMessage("CustomMessage", null, "DefaultMessage", null));
		System.out.println(messageSource.getMessage("paramMessage", new Object[]{"Anil","Myntra"}, "DefaultMessage", null));
	}

}
