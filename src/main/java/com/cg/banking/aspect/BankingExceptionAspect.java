package com.cg.banking.aspect;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.cg.banking.exceptions.AccountNotFoundException;



@ControllerAdvice
public class BankingExceptionAspect {
	@ExceptionHandler(AccountNotFoundException.class)
	public ModelAndView handelAccountNotFoundException(Exception e) {
		return new ModelAndView("findAccountDetailsPage","errorMessege",e.getMessage());
	}
}
