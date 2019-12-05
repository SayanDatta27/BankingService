package com.cg.banking.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cg.banking.beans.Account;

@Controller
public class URIController {
	
	private Account account; 
	@RequestMapping(value= {"/","Index"})
	public String getIndexPage() {
		return "IndexPage";	
	}
	@RequestMapping("/registration")
	public String getRegistrationPage(){
		return "registrationPage";	
	}
	@RequestMapping("/findAccountDetails")
	public String getFindAccountPage() {
		return "findAccountDetailsPage";
	}
	@RequestMapping("/deposit")
	public String getDepositPage() {
		return "depositPage";
	}
	@RequestMapping("/withdraw")
	public String getWithdrawPage() {
		return "withdrawPage";
	}
	@RequestMapping("/transfer")
	public String getTransferPage() {
		return "transferPage";
	}
	
	@ModelAttribute
	public Account getAccount() {
		account=new Account();
		return account;	
	}
}
