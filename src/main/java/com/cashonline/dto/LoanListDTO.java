package com.cashonline.dto;

import java.util.ArrayList;
import java.util.List;

import com.cashonline.entity.Loan;

public class LoanListDTO extends DTO {

	private List<LoanDTO> loans;

	public LoanListDTO () {

	}

	public LoanListDTO(List<Loan> loans) {
		this.loans = new ArrayList<>();
		loans.forEach((final Loan loan) -> this.loans.add(new LoanDTO(loan)));
	}

	public List<LoanDTO> getLoans() {
		return loans;
	}

	public void setLoans(List<LoanDTO> loans) {
		this.loans = loans;
	}

}
