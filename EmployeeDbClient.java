package org.springexample.client;

import java.util.ArrayList;
import java.util.List;

import org.springexample.service.MyEmployeeService;
import org.springexamples.bean.MyEmployee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeDbClient {

	public static void main(String[] args) {
		//Registering Spring bean...
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
		
		/**
		 * Please run the code accordingly following series one by one
		 * Step-1
		 * Step-2
		 * Step-3
		 * Step-4
		 * Step-5 (First Comment Step-4)
		 * Step-6 (First Comment Step-5 and Step-4)
		 * Step-7 (First Comment Step-5,4 and 6)
		 */
		
		/*Step-1:
		 * 
		 * MySQL Datbase table script
		 * CREATE TABLE `myemployee` (
			  `empid` bigint(20) NOT NULL AUTO_INCREMENT,
			  `empname` varchar(100),
			  `birthdate` varchar(50),
			  `joindate` varchar(50),
			  `idtype` varchar(25),
			  `idno` varchar(25),
			  `email` varchar(50),
			  `mobileno` varchar(20),
			  PRIMARY KEY (`empid`)
			) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
		 * 
		 */
		
		//Step-2: Creating Employee Records
			List<MyEmployee> employeeList=new ArrayList<MyEmployee>();
			
			MyEmployee employee1=new MyEmployee();
			employee1.setEmpname("Anil Kumar");
			employee1.setBirthDate("04-02-1983");
			employee1.setJoinDate("01-03-2015");
			employee1.setIdType("PAN CARD");
			employee1.setIdno("BPKWE1234H");
			employee1.setMobileno("8834123400");
			employee1.setEmail("anitowrite@hotmail.com");
			
			MyEmployee employee2=new MyEmployee();
			employee2.setEmpname("Mukesh Kumar");
			employee2.setBirthDate("24-12-1986");
			employee2.setJoinDate("01-11-2012");
			employee2.setIdType("PAN CARD");
			employee2.setIdno("APKWK1534D");
			employee2.setMobileno("8934153420");
			employee2.setEmail("mukesh.kumar@gmail.com");
			
			MyEmployee employee3=new MyEmployee();
			employee3.setEmpname("Ramesh Yadav");
			employee3.setBirthDate("24-07-1982");
			employee3.setJoinDate("01-07-2010");
			employee3.setIdType("DRIVING LICENSE");
			employee3.setIdno("DL2012KA45");
			employee3.setMobileno("9916722847");
			employee3.setEmail("ramesh_yadav@gmail.com");
			
			MyEmployee employee4=new MyEmployee();
			employee4.setEmpname("Manish Goel");
			employee4.setBirthDate("22-04-1975");
			employee4.setJoinDate("01-09-1998");
			employee4.setIdType("ELECTION CARD");
			employee4.setIdno("AVZ10098");
			employee4.setMobileno("7560425610");
			employee4.setEmail("manish.goel1998@yahoo.mail.com");
			
			employeeList.add(employee1);
			employeeList.add(employee2);
			employeeList.add(employee3);
			employeeList.add(employee4);
		
		//Step-3: ---------Declaring MyEmployee service---------------------		
		
			MyEmployeeService empService=context.getBean("empService",MyEmployeeService.class);
			
		
		//Step-4:-----------------Inserting Record to database -------------
			
			for(MyEmployee employee:employeeList){
				empService.addEmployee(employee);
			}
		//------------------------------------------------------------------
		
			
		
		//Step-5:----------------Fetch Record from database ----------------
			empService.fetchEmployee();
		//------------------------------------------------------------------
		
		
			
		/*
		//Step-6:----------------Update Record to database -----------------
			MyEmployee employee5=new MyEmployee();
			employee5.setEmpid(10);
			employee5.setEmail("manish_goel@gmail.com");
			employee5.setMobileno("8860312549");
			
			empService.updateEmployee(employee5);
			
			empService.fetchEmployee();
		//------------------------------------------------------------------
		*/
			
		/*
		//Step-7:----------------Delete Record from database ---------------
			MyEmployee employee6=new MyEmployee();
			employee6.setEmpid(9);
			
			empService.deleteEmployee(employee6);
			
			empService.fetchEmployee();
		//------------------------------------------------------------------
		*/
	}

}
