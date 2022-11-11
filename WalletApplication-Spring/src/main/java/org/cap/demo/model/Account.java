package org.cap.demo.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@SequenceGenerator(initialValue = 10000,sequenceName = "accSeq",name = "accSeq")
@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "accSeq")
	private int accountNumber; //pk
	
	
	private AccountType accountType; //drop down box
	
	private LocalDate openingDate=LocalDate.now();
	private double balance; // min 500 //number box
	private String description; //textarea
	
	
	@ManyToOne
	@JoinColumn(name = "customer_fk")
	private Customer customer; //refernce Customer customerId
	
	//private List<Transaction> transactions=new ArrayList<>();


	
	
	public Account(int accountNumber, AccountType accountType, LocalDate openingDate, double balance,
			String description) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.openingDate = openingDate;
		this.balance = balance;
		this.description = description;
	}


	public Account(AccountType accountType, LocalDate openingDate, double balance, String description,
			Customer customer) {
		super();
		this.accountType = accountType;
		this.openingDate = openingDate;
		this.balance = balance;
		this.description = description;
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	
	

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	/*
	 * public Account(int accountNumber, AccountType accountType, LocalDate
	 * openingDate, double balance, String description, List<Transaction>
	 * transactions) { super(); this.accountNumber = accountNumber; this.accountType
	 * = accountType; this.openingDate = openingDate; this.balance = balance;
	 * this.description = description; this.transactions = transactions; }
	 */

	public Account() {
		super();
	}


	public int getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}


	public AccountType getAccountType() {
		return accountType;
	}


	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}


	public LocalDate getOpeningDate() {
		return openingDate;
	}


	public void setOpeningDate(LocalDate openingDate) {
		this.openingDate = openingDate;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	/*
	 * public List<Transaction> getTransactions() { return transactions; }
	 * 
	 * 
	 * public void setTransactions(List<Transaction> transactions) {
	 * this.transactions = transactions; }
	 */


	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountType=" + accountType + ", openingDate="
				+ openingDate + ", balance=" + balance + ", description=" + description  + "]";
		//+ ", transactions=" + transactions
	}
	
	

}
