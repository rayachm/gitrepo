package org.cap.demo.model;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;


@Entity
public class Customer {
	
	@Id
	@GeneratedValue
	private int customerId; //primary key auto increment

	@Column(nullable = false)
	private String firstName; //not null
	private String lastName;
	
	@Column(nullable=false)
	private String contactNo; 
	private String gender;
	
	@Transient
	private Address address;
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Column(unique = true)
	private String emailId; //Unique
	
	//private Address address; //reference Address table
	
	@Column(nullable = false)
	private String password;
	
	@Transient
	private String confirmPassword;
	
	@OneToMany(targetEntity = Account.class,mappedBy = "customer")
	private List<Account> accounts=new ArrayList<Account>();
	
	

	public Customer(String firstName, String lastName, String contactNo, String gender, String emailId, 
			String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNo = contactNo;
		this.gender = gender;
		this.emailId = emailId;
		//this.address = address;
		this.password = password;
	}



	public Customer(String emailId, String password) {
		super();
		this.emailId = emailId;
		this.password = password;
	}



	public Customer(String firstName, String lastName, String contactNo, String gender, String emailId, 
			String password, String confirmPassword) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNo = contactNo;
		this.gender = gender;
		this.emailId = emailId;
		//this.address = address;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}



	
	 public Customer(int customerId, String firstName, String lastName, String
	  contactNo, String emailId,  List<Account> accounts) 
	 {
	 super(); 
	 this.customerId = customerId; 
	 this.firstName = firstName;
	  this.lastName = lastName; 
	  this.contactNo = contactNo; 
	  this.emailId = emailId;
	  
	  this.accounts = accounts; }
	
	public Customer() {
		super();
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/*
	 * public Address getAddress() { return address; }
	 * 
	 * public void setAddress(Address address) { this.address = address; }
	 */
	

	/*
	 * public List<Account> getAccounts() { return accounts; }
	 * 
	 * public void setAccounts(List<Account> accounts) { this.accounts = accounts; }
	 * 
	 */

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", contactNo=" + contactNo + ", emailId=" + emailId + ", password="
				+ password + ", confirmPassword=" + confirmPassword +"]"; // ", accounts=" + accounts + 
	}

	

}
