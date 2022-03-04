package com.kodilla.accounts.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kodilla.accounts.model.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

	@Override
	List<Account> findAll();
	List<Account> findByCustomerId(Long id);
}
