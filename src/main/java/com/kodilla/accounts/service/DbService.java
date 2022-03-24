package com.kodilla.accounts.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodilla.accounts.model.Account;
import com.kodilla.accounts.repository.AccountRepository;

@Service
public class DbService {

	@Autowired
	private AccountRepository accountRepository;

	public List<Account> getAccountsByCustomerId(long customerId){
		return accountRepository.findByCustomerId(customerId);
	}

	public Account getAccountsByCustomerNrb(String nrb){
		return accountRepository.findByNrb(nrb);
	}
}

