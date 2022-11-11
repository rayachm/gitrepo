package org.cap.demo.controller;

import java.time.LocalDate;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.cap.demo.model.Account;
import org.cap.demo.model.AccountType;
import org.cap.demo.model.Customer;
import org.cap.demo.model.Transaction;
import org.cap.demo.service.IWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@SessionAttributes({"custId","userName"})
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IWalletService walletService;

	@RequestMapping(value="/registerUser",method = RequestMethod.POST)
	public String saveRegistration(
			@Valid @ModelAttribute("registration")Customer  registration,BindingResult result) {

		if(result.hasErrors()) {	
			return "register";

		}else {
			Optional<Customer> customer = walletService.saveRegistration(registration);
			return "redirect:/";
		}	
	}


	@RequestMapping("/register")
	public ModelAndView getRegisterPage() {
		return new ModelAndView("Signup","registration",new Customer());
	}

	@RequestMapping("/login")
	public String getloginPage() {
		return "redirect:/";
	}

	
	@RequestMapping("/Homepage")
	public ModelAndView HomePage(ModelMap map,HttpSession session) {
		String userName=session.getAttribute("userName").toString();
		String custId=session.getAttribute("custId").toString();

		map.addAttribute("userName", userName);
		map.addAttribute("custId", custId);
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("Home");
		return modelAndView;
	}



	@RequestMapping(value = "/validateLogin",method = RequestMethod.POST)
	public ModelAndView validateUserLogin(HttpSession session ,@RequestParam("userName") String userName,
			@RequestParam("userPwd") String userPwd ) {

		ModelAndView modelAndView = new ModelAndView();

		Customer customer = new Customer();
		customer.setEmailId(userName);
		customer.setPassword(userPwd);

		Optional<Customer> optional =  walletService.validateUserLogin(customer);
		
		

		if(!optional.isEmpty()){
			modelAndView.addObject("userName", optional.get().getEmailId());
			modelAndView.addObject("custId", optional.get().getCustomerId());
			session.setAttribute("userName",optional.get().getEmailId());
			session.setAttribute("custId",optional.get().getCustomerId());
			
			modelAndView.setViewName("Home");
		}
		else{
			modelAndView.setViewName("redirect:/");
		}
		return modelAndView;
	}
	
	
	@RequestMapping("/TPage")
	public String TPage() {
		return "transactionsDisplay";
	}
	
	@RequestMapping(value = "/transactionDetails", method = RequestMethod.POST)
	public ModelAndView transactionDetails(ModelMap map,HttpSession session,
			@RequestParam("customerId") int custId, @RequestParam("atype") String atype){
		ModelAndView modelAndView = new ModelAndView();
		Account account = new Account();
		Customer customer = new Customer();
		customer.setCustomerId(custId);
		account.setCustomer(customer);
		account.setAccountType(AccountType.valueOf(atype));
		Optional<List<Transaction>>  optional = walletService.transactionDetails(account);
		System.out.println(optional.get());
		
		if (!optional.isEmpty()) {
			map.addAttribute("transactions", optional.get());
			modelAndView.setViewName("Tlist");
			return modelAndView;
		}
		else {
			modelAndView.setViewName("transactionsDisplay");
			return modelAndView;
		}
	}
	


	@RequestMapping("/createAccpage")
	public ModelAndView getcreateAccpage(ModelMap map,HttpSession session) {
		String userName=session.getAttribute("userName").toString();
		String custId=session.getAttribute("custId").toString();

		map.addAttribute("userName", userName);
		map.addAttribute("custId", custId);
		ModelAndView modelAndView = new ModelAndView();

		//return "createAcc";
		modelAndView.setViewName("createAcc");
		return modelAndView;
	}


	@RequestMapping(value = "/AccountCreation",method = RequestMethod.POST)
	public ModelAndView createAccount(@RequestParam("customerId") int custId,
			@RequestParam("atype") String atype,@RequestParam("balance")double balance,
			@RequestParam("description") String description, HttpSession session) {

		ModelAndView modelAndView = new ModelAndView();
		Customer customer = new Customer();
		customer.setCustomerId(custId);
		Account account = new Account(AccountType.valueOf(atype),LocalDate.now(),balance,description,customer);

		Optional<Account> acc= walletService.createAccount(account);

		if(!acc.isEmpty()){
			modelAndView.setViewName("Home");
		}
		else{
			modelAndView.setViewName("createAccpage");
		}

		return modelAndView;
	}




	@RequestMapping("/depositWithdrawMoneypage")
	public ModelAndView depositWithdrawMoneyPage(ModelMap map,HttpSession session) {
		String userName=session.getAttribute("userName").toString();
		String custId=session.getAttribute("custId").toString();

		map.addAttribute("userName", userName);
		map.addAttribute("custId", custId);
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("deposit");
		return modelAndView;
	}


	@RequestMapping(value = "/DepositeAmtFunc", method = RequestMethod.POST)
	public ModelAndView depositeAmt(@RequestParam("customerId") int custId, @RequestParam("atype") String atype,
			@RequestParam("balance") double balance,
			@RequestParam("tType") String tType, HttpSession session) {

		ModelAndView modelAndView = new ModelAndView();
		Customer customer = new Customer();
		customer.setCustomerId(custId);
		Account account = new Account();
		account.setCustomer(customer);

		account.setAccountType(AccountType.valueOf(atype));

		System.out.println(account.getAccountType());
	


		Optional<Account> optional = walletService.depositAmount(account, balance);		

		if (!optional.isEmpty()) {
			modelAndView.setViewName("Home");
			return modelAndView;
		}
		else {
			modelAndView.setViewName("redirect:/");
			return modelAndView;
		}
	}


	@RequestMapping("/withdrawAmtPage")
	public ModelAndView getwithdrawAmtPage(ModelMap map, HttpSession session) {
		String userName = session.getAttribute("userName").toString();
		String custId = session.getAttribute("custId").toString();

		map.addAttribute("userName", userName);
		map.addAttribute("custId", custId);
		ModelAndView modelAndView = new ModelAndView();

		// return "createAcc";
		modelAndView.setViewName("Withdraw");
		return modelAndView;
	}


	@RequestMapping(value = "/WithdrawAmtFunc", method = RequestMethod.POST)
	public ModelAndView WithdrawAmt(ModelMap map,@RequestParam("customerId") int custId, @RequestParam("atype") String atype,
			@RequestParam("balance") double balance,
			@RequestParam("tType") String tType, HttpSession session) {

		ModelAndView modelAndView = new ModelAndView();
		Customer customer = new Customer();
		customer.setCustomerId(custId);

		System.out.println(custId);

		Account account = new Account();
		account.setCustomer(customer);

		account.setAccountType(AccountType.valueOf(atype));

		System.out.println(account.getAccountType());
		

		Optional<Account> optional = walletService.withdrawAmount(account, balance);		

		if (!optional.isEmpty()) {
			modelAndView.setViewName("Withdraw");
			return modelAndView;
		}

		String msg = " Insufficient Balance!  ";
		map.addAttribute("error!!", msg);

		modelAndView.setViewName("Withdraw");
		return modelAndView;
	}


	@RequestMapping("/WithdrawMoneypage")
	public ModelAndView WithdrawMoneyPage(ModelMap map,HttpSession session) {
		String userName=session.getAttribute("userName").toString();
		String custId=session.getAttribute("custId").toString();

		map.addAttribute("userName", userName);
		map.addAttribute("custId", custId);
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("Withdraw");
		return modelAndView;
	}

	
	@RequestMapping("/transferMoneyPage")
	public ModelAndView gettransferMoneyPage(ModelMap map, HttpSession session) {
		String userName = session.getAttribute("userName").toString();
		String custId = session.getAttribute("custId").toString();

		map.addAttribute("userName", userName);
		map.addAttribute("custId", custId);
		ModelAndView modelAndView = new ModelAndView();


		modelAndView.setViewName("Transfer");
		return modelAndView;
	}

	@RequestMapping("/TransferAmtFunc")
	public ModelAndView transferAmt(ModelMap map,@RequestParam("customerId") int custId, @RequestParam("atype") String atype,
			@RequestParam("amount") double amount, @RequestParam("rec_ac_no") int rec_ac_no, HttpSession session) {
		System.out.println("Called Transfer Amount method");
		ModelAndView modelAndView = new ModelAndView();
		Customer customer = new Customer();
		customer.setCustomerId(custId);
		Account account = new Account();
		account.setCustomer(customer);

		account.setAccountType(AccountType.valueOf(atype));
		System.out.println(account.getAccountType());
		
		Optional<Account> optional = walletService.transferAmount(account, amount, rec_ac_no);
		if (!optional.isEmpty()) {
			String msg = " Transferred Successfully!";
			map.addAttribute("error!!", msg);
			modelAndView.setViewName("Transfer");
			return modelAndView;
		}
		else {
			String msg = " Insufficient Balance ";
			map.addAttribute("error!", msg);
			modelAndView.setViewName("Transfer");
			return modelAndView;
		}
	}
	
	
	@RequestMapping("/TDPage")
	public String TDPage() {
		return "TransactionPDate";
	}
	
	
	
	@RequestMapping(value = "/transactionPD", method = RequestMethod.POST)
	public ModelAndView transactionPD(ModelMap map,HttpSession session,
			@RequestParam("customerId") int custId, @RequestParam("atype") String atype, 
			@RequestParam("start_date") String start_date,@RequestParam("end_date") String end_date){
		ModelAndView modelAndView = new ModelAndView();
		Account account = new Account();
		Customer customer = new Customer();
		customer.setCustomerId(custId);
		account.setCustomer(customer);
		account.setAccountType(AccountType.valueOf(atype));
		Optional<List<Transaction>>  optional = walletService.transactionParticularDate(account, start_date,end_date);
		System.out.println(optional.get());
		
		if (!optional.isEmpty()) {
			map.addAttribute("transactions", optional.get());
			modelAndView.setViewName("Tlist");
			return modelAndView;
		}
		else {
			modelAndView.setViewName("TransactionPDate");
			return modelAndView;
		}
	}
	


}
