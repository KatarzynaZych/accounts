package com.kodilla.accounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kodilla.accounts.mapper.AccountMapper;
import com.kodilla.accounts.service.DbService;

@RestController
@RequestMapping("/v1/")
public class AccountsController {

	@Autowired
	DbService dbService;

	@Autowired
	AccountMapper accountMapper;

	@RequestMapping(value = "/accounts", method = RequestMethod.GET)
	@ResponseBody
	public GetAccountsResponse getCustomerAccounts(@RequestParam Long customerId) {
		return accountMapper.mapToAccountResponse(dbService.getAccountsByCustomerId(customerId));
	}
}
