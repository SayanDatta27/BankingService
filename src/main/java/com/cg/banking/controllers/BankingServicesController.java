package com.cg.banking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.banking.beans.Account;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.services.BankingServices;

@Controller
public class BankingServicesController {
	
	@Autowired
	BankingServices services;
	@RequestMapping("/registerAccount")
	public ModelAndView registerAccount(@ModelAttribute Account account) {
		account = services.openAccount(account);
		return new ModelAndView("registrationSuccessPage","account",account);
	}
	@RequestMapping("/accountDetails")
	public ModelAndView getAccountDetails(@RequestParam long accountNo) throws AccountNotFoundException {
	Account account=services.getAccountDetails(accountNo);
	return new ModelAndView("findAccountDetailsPage","account",account);		
	}
	@RequestMapping("/depositBalance")
	public ModelAndView getdepositBalance(@RequestParam long accountNo, @RequestParam float amount) {
		float accBalance = services.depositAmount(accountNo, amount);
		return new ModelAndView("depositPage","accBalance",accBalance);
		
	}
	@RequestMapping("/withdrawBalance")
	public ModelAndView getwithdrawBalance(@RequestParam long accountNo, @RequestParam float amount, @RequestParam int pinNumber) {
		float accBal=services.withdrawAmount(accountNo, amount, pinNumber);
		return new ModelAndView("withdrawPage","accBal",accBal);
	}
	@RequestMapping("/transferBalance")
	public ModelAndView getTransferBalance( @RequestParam long accountNoTo,@RequestParam long accountNoFrom,@RequestParam float amount, @RequestParam int pinNumber) {
		boolean accBal=services.fundTransfer(accountNoTo, accountNoFrom, amount, pinNumber);
		return new ModelAndView("transferPage","accBal",accBal);
	}
}
