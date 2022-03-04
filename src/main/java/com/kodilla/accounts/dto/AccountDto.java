package com.kodilla.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {
	private long id;
	private String nrb;
	private String currency;
	private BigDecimal availableFunds;
}