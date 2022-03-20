package com.kodilla.accounts;

import com.kodilla.accounts.model.Account;
import com.kodilla.accounts.model.Customer;
import com.kodilla.accounts.repository.AccountRepository;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.WebApplicationContext;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.Collections;

import static org.mockito.Mockito.when;

@Ignore
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ContractVerifierBase {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private AccountRepository repository;

    @Autowired
    private DataSource dataSource;

    private Account testAccount;

    private Customer testCustomer;

//    @BeforeEach
//    public void setUp() {
//        RestAssuredMockMvc.webAppContextSetup(context);
//        when(repository.findAllByCustomerId(1L)).thenReturn(
//                Collections.singletonList(
//                        Account.builder()
//                                .id(95213L)
//                                .nrb("08897810189710581776778244")
//                                .currency("PLN")
//                                .customerId(1L)
//                                .build()
//                )
//        );
//    }

    @BeforeEach
    public void setUp() {
        RestAssuredMockMvc.webAppContextSetup(context);
        testCustomer = new Customer(1, "Joe", "Doe");
        testAccount =
                com.kodilla.accounts.model.Account.builder().id(95213L).customer(testCustomer).nrb("08897810189710581776778244").currency("PLN").availableFunds(new BigDecimal(122000)).build();
        repository.save(testAccount);


        when(repository.findAllByCustomerId(1L)).thenReturn(
                Collections.singletonList(
                        Account.builder()
                                .id(95213L)
                                .nrb("08897810189710581776778244")
                                .currency("PLN")
                                .customer(testCustomer)
                                .build()
                )

        );

    }

}