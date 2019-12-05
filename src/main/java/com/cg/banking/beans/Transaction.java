package com.cg.banking.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
@Entity
public class Transaction {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int transactionId;
private float ammount;
@NotEmpty
private String TransactionType;
@ManyToOne
Account account;
public Transaction() {}

public Transaction(float ammount, String transactionType, Account account) {
	super();
	this.ammount = ammount;
	TransactionType = transactionType;
	this.account = account;
}

public Transaction(float ammount, String transactionType) {
	super();
	this.ammount = ammount;
	TransactionType = transactionType;
}

public Transaction(int transactionId, float ammount, String transactionType) {
	super();
	this.transactionId = transactionId;
	this.ammount = ammount;
	TransactionType = transactionType;
}
public int getTransactionId() {
	return transactionId;
}
public void setTransactionId(int transactionId) {
	this.transactionId = transactionId;
}
public float getAmmount() {
	return ammount;
}
public void setAmmount(float ammount) {
	this.ammount = ammount;
}
public String getTransactionType() {
	return TransactionType;
}
public void setTransactionType(String transactionType) {
	TransactionType = transactionType;
	
}
}
