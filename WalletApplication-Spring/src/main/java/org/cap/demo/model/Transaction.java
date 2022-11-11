package org.cap.demo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@SequenceGenerator(initialValue = 1,name = "trans_seq",sequenceName = "trans_seq")
@Entity 
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "trans_seq")
	private int transactionId;
	private LocalDate transactionDate;
	private double transactionAmount;
	private TransactionType transactionType;
	
	@OneToOne
	@JoinColumn(name = " account_fk")
	private Account account;

	public Transaction(int transactionId, LocalDate transactionDate, double transactionAmount,
			TransactionType transactionType, Account account) {
		super();
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
		this.transactionType = transactionType;
		this.account = account;
	}

	public Transaction(LocalDate transactionDate, double transactionAmount, TransactionType transactionType,
			Account account) {
		super();
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
		this.transactionType = transactionType;
		this.account = account;
	}

	public Transaction() {
		super();
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionDate=" + transactionDate
				+ ", transactionAmount=" + transactionAmount + ", transactionType=" + transactionType + ", account="
				+ account + "]";
	}
	
	
}
