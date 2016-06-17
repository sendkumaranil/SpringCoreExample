package org.springexamples.bean;

public class Address {

	private String address1;
	private String city;
	private String state;
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Address [address1=" + address1 + ", city=" + city + ", state="
				+ state + "]";
	}
}
