package org.cap.demo.service;

import java.util.List;
import java.util.Optional;

import org.cap.demo.model.Account;
import org.cap.demo.model.Customer;
import org.cap.demo.model.Transaction;

public interface IWalletService {
	
	public Optional<Customer> saveRegistration(Customer customer);

	public Optional<Customer> validateUserLogin(Customer Customer);
	
	public Optional<Account> createAccount(Account account);

	public Optional<Account> depositAmount(Account account, double balance);

	public Optional<Account> withdrawAmount(Account account, double amount);

	public Optional<Account> transferAmount(Account account, double amount, int rec_ac_no);
	
	Optional<List<Transaction>> transactionDetails(Account account);

	public Optional<List<Transaction>> transactionParticularDate(Account account, String start_date, String end_date);

	
	


}
