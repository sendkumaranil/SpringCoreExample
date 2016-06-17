package org.springexamples.bean;

public class Customer {
	private int custId;
	private String custName;
	private Address custadd;
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	public void myInit(){
		System.out.println("All properties of Customer has been injected");
	}
	public void myDestroy(){
		System.out.println("Destroyed all customer's  properties from memory");
	}
	public void display(){
		System.out.println("Customer id:"+custId+" Customer Name:"+custName);
		System.out.println("Customer add:"+custadd);
	}
	
	public Customer(Address address){
		this.custadd=address;
	}
	public Customer(){
		
	}
}
