package org.springexample.service;

import java.util.List;

import org.springexamples.bean.MyEmployee;
import org.springexamples.dao.MyEmployeeDao;
import org.springexamples.daoImpl.MyEmployeeDaoImpl;

public class MyEmployeeService {
	
	private MyEmployeeDao employeeObj;
	
	public void addEmployee(MyEmployee employee){
		employeeObj.addEmployee(employee);
	}
	
	public void updateEmployee(MyEmployee employee){
		employeeObj.updateEmployee(employee);		
	}
	
	public void deleteEmployee(MyEmployee employee){
		employeeObj.deleteEmployee(employee);		
	}
	
	public void fetchEmployee(){
		
		List<MyEmployee> employeeList=employeeObj.fetchEmployee();
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

	public void getEmployeeUsingStoredProcById(MyEmployee emp){
		Map<String,Object> employeeMap=employeeObj.getEmployeeUsingStoredProcById(emp);
		
		for(Map.Entry<String, Object> keyValue:employeeMap.entrySet()){
			System.out.println(keyValue.getValue());
		}
		
	}
	
	public MyEmployeeDao getEmployeeObj() {
		return employeeObj;
	}

	public void setEmployeeObj(MyEmployeeDao employeeObj) {
		this.employeeObj = employeeObj;
	}
	
}
