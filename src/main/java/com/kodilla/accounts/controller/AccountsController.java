package com.kodilla.accounts.controller;

import com.kodilla.accounts.dto.AccountDto;
import com.kodilla.accounts.mapper.AccountMapper;
import com.kodilla.accounts.service.DbService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("/v1/accounts")
public class AccountsController {

    @Value("${application.allow-get-accounts}")
    private boolean allowGetAccounts;

    @Autowired
    DbService dbService;

    @Autowired
    AccountMapper accountMapper;

    @GetMapping
    public GetAccountsResponse getCustomerAccounts(@RequestParam("customerId") Long customerId) {
        log.info("Get account by customer id {}", customerId);
        if (!allowGetAccounts) {
            log.info("GETTING ACCOUNTS IS DISABLED");
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Getting accounts is disabled");
        }
        return accountMapper.mapToAccountResponse(dbService.getAccountsByCustomerId(customerId));
    }

    @GetMapping("/{nrb}")
    public AccountDto getAccountByNrb(@PathVariable String nrb) {
        log.info("Get account by customer nrb {}", nrb);
        if (!allowGetAccounts) {
            log.info("GETTING ACCOUNTS IS DISABLED");
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Getting accounts is disabled");
        }
        return accountMapper.mapToAccountDto(dbService.getAccountsByCustomerNrb(nrb));
    }
}
