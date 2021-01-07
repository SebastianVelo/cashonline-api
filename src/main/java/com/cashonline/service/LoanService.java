package com.cashonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import com.cashonline.converter.Converter;
import com.cashonline.dto.ResponseBody;
import com.cashonline.dto.LoanDTO;
import com.cashonline.dto.LoanListDTO;
import com.cashonline.entity.User;
import com.cashonline.entity.Loan;
import com.cashonline.enumerator.Result;
import com.cashonline.enumerator.LoanMessages;
import com.cashonline.enumerator.UserMessages;
import com.cashonline.repository.LoanRepository;
import com.cashonline.repository.UserRepository;

@Service("loanService")
public class LoanService {

	@Autowired
	@Qualifier("loanRepository")
	private LoanRepository repository;

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@Autowired
	@Qualifier("converter")
	private Converter converter;
	
	public ResponseBody insert(LoanDTO loanDTO) {
		ResponseBody response = new ResponseBody("insertLoan");
		Loan loan = converter.getLoanFromDTO(loanDTO);
		try {
			User user = userRepository.findById(loan.getIdUser());
			if(user == null) {
				response.setMsg(UserMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			} else {
				repository.save(loan);
				response.setMsg(LoanMessages.INSERT_OK);
				response.setResult(Result.OK);
				response.setData(loanDTO);
			}
		} catch (Exception e) {
			response.setMsg(LoanMessages.INSERT_ERR);
			response.setResult(Result.ERROR);
		}
		return response;
	}

	public ResponseBody delete(long id) {
		ResponseBody response = new ResponseBody("deleteLoan");
		try {
			Loan loan = repository.findById(id);
			if (loan != null) {
				repository.delete(loan);
				response.setMsg(LoanMessages.DELETE_OK);
				response.setResult(Result.OK);
			} else {
				response.setMsg(LoanMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			}
		} catch (Exception e) {
			response.setMsg(LoanMessages.DELETE_ERR);
			response.setResult(Result.ERROR);
		}
		return response;
	}

	public ResponseBody get(long id) {
		ResponseBody response = new ResponseBody("getLoan");
		try {
			Loan loan = repository.findById(id);
			if (loan != null) {
				response.setMsg(LoanMessages.GET_OK);
				response.setResult(Result.OK);
				response.setData(new LoanDTO(loan));
			} else {
				response.setMsg(LoanMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			}
		} catch (Exception e) {
			response.setMsg(LoanMessages.GET_ERR);
			response.setResult(Result.ERROR);
		}
		return response;
	}

	public ResponseBody getByUser(long idUser) {
		ResponseBody response = new ResponseBody("getLoanByIdUser");
		try {
			List<Loan> loans = repository.findByIdUser(idUser);
			if (!loans.isEmpty()) {
				response.setMsg(LoanMessages.GET_OK);
				response.setResult(Result.OK);
				response.setData(new LoanListDTO(loans));
			} else {
				response.setMsg(LoanMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			}
		} catch (Exception e) {
			response.setMsg(LoanMessages.GET_ERR);
			response.setResult(Result.ERROR);
		}
		return response;
	}

	public ResponseBody getAll(int page, int size) {
		ResponseBody response = new ResponseBody("getAllLoans");
		try {
			Pageable pageable = PageRequest.of(page, size);
			List<Loan> loans = repository.findAll(pageable).toList();
			if (!loans.isEmpty()) {
				response.setMsg(LoanMessages.GET_OK);
				response.setResult(Result.OK);
				response.setData(new LoanListDTO(loans));
			} else {
				response.setMsg(LoanMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			}
		} catch (Exception e) {
			response.setMsg(LoanMessages.GET_ERR);
			response.setResult(Result.ERROR);
		}
		return response;
	}
}
