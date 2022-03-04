package com.kodilla.accounts;

import java.math.BigDecimal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kodilla.accounts.dto.AccountDto;

//Configuration
//ComponentScan
//EnableAutoConfiguration
@SpringBootApplication
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
