package com.kodilla.accounts.mapper;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.kodilla.accounts.controller.GetAccountsResponse;
import com.kodilla.accounts.dto.AccountDto;
import com.kodilla.accounts.model.Account;

@Component
public class AccountMapper {

	public AccountDto mapToAccountDto(Account account) {
		return new AccountDto(account.getId(), account.getNrb(), account.getCurrency(), account.getAvailableFunds());
	}

	public GetAccountsResponse mapToAccountResponse(List<Account> accounts) {
		if (accounts.isEmpty()) {
			return GetAccountsResponse.of(Collections.emptyList());
		} else {
			return GetAccountsResponse.of(accounts.stream().map(this::mapToAccountDto).collect(Collectors.toList()));
		}
	}
}
