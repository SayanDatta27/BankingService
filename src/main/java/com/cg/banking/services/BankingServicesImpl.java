package com.cg.banking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.daoservices.AccountDAO;
import com.cg.banking.daoservices.TransactaionDAO;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficientBalanceException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;
@Component("bankingServices")
public class BankingServicesImpl implements BankingServices {
	@Autowired
	private AccountDAO custData1 ;
	@Autowired
	private TransactaionDAO tranData1;
	private int maxInvalidPinAttempts=3;
	public final static float minBalance = 1000;

	@Override
	public Account openAccount(Account account)
			throws InvalidAmountException, InvalidAccountTypeException, BankingServicesDownException {
		float initBalance = account.getAccountBalance();
		if (initBalance <= minBalance)
			throw new InvalidAccountTypeException("Your Amount must be more than 1000");
		int pinNumber = ((int)(Math.random()*9999+1000));
		account.setPinNumber(pinNumber);
		account.setAccountBalance(initBalance);
		account.setAccountType(account.getAccountType());
		account.setAccountStatus("Active");
		account = custData1.save(account);
		tranData1.save(new Transaction(account.getAccountBalance(), "credited", account));
		return account;
	}
	
	@Override
	public float depositAmount(long accountNo, float amount)
			throws AccountNotFoundException, BankingServicesDownException, AccountBlockedException {
		Account customers= getAccountDetails(accountNo);
		if (customers.getAccountStatus().equalsIgnoreCase("Blocked"))
			throw new AccountBlockedException("Your Account is Blocked");
		else if(customers.getAccountNo()!=accountNo)
			throw new AccountNotFoundException("Plaese Insert Correct Account No");
		else
			customers.setAccountBalance(customers.getAccountBalance() + amount);
		tranData1.save(new Transaction(amount, "Deposit",customers) );
		
		return customers.getAccountBalance();
	}
	@Override
	public float withdrawAmount(long accountNo, float amount, int pinNumber) throws InsufficientBalanceException,
			AccountNotFoundException, InvalidPinNumberException, BankingServicesDownException, AccountBlockedException {
		Account customers = null;
		customers = getAccountDetails(accountNo);
		if (customers.getAccountStatus().equalsIgnoreCase("Blocked"))
			throw new AccountBlockedException("Your Account is Blocked");
		else if(customers.getPinNumber()!=pinNumber) {
			customers.incrPinAttempts();
			System.out.println("Invalid Pin,Try again");
			if(customers.getPinAttempts()==maxInvalidPinAttempts) {
				customers.setAccountStatus("Blocked");
				throw new AccountBlockedException();
			}
			throw new InvalidPinNumberException();
			}
		else if(customers.getPinAttempts()>0 && !(customers.getAccountStatus().equalsIgnoreCase("Blocked")))
			customers.resetPin();
		
		else if(customers.getAccountNo()!=accountNo)
			throw new AccountNotFoundException("Plaese Insert Correct Account No");
		else if (customers.getAccountBalance() - amount <= minBalance)
			throw new InsufficientBalanceException("Your Balance is Low");
		else if (customers.getPinNumber() != pinNumber) 
			throw new InvalidPinNumberException("Incorrect Pin");
		else
			customers.setAccountBalance(customers.getAccountBalance() - amount);
		tranData1.save(new Transaction(amount, "Withdraw",customers) );
		return customers.getAccountBalance();
	}
	@Override
	public boolean fundTransfer(long accountNoFrom, long accountNoTo, float amount, int pinNumber)
			throws InsufficientBalanceException, AccountNotFoundException, InvalidPinNumberException,
			BankingServicesDownException, AccountBlockedException {
		Account customerTo = null;
		Account customerFrom = null;
		customerTo = getAccountDetails(accountNoTo);
		customerFrom = getAccountDetails(accountNoFrom);
		if (customerFrom.getAccountBalance() - amount <= minBalance)
			throw new InsufficientBalanceException("Your Balance is Low");
		else if (customerFrom.getPinNumber() != pinNumber)
			throw new InvalidPinNumberException("Incorrect Pin");

		customerFrom.setAccountBalance(
				withdrawAmount(customerFrom.getAccountNo(), amount, customerFrom.getPinNumber()));
		customerTo.setAccountBalance(depositAmount(customerTo.getAccountNo(), amount));
	return true;
	}
	
	@Override
	public Account getAccountDetails(long accountNo) throws AccountNotFoundException, BankingServicesDownException {
		return custData1.findById(accountNo).orElseThrow(()->new AccountNotFoundException("Account Details Not Found"));
	}
	@Override
	public List<Account> getAllAccountdetails() throws BankingServicesDownException {
		List<Account> customers = custData1.findAll();
		return customers;
	}
	@Override
	public List<Transaction> getAccountAllTransaction(long accountNo)
			throws BankingServicesDownException, AccountNotFoundException {
		return null;
	}
	@Override
	public Optional<Account> accountStatus(long accountNo)
			throws BankingServicesDownException, AccountNotFoundException, AccountBlockedException {
		Optional<Account> customer=custData1.findById(accountNo);
		if(customer==null)throw new AccountNotFoundException("Account Not Found");
		else if(customer.equals("blocked"))throw new AccountBlockedException("Account Blocked");
		return customer;
	}
	
	
}
