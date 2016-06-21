package org.springexamples.service;
import java.util.List;
import java.util.Map;

import org.springexamples.bean.MyEmployee;
/**
 * This class using Database CRUD Operation using NamedParameterJdbcTemplate.
 */
import org.springexamples.dao.MyEmployeeDao;

public class MyEmployeeServiceV2 {
	
	private MyEmployeeDao v2MyEmpDaoObj;

	public MyEmployeeDao getV2MyEmpDaoObj() {
		return v2MyEmpDaoObj;
	}

	public void setV2MyEmpDaoObj(MyEmployeeDao v2MyEmpDaoObj) {
		this.v2MyEmpDaoObj = v2MyEmpDaoObj;
	}
	
	public void addEmployeeRecord(MyEmployee employee){
		v2MyEmpDaoObj.addEmployee(employee);
	}

	public void updateEmployeeRecord(MyEmployee employee ){
		v2MyEmpDaoObj.updateEmployee(employee);
	}
	
	public void deleteEmployeeRecord(MyEmployee employee){
		v2MyEmpDaoObj.deleteEmployee(employee);
	}
	
	public void getEmployeeList(){
		List<MyEmployee> employeeList=v2MyEmpDaoObj.fetchEmployee();
		System.out.println("Employee Records:");
		int count=0;
		if(employeeList !=null && !employeeList.isEmpty()){
			for(MyEmployee employee:employeeList){
				System.out.println("------------------Record["+(++count)+"]-----------------------------------------");
					System.out.println("Employee Id:"+employee.getEmpid());
					System.out.println("Employee Name:"+employee.getEmpname());
					System.out.println("Employee Birth Date:"+employee.getBirthDate());
					System.out.println("Employee join Date"+employee.getJoinDate());
					System.out.println("Employee Id Type:"+employee.getIdType()+" Employee Id No:"+employee.getIdno());
					System.out.println("Employee Mobile No:"+employee.getMobileno());
					System.out.println("Employee email:"+employee.getEmail());
				System.out.println("-------------------------------------------------------------------");
			}
		}else{
			System.out.println("-----------Record Not Found in Database---------------");
		}
	}
	
	public void getEmployeeById(MyEmployee emp){
		MyEmployee employee=v2MyEmpDaoObj.getEmployeeById(emp);
		if(emp !=null){
			
				System.out.println("------------------------------------------------------------------");
					System.out.println("Employee Id:"+employee.getEmpid());
					System.out.println("Employee Name:"+employee.getEmpname());
					System.out.println("Employee Birth Date:"+employee.getBirthDate());
					System.out.println("Employee join Date"+employee.getJoinDate());
					System.out.println("Employee Id Type:"+employee.getIdType()+" Employee Id No:"+employee.getIdno());
					System.out.println("Employee Mobile No:"+employee.getMobileno());
					System.out.println("Employee email:"+employee.getEmail());
				System.out.println("-------------------------------------------------------------------");
			
		}else{
			System.out.println("-----------Record Not Found in Database---------------");
		}
	}
	
	public void getEmployeeUsingStoredProcById(MyEmployee emp){
		Map employeeMap=v2MyEmpDaoObj.getEmployeeUsingStoredProcById(emp);
		
		System.out.println("------------------------------------------------------------------");
			System.out.println("Employee Id:"+emp.getEmpid());
			System.out.println("Employee Name:"+employeeMap.get("v_empname"));
			System.out.println("Employee Birth Date:"+employeeMap.get("v_birthdate"));
			System.out.println("Employee join Date"+employeeMap.get("v_joindate"));
			System.out.println("Employee Id Type:"+employeeMap.get("v_idtype")+" id no:"+employeeMap.get("v_idno"));
			System.out.println("Employee Mobile No:"+employeeMap.get("v_mobileno"));
			System.out.println("Employee email:"+employeeMap.get("v_email"));
		System.out.println("-------------------------------------------------------------------");
	}
}
