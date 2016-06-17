package org.springexamples.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Employee {
	private int empid;
	private String empname;
	private List<String> phoneno=new ArrayList<String>();
	private Map<String,String> govtIds=new HashMap<String, String>();
	private Address empadd;
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	
	public List<String> getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(List<String> phoneno) {
		this.phoneno = phoneno;
	}
	
	
	public Map<String, String> getGovtIds() {
		return govtIds;
	}
	public void setGovtIds(Map<String, String> govtIds) {
		this.govtIds = govtIds;
	}
	
	public Address getEmpadd() {
		return empadd;
	}
	public void setEmpadd(Address empadd) {
		this.empadd = empadd;
	}
	
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname
				+ ", phoneno=" + phoneno + ", govtIds=" + govtIds + ", empadd="
				+ empadd + "]";
	}
	
	public Employee(int empid,String empname){
		this.empid=empid;
		this.empname=empname;
	}
	
	public Employee(){
		
	}
}
