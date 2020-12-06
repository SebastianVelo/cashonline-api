package com.myecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.myecommerce.dto.ResponseBody;
import com.myecommerce.entity.User;
import com.myecommerce.entity.UserData;
import com.myecommerce.enumerator.Result;
import com.myecommerce.enumerator.UserDataMessages;
import com.myecommerce.enumerator.UserMessages;
import com.myecommerce.model.MUserData;
import com.myecommerce.repository.UserDataRepository;
import com.myecommerce.repository.UserRepository;

@Service("userDataService")
public class UserDataService {

	@Autowired
	@Qualifier("userDataRepository")
	private UserDataRepository repository;

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	public ResponseBody insert(UserData userData) {
		ResponseBody response = new ResponseBody("insertUserData");
		try {
			User user = userRepository.findById(userData.getIdUser());
			if(user == null) {
				response.setMsg(UserMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			} else if (repository.findByIdUser(userData.getIdUser()) != null) {
				response.setMsg(UserMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			} else {
				repository.save(userData);
				response.setMsg(UserDataMessages.INSERT_OK);
				response.setResult(Result.OK);
				response.setData(userData);
			}
		} catch (Exception e) {
			response.setMsg(UserDataMessages.INSERT_ERR);
			response.setResult(Result.ERROR);
		}
		return response;
	}

	public ResponseBody delete(long id) {
		ResponseBody response = new ResponseBody("deleteUserData");
		try {
			UserData userData = repository.findById(id);
			if (userData != null) {
				repository.delete(userData);
				response.setMsg(UserDataMessages.DELETE_OK);
				response.setResult(Result.OK);
			} else {
				response.setMsg(UserDataMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			}
		} catch (Exception e) {
			response.setMsg(UserDataMessages.DELETE_ERR);
			response.setResult(Result.ERROR);
		}
		return response;
	}

	public ResponseBody get(long id) {
		ResponseBody response = new ResponseBody("getUserData");
		try {
			UserData userData = repository.findById(id);
			if (userData != null) {
				response.setMsg(UserDataMessages.GET_OK);
				response.setResult(Result.OK);
				response.setData(new MUserData(userData));
			} else {
				response.setMsg(UserDataMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			}
		} catch (Exception e) {
			response.setMsg(UserDataMessages.GET_ERR);
			response.setResult(Result.ERROR);
		}
		return response;
	}

	public ResponseBody getByUser(long idUser) {
		ResponseBody response = new ResponseBody("getUserDataByIdUser");
		try {
			UserData userData = repository.findByIdUser(idUser);
			if (userData != null) {
				response.setMsg(UserDataMessages.GET_OK);
				response.setResult(Result.OK);
				response.setData(new MUserData(userData));
			} else {
				response.setMsg(UserDataMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			}
		} catch (Exception e) {
			response.setMsg(UserDataMessages.GET_ERR);
			response.setResult(Result.ERROR);
		}
		return response;
	}
}
