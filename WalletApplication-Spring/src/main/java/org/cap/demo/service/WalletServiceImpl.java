package org.cap.demo.service;

import java.util.List;
import java.util.Optional;

import org.cap.demo.dao.IWalletDao;
import org.cap.demo.model.Account;
import org.cap.demo.model.Address;
import org.cap.demo.model.Customer;
import org.cap.demo.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("walletService")
public class WalletServiceImpl implements IWalletService{
	
	@Autowired
	private IWalletDao walletDao;
	
	
	@Override
	public Optional<Customer> validateUserLogin(Customer Customer) {
		// TODO Auto-generated method stub
		return walletDao.validateUserLogin(Customer);
	}


	@Override
	public Optional<Customer> saveRegistration(Customer Customer) {
		// TODO Auto-generated method stub
		return walletDao.saveRegistration(Customer);
	}


	@Override
	public Optional<Account> createAccount(Account account) {
		// TODO Auto-generated method stub
		return walletDao.createAccount(account);
	}


	@Override
	public Optional<Account> depositAmount(Account account, double balance) {
		return walletDao.depositAmount(account, balance);
	}

	
	@Override
	public Optional<Account> withdrawAmount(Account account, double amount) {
		return walletDao.WithdrawAmtFunc(account, amount);
	}


	@Override
	public Optional<Account> transferAmount(Account account, double amount, int rec_ac_no) {
		// TODO Auto-generated method stub
		return walletDao.transferAmount(account, amount, rec_ac_no);
	}


	@Override
	public Optional<List<Transaction>> transactionDetails(Account account) {
		// TODO Auto-generated method stub
		return walletDao.transactionDetails(account);
	}


	@Override
	public Optional<List<Transaction>> transactionParticularDate(Account account, String start_date, String end_date) {
		
		return walletDao.transactionParticularDate(account, start_date, end_date);
	}



	


}
