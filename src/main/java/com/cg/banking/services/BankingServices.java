package com.cg.banking.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficientBalanceException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;
public interface BankingServices {

	Account openAccount(Account account)
	throws InvalidAmountException,InvalidAccountTypeException,BankingServicesDownException;
	
	float depositAmount(long accountNo,float amount)
	throws AccountNotFoundException,BankingServicesDownException,AccountBlockedException;
	
	float withdrawAmount(long accountNo,float amount,int pinNumber)
	throws InsufficientBalanceException,AccountNotFoundException,InvalidPinNumberException,BankingServicesDownException,AccountBlockedException;
	
	boolean fundTransfer(long accountNoTo,long accountNoFrom,float transferAmount,int pinNumber)
	throws InsufficientBalanceException,AccountNotFoundException,InvalidPinNumberException,BankingServicesDownException,AccountBlockedException;
	
	Account getAccountDetails(long accountNo)
	throws AccountNotFoundException,BankingServicesDownException;
	List<Account>getAllAccountdetails()throws BankingServicesDownException;
	List<Transaction>getAccountAllTransaction(long accountNo) throws BankingServicesDownException,AccountNotFoundException;
	public Optional<Account> accountStatus(long accountNo) throws BankingServicesDownException,AccountNotFoundException,AccountBlockedException;

}
