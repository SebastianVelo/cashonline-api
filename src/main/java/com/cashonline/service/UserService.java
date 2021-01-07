package com.cashonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

import com.cashonline.converter.Converter;
import com.cashonline.dto.ResponseBody;
import com.cashonline.dto.UserDTO;
import com.cashonline.entity.Loan;
import com.cashonline.entity.User;
import com.cashonline.entity.UserData;
import com.cashonline.enumerator.UserMessages;
import com.cashonline.enumerator.Result;
import com.cashonline.repository.LoanRepository;
import com.cashonline.repository.UserDataRepository;
import com.cashonline.repository.UserRepository;

@Service("userService")
public class UserService {

	@Autowired
	@Qualifier("userRepository")
	private UserRepository repository;

	@Autowired
	@Qualifier("userDataRepository")
	private UserDataRepository userDataRepository;

	@Autowired
	@Qualifier("loanRepository")
	private LoanRepository loanRepository;
	
	@Autowired
	@Qualifier("converter")
	private Converter converter;

	public ResponseBody insert(UserDTO userDTO) {
		ResponseBody response = new ResponseBody("insertUser");
		User user = converter.getUserFromDTO(userDTO);
		try {
			if (repository.findByEmail(user.getEmail()) != null) {
				response.setMsg(UserMessages.INSERT_ERR_EMAIL);
				response.setResult(Result.ERROR);
			} else {
				long idUser = repository.save(user).getId();
				userDTO.setId(idUser);
				userDTO.getInfo().setIdUser(idUser);
				UserData userData = converter.getUserDataFromDTO(userDTO.getInfo());
				long idUserData = userDataRepository.save(userData).getId();
				userDTO.getInfo().setId(idUserData);
				response.setMsg(UserMessages.INSERT_OK);
				response.setResult(Result.OK);
				response.setData(userDTO);
			}
		} catch (Exception e) {
			response.setMsg(UserMessages.INSERT_ERR);
			response.setResult(Result.ERROR);
		}
		return response;
	}
	
	@Transactional
	public ResponseBody delete(long id) {
		ResponseBody response = new ResponseBody("deleteUser");
		try {
			User user = repository.findById(id);
			if (user != null) {
				repository.delete(user);
				userDataRepository.deleteByIdUser(id);
				loanRepository.deleteByIdUser(id);
				response.setMsg(UserMessages.DELETE_OK);
				response.setResult(Result.OK);
			} else {
				response.setMsg(UserMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			}
		} catch (Exception e) {
			response.setMsg(UserMessages.DELETE_ERR);
			response.setResult(Result.ERROR);
		}
		return response;
	}

	public ResponseBody get(long id) {
		ResponseBody response = new ResponseBody("getUser");
		try {
			User user = repository.findById(id);
			if (user != null) {
				UserData userData = userDataRepository.findByIdUser(user.getId());
				List<Loan> loans = loanRepository.findByIdUser(user.getId());
				response.setMsg(UserMessages.GET_OK);
				response.setResult(Result.OK);
				response.setData(new UserDTO(user, userData, loans));
			} else {
				response.setMsg(UserMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			}
		} catch (Exception e) {
			response.setMsg(UserMessages.GET_ERR);
			response.setResult(Result.ERROR);
		}
		return response;
	}

	public ResponseBody getByEmail(String email) {
		ResponseBody response = new ResponseBody("getUserByEmail");
		try {
			User user = repository.findByEmail(email);
			if (user != null) {
				UserData userData = userDataRepository.findByIdUser(user.getId());
				List<Loan> loans = loanRepository.findByIdUser(user.getId());
				response.setMsg(UserMessages.GET_OK);
				response.setResult(Result.OK);
				response.setData(new UserDTO(user, userData, loans));
			} else {
				response.setMsg(UserMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			}
		} catch (Exception e) {
			response.setMsg(UserMessages.GET_ERR);
			response.setResult(Result.ERROR);
		}
		return response;
	}

}
