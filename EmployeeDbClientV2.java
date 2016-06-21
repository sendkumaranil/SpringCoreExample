package org.springexample.client;

import org.springexamples.bean.MyEmployee;
import org.springexamples.service.MyEmployeeServiceV2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeDbClientV2 {

	public static void main(String[] args) {
		/*
		 * This class access database by using spring NamedParameterJdbcTemplate
		 * 
		 * and Stored procedure call by using SimpleJdbcCall
		 * 
		 * 	DELIMITER $$
			CREATE PROCEDURE `getEmployeeDetailById`(
			IN id bigint,
			OUT v_empname varchar(100),
			OUT v_birthdate varchar(50),
			OUT v_joindate varchar(50),
			OUT v_idtype varchar(25),
			OUT v_idno varchar(25),
			OUT v_email varchar(50),
			OUT v_mobileno varchar(20)
			)
			begin
				select 
					empname,birthdate,joindate,idtype,idno,email,mobileno 
				into 
					v_empname,v_birthdate,v_joindate,v_idtype,v_idno,v_email,v_mobileno 
				from myemployee where empid=id;
			end$$
			DELIMITER ;
		 * 
		 */
		
		//Register Spring bean definition
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
		//creating Employee Service Object
		MyEmployeeServiceV2 empServiceV2=(MyEmployeeServiceV2)applicationContext.getBean("v2EmpService");
		
		//Step-1: Inserting Records:
		
		/*MyEmployee employee1=new MyEmployee();
		employee1.setEmpname("Saurabh Jain");
		employee1.setBirthDate("19-11-1987");
		employee1.setJoinDate("01-10-2012");
		employee1.setIdType("PAN CARD");
		employee1.setIdno("AAKJAY112DF");
		employee1.setMobileno("9912323567");
		employee1.setEmail("saurabh_jain@yahoo.mail.com");
		
		MyEmployee employee2=new MyEmployee();
		employee2.setEmpname("Sunita Desai");
		employee2.setBirthDate("12-08-1995");
		employee2.setJoinDate("01-01-2015");
		employee2.setIdType("ADHAR CARD");
		employee2.setIdno("9537-1140-5543");
		employee2.setMobileno("9172453103");
		employee2.setEmail("sn_desai@gmail.com");
		
		empServiceV2.addEmployeeRecord(employee1);
		empServiceV2.addEmployeeRecord(employee2);*/
		
		//Step-2: Updating record
		/*MyEmployee employee3=new MyEmployee();
		employee3.setEmpid(16);
		employee3.setEmpname("Priya Malhotra");
		employee3.setBirthDate("20-08-1990");
		employee3.setJoinDate("01-05-2013");
		employee3.setIdType("ADHAR CARD");
		employee3.setIdno("9567-0040-6543");
		employee3.setMobileno("9917722847");
		employee3.setEmail("priya_malhotra@gmail.com");
		
		empServiceV2.updateEmployeeRecord(employee3);*/
		
		//Step-3: Delete record
		/*MyEmployee employee4=new MyEmployee();
		employee4.setEmpid(17);
		
		empServiceV2.deleteEmployeeRecord(employee4);*/
		
		//Step-4: Fetch all records
		
		//empServiceV2.getEmployeeList();
		
		//Step-5: fetch perticular record
		/*MyEmployee employee5=new MyEmployee();
		employee5.setEmpid(14);
		empServiceV2.getEmployeeById(employee5);*/
		
		//Step-6: calling procedure by using SimpleJdbcCall
		/*MyEmployee employee6=new MyEmployee();
		employee6.setEmpid(16);
		empServiceV2.getEmployeeUsingStoredProcById(employee6);*/
	}

}
