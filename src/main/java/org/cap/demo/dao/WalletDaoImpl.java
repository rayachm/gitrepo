package org.cap.demo.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.cap.demo.model.Account;
import org.cap.demo.model.Address;
import org.cap.demo.model.Customer;
import org.cap.demo.model.Transaction;
import org.cap.demo.model.TransactionType;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Transactional
@Repository("walletDao")
public class WalletDaoImpl implements IWalletDao{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Optional<Customer> saveRegistration(Customer customer) {
		entityManager.persist(customer);
		Address address = customer.getAddress();
		address.setCustomer(customer);
		entityManager.persist(address);
		return Optional.of(customer);	

	}


	@Override
	public Optional<Customer> validateUserLogin(Customer details) {


		String sql="from Customer c where c.emailId=:uname and c.password=:upwd";
		Query query=entityManager.createQuery(sql);
		query.setParameter("uname", details.getEmailId());
		query.setParameter("upwd", details.getPassword());

		List<Customer> userDetails=query.getResultList();
		//System.out.println(userDetails.get(0));

		if(userDetails.size()>0)
			return Optional.of(userDetails.get(0));

		return Optional.empty();
	}

	@Override
	public Optional<Account> createAccount(Account account) {
		entityManager.persist(account);
		return Optional.of(account);
	}


	@Override
	public Optional<Account> depositAmount(Account account, double amount) {
		System.out.println(account.getAccountType().ordinal());
		System.out.println(+account.getCustomer().getCustomerId());

		String sql = "from Account where customer_fk =: custId and accountType=: atype";
		Query query = entityManager.createQuery(sql);
		query.setParameter("custId", account.getCustomer().getCustomerId());
		query.setParameter("atype", account.getAccountType());
		//List result set
		List<Account> acc = query.getResultList();
		System.out.println(acc);
		System.out.println(acc.get(0).getAccountNumber());
		int acno=acc.get(0).getAccountNumber();

		if (acc.size()>0) {
			String sql1 = "update Account set balance=balance+" +amount+ " where accountNumber="+acno;
			Query query1 = entityManager.createQuery(sql1);
			query1.executeUpdate();

			account.setAccountNumber(acno);
			Transaction transaction = new Transaction(LocalDate.now(),amount,TransactionType.CREDIT,account);
			entityManager.persist(transaction);
			return Optional.of(acc.get(0));
		}
		return Optional.empty();
	}


	@Override
	public Optional<Account> WithdrawAmtFunc(Account account, double amount) {
		
		System.out.println(account.getAccountType().ordinal());
		System.out.println(account.getCustomer().getCustomerId());

		String sql = "from Account where customer_fk =: custId and accountType=: atype";
		Query query = entityManager.createQuery(sql);
		query.setParameter("custId", account.getCustomer().getCustomerId());
		query.setParameter("atype", account.getAccountType());
		System.out.println("List result set");
		List<Account> acc = query.getResultList();
		System.out.println(acc);
		System.out.println(acc.get(0).getAccountNumber());
		int acno=acc.get(0).getAccountNumber();
		double balance = acc.get(0).getBalance();

		if (acc.size()>0) {
			if(balance>=amount) {
				String sql1 = "update Account set balance=balance-" +amount+ " where accountNumber="+acno;
				Query query1 = entityManager.createQuery(sql1);
				query1.executeUpdate();

				account.setAccountNumber(acno);
				Transaction transaction = new Transaction(LocalDate.now(),amount,TransactionType.DEBIT,account);
				entityManager.persist(transaction);
				return Optional.of(acc.get(0));
			}
			return Optional.empty();
		}	
		return Optional.empty();
	}


	@Override
	public Optional<Account> transferAmount(Account account, double amount, int rec_ac_no) {
		// TODO Auto-generated method stub
		System.out.println(account.getAccountType().ordinal());
		System.out.println(account.getCustomer().getCustomerId());

		String sql = "from Account where customer_fk =: custId and accountType=: atype";
		Query query = entityManager.createQuery(sql);
		query.setParameter("custId", account.getCustomer().getCustomerId());
		query.setParameter("atype", account.getAccountType());
		System.out.println("List result set");
		List<Account> acc = query.getResultList();
		System.out.println(acc);
		System.out.println("Account number in DAO layer "+ acc.get(0).getAccountNumber());
		int acno=acc.get(0).getAccountNumber();
		double balance=acc.get(0).getBalance();

		if (acc.size()>0) {
			if (balance >=amount) {
				String sql1 = "update Account set balance=balance-" +amount+ " where accountNumber="+acno;
				String sql2 = "update Account set balance=balance+" +amount+ " where accountNumber="+rec_ac_no;
				Query query1 = entityManager.createQuery(sql1);
				query1.executeUpdate();

				Query query2 = entityManager.createQuery(sql2);
				query2.executeUpdate();

				account.setAccountNumber(acno);
				Transaction transaction = new Transaction(LocalDate.now(),amount,TransactionType.DEBIT,account);
				entityManager.persist(transaction);

				Account ac = new Account();
				ac.setAccountNumber(rec_ac_no);
				Transaction transaction1 = new Transaction(LocalDate.now(),amount,TransactionType.CREDIT,ac);
				entityManager.persist(transaction1);
				return Optional.of(acc.get(0));
			}
			return Optional.empty();
		}

		return Optional.empty();
	}


	@Override
	public Optional<List<Transaction>> transactionDetails(Account account) {
		String sql = "from Account where customer_fk =: custId and accountType=: atype";
		Query query = entityManager.createQuery(sql);
		query.setParameter("custId", account.getCustomer().getCustomerId());
		query.setParameter("atype", account.getAccountType());
		List<Account> acc = query.getResultList();
		int acno=acc.get(0).getAccountNumber();
		sql = "from Transaction where account_fk="+acno;
		query = entityManager.createQuery(sql);
		List<Transaction> trans = query.getResultList();
		
		for(int i=0;i<trans.size();i++){
		    System.out.println(trans.get(i));
		} 
		
		if(trans.size()>0)
			return Optional.of(trans);
			
		else
			return Optional.empty();
	}


	@Override
	public Optional<List<Transaction>> transactionParticularDate(Account account, String start_date, String end_date) {
		
		String sql = "from Account where customer_fk =: custId and accountType=: atype";
		Query query = entityManager.createQuery(sql);
		query.setParameter("custId", account.getCustomer().getCustomerId());
		query.setParameter("atype", account.getAccountType());
		List<Account> acc = query.getResultList();
		int acno=acc.get(0).getAccountNumber();
		sql = "FROM Transaction where account_fk="+acno+" and transactionDate >='"+start_date+"' and transactionDate <= '"+end_date+"'";
		query = entityManager.createQuery(sql);
		List<Transaction> trans = query.getResultList();
		
		for(int i=0;i<trans.size();i++){
		    System.out.println(trans.get(i));
		} 
		
		if(trans.size()>0)
			return Optional.of(trans);
			
		else
			return Optional.empty();	
	
	}


}
