package com.itp.beans;

public class Employee {
	private int empId;
	private String empName;
	private String empDesignation;
	private String empAddress;
	
	public Employee(int empId, String empName, String empDesignation, String empAddress) {
		this.empId = empId;
		this.empName = empName;
		this.empDesignation = empDesignation;
		this.empAddress = empAddress;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

}
