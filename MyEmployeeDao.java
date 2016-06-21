package org.springexamples.dao;

import java.util.List;
import java.util.Map;

import org.springexamples.bean.MyEmployee;

public interface MyEmployeeDao {
	
	public void addEmployee(MyEmployee employee);
	public void updateEmployee(MyEmployee employee);
	public void deleteEmployee(MyEmployee employee);
	public List<MyEmployee> fetchEmployee();
	public Map<String,Object> getEmployeeUsingStoredProcById(MyEmployee employee);
	public MyEmployee getEmployeeById(MyEmployee employee);

}
