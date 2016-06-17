package org.springexample.client;

import org.springexamples.bean.Account;
import org.springexamples.bean.Customer;
import org.springexamples.bean.Employee;
import org.springexamples.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
		
		//<!-- Employee Setter Injection -->
		Employee empObj=applicationContext.getBean("employee",Employee.class);		
		System.out.println(empObj);
		
		//<!-- Employee Constructor Injection -->
		Employee empObj2=applicationContext.getBean("emp",Employee.class);		
		System.out.println(empObj2);
		
		//<!-- Injecting Reference Address bean with Employee -->
		Employee empObj3=applicationContext.getBean("myEmp",Employee.class);		
		System.out.println(empObj3);
		
		//<!-- Initialization and Destruction of Bean -->
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
		context.registerShutdownHook();
		Person personObj=applicationContext.getBean("person",Person.class);	
		personObj.display();
		
		Customer custObj=applicationContext.getBean("customer",Customer.class);	
		custObj.display();
		
		//<!-- Bean Scope Prototype-->
		Person perScopeObj1=applicationContext.getBean("myPerson",Person.class);	
		perScopeObj1.display();
		
		Person perScopeObj2=applicationContext.getBean("myPerson",Person.class);	
		perScopeObj2.display();
		
		System.out.println(perScopeObj1==perScopeObj2);//should display false
		
		//<!-- Bean Scope Singleton-->
		Person perSinltonObj1=applicationContext.getBean("person",Person.class);	
		Person perSinltonObj2=applicationContext.getBean("person",Person.class);	
		
		System.out.println(perSinltonObj1==perSinltonObj2);//Should display true
		
		 //<!-- Autowiring Address bean with Employee using byName -->
		Employee myEmpObj=applicationContext.getBean("myEmployee",Employee.class);		
		System.out.println(myEmpObj);
		
		//<!-- Autowiring Address bean with Customer bean using constructor -->
		Customer myCustObj=applicationContext.getBean("myCustomer",Customer.class);	
		myCustObj.display();
		
		//<!-- ApplicationContextAware, BeanNameAware Example -->
		Account accObj=applicationContext.getBean("account",Account.class);
		accObj.display();
	
		//<!-- Internationalization using MessageResource and ResourceBundleMessageResource -->
		System.out.println(applicationContext.getMessage("DisplayMessage", null, "DefaultMessage", null));
		
		Person perMsgObj=applicationContext.getBean("personMsg",Person.class);
		perMsgObj.displayCustomMsg();
		
	}

}
