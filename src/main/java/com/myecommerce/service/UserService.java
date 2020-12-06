package com.myecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.myecommerce.dto.ResponseBody;
import com.myecommerce.entity.User;
import com.myecommerce.enumerator.UserMessages;
import com.myecommerce.enumerator.Result;
import com.myecommerce.model.MUser;
import com.myecommerce.repository.UserRepository;

@Service("userService")
public class UserService {

	@Autowired
	@Qualifier("userRepository")
	private UserRepository repository;

	public ResponseBody insert(User user) {
		ResponseBody response = new ResponseBody("insertUser");
		try {
			if (repository.findByUsername(user.getUsername()) != null) {
				response.setMsg(UserMessages.INSERT_ERR_USERNAME);
				response.setResult(Result.ERROR);
			} else if (repository.findByEmail(user.getEmail()) != null) {
				response.setMsg(UserMessages.INSERT_ERR_EMAIL);
				response.setResult(Result.ERROR);
			} else {
				repository.save(user);
				response.setMsg(UserMessages.INSERT_OK);
				response.setResult(Result.OK);
				response.setData(user);
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
				response.setMsg(UserMessages.GET_OK);
				response.setResult(Result.OK);
				response.setData(new MUser(user));
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
				response.setMsg(UserMessages.GET_OK);
				response.setResult(Result.OK);
				response.setData(new MUser(user));
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
				response.setMsg(UserMessages.GET_OK);
				response.setResult(Result.OK);
				response.setData(new MUser(user));
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
				response.setMsg(UserMessages.CHECK_OK);
				response.setResult(Result.OK);
				response.setData(new MUser(user));
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
