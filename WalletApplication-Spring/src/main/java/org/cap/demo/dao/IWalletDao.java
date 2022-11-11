package org.cap.demo.dao;

import java.util.List;
import java.util.Optional;

import org.cap.demo.model.Account;
import org.cap.demo.model.Address;
import org.cap.demo.model.Customer;
import org.cap.demo.model.Transaction;


public interface IWalletDao {
	
	public Optional<Customer> saveRegistration(Customer customer);

	public Optional<Customer> validateUserLogin(Customer customer);
	
	public Optional<Account> createAccount(Account account);

	Optional<Account> depositAmount(Account account, double amount);

	Optional<Account> WithdrawAmtFunc(Account account, double amount);
	
	public Optional<Account> transferAmount(Account account, double amount, int rec_ac_no);

	Optional<List<Transaction>> transactionDetails(Account account);
	
	public Optional<List<Transaction>> transactionParticularDate(Account account, String start_date, String end_date);




}
