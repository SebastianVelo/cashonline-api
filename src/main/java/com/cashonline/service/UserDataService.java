package com.cashonline.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cashonline.converter.Converter;
import com.cashonline.dto.ResponseBody;
import com.cashonline.dto.UserDataDTO;
import com.cashonline.entity.User;
import com.cashonline.entity.UserData;
import com.cashonline.enumerator.Result;
import com.cashonline.enumerator.UserDataMessages;
import com.cashonline.enumerator.UserMessages;
import com.cashonline.repository.UserDataRepository;
import com.cashonline.repository.UserRepository;

@Service("userDataService")
public class UserDataService {

	@Autowired
	@Qualifier("userDataRepository")
	private UserDataRepository repository;

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@Autowired
	@Qualifier("converter")
	private Converter converter;
	
	private Logger logger = LoggerFactory.getLogger(UserDataService.class);
	
	public ResponseBody insert(UserDataDTO userDataDTO) {
		ResponseBody response = new ResponseBody("insertUserData");
		UserData userData = converter.getUserDataFromDTO(userDataDTO);
		try {
			User user = userRepository.findById(userData.getIdUser());
			if(user == null) {
				response.setMsg(UserMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			} else {
				repository.save(userData);
				response.setMsg(UserDataMessages.INSERT_OK);
				response.setResult(Result.OK);
				response.setData(userDataDTO);
			}
			logger.info(response.getMsg());
		} catch (Exception e) {
			response.setMsg(UserDataMessages.INSERT_ERR);
			response.setResult(Result.ERROR);
			logger.error(e.getMessage(), e);
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
			logger.info(response.getMsg());
		} catch (Exception e) {
			response.setMsg(UserDataMessages.DELETE_ERR);
			response.setResult(Result.ERROR);
			logger.error(e.getMessage(), e);
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
				response.setData(new UserDataDTO(userData));
			} else {
				response.setMsg(UserDataMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			}
			logger.info(response.getMsg());
		} catch (Exception e) {
			response.setMsg(UserDataMessages.GET_ERR);
			response.setResult(Result.ERROR);
			logger.error(e.getMessage(), e);
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
				response.setData(new UserDataDTO(userData));
			} else {
				response.setMsg(UserDataMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			}
			logger.info(response.getMsg());
		} catch (Exception e) {
			response.setMsg(UserDataMessages.GET_ERR);
			response.setResult(Result.ERROR);
			logger.error(e.getMessage(), e);
		}
		return response;
	}
}
