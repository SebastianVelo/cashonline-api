package com.cashonline.dto;

import java.util.List;

import com.cashonline.entity.Loan;
import com.cashonline.entity.User;
import com.cashonline.entity.UserData;

public class UserDTO extends DTO {

	private String email;	
	private UserDataDTO info;
	private LoanListDTO loans;

	public UserDTO () {

	}

	public UserDTO(User user, UserData userData, List<Loan> loans) {
		this.id = user.getId();
		this.email = user.getEmail();
		this.info = new UserDataDTO(userData);
		this.loans = new LoanListDTO(loans);
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public UserDataDTO getInfo() {
		return info;
	}

	public void setInfo(UserDataDTO userData) {
		this.info = userData;
	}

	public List<LoanDTO> getLoans() {
		return loans.getLoans();
	}

	public void setLoans(LoanListDTO loans) {
		this.loans = loans;
	}

}
