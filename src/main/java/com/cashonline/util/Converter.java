package com.cashonline.util;

import org.springframework.stereotype.Component;

import com.cashonline.dto.LoanDTO;
import com.cashonline.dto.UserDTO;
import com.cashonline.dto.UserDataDTO;
import com.cashonline.entity.Loan;
import com.cashonline.entity.User;
import com.cashonline.entity.UserData;

@Component("converter")
public class Converter {

	public User getUserFromDTO(UserDTO userDTO) {
		User user = new User();
		user.setEmail(userDTO.getEmail());
		return user;
	}

	public UserData getUserDataFromDTO(UserDataDTO userDataDTO) {
		UserData userData = new UserData();
		userData.setIdUser(userDataDTO.getIdUser());
		userData.setName(userDataDTO.getName());
		userData.setLastname(userDataDTO.getLastname());
		return userData;
	}

	public Loan getLoanFromDTO(LoanDTO loanDTO) {
		Loan loan = new Loan();
		loan.setIdUser(loanDTO.getIdUser());
		loan.setTotal(loanDTO.getTotal());
		return loan;
	}
 }
