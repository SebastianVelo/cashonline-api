package com.cashonline.dto;

import com.cashonline.entity.Loan;

public class LoanDTO extends DTO {

	private long idUser;
	private double total;

	public LoanDTO () {

	}

	public LoanDTO(Loan loan) {
		this.id = loan.getId();
		this.idUser = loan.getIdUser();
		this.total = loan.getTotal();
	}

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
