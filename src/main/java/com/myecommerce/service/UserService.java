package com.myecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.myecommerce.converter.Converter;
import com.myecommerce.dto.ResponseBody;
import com.myecommerce.dto.UserDTO;
import com.myecommerce.entity.User;
import com.myecommerce.entity.UserData;
import com.myecommerce.enumerator.UserMessages;
import com.myecommerce.enumerator.Result;
import com.myecommerce.repository.UserDataRepository;
import com.myecommerce.repository.UserRepository;

@Service("userService")
public class UserService {

	@Autowired
	@Qualifier("userRepository")
	private UserRepository repository;

	@Autowired
	@Qualifier("userDataRepository")
	private UserDataRepository userDataRepository;
	
	@Autowired
	@Qualifier("converter")
	private Converter converter;

	public ResponseBody insert(UserDTO userDTO) {
		ResponseBody response = new ResponseBody("insertUser");
		User user = converter.getUserFromDTO(userDTO);
		try {
			if (repository.findByUsername(user.getUsername()) != null) {
				response.setMsg(UserMessages.INSERT_ERR_USERNAME);
				response.setResult(Result.ERROR);
			} else if (repository.findByEmail(user.getEmail()) != null) {
				response.setMsg(UserMessages.INSERT_ERR_EMAIL);
				response.setResult(Result.ERROR);
			} else {
				userDTO.setId(repository.save(user).getId());
				UserData userData = converter.getUserDataFromDTO(userDTO);
				userDataRepository.save(userData);
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

	public ResponseBody delete(long id) {
		ResponseBody response = new ResponseBody("deleteUser");
		try {
			User user = repository.findById(id);
			if (user != null) {
				repository.delete(user);
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
				response.setMsg(UserMessages.GET_OK);
				response.setResult(Result.OK);
				response.setData(new UserDTO(user, userData));
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

	public ResponseBody getByUsername(String userName) {
		ResponseBody response = new ResponseBody("getUserByUserName");
		try {
			User user = repository.findByUsername(userName);
			if (user != null) {
				UserData userData = userDataRepository.findByIdUser(user.getId());
				response.setMsg(UserMessages.GET_OK);
				response.setResult(Result.OK);
				response.setData(new UserDTO(user, userData));
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
				response.setMsg(UserMessages.GET_OK);
				response.setResult(Result.OK);
				response.setData(new UserDTO(user, userData));
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

	public ResponseBody check(String userName, String password) {
		ResponseBody response = new ResponseBody("check");
		try {
			User user = repository.findByUsernameAndPassword(userName, password);
			if (user != null) {
				UserData userData = userDataRepository.findByIdUser(user.getId());
				response.setMsg(UserMessages.CHECK_OK);
				response.setResult(Result.OK);
				response.setData(new UserDTO(user, userData));
			} else {
				response.setMsg(UserMessages.CHECK_ERR);
				response.setResult(Result.ERROR);
			}
		} catch (Exception e) {
			response.setMsg(UserMessages.GET_ERR);
			response.setResult(Result.ERROR);
		}
		return response;
	}
}
