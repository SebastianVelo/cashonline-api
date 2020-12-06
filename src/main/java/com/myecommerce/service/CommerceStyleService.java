package com.myecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.myecommerce.dto.ResponseBody;
import com.myecommerce.entity.Commerce;
import com.myecommerce.entity.CommerceStyle;
import com.myecommerce.enumerator.CommerceMessages;
import com.myecommerce.enumerator.CommerceStyleMessages;
import com.myecommerce.enumerator.Result;
import com.myecommerce.model.MCommerceStyle;
import com.myecommerce.repository.CommerceRepository;
import com.myecommerce.repository.CommerceStyleRepository;

@Service("commerceStyleService")
public class CommerceStyleService {

	@Autowired
	@Qualifier("commerceStyleRepository")
	private CommerceStyleRepository repository;

	@Autowired
	@Qualifier("commerceRepository")
	private CommerceRepository commerceRepository;
	
	public ResponseBody insert(CommerceStyle commerceStyle) {
		ResponseBody response = new ResponseBody("insertCommerceStyle");
		try {
			Commerce commerce = commerceRepository.findById(commerceStyle.getIdCommerce());
			if(commerce != null) {
				repository.save(commerceStyle);
				response.setMsg(CommerceStyleMessages.INSERT_OK);
				response.setResult(Result.OK);
				response.setData(commerceStyle);
			}else {
				response.setMsg(CommerceMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			}
		} catch (Exception e) {
			response.setMsg(CommerceStyleMessages.INSERT_ERR);
			response.setResult(Result.ERROR);
		}
		return response;
	}

	public ResponseBody delete(long id) {
		ResponseBody response = new ResponseBody("deleteCommerceStyle");
		try {
			CommerceStyle commerceStyle = repository.findById(id);
			if (commerceStyle != null) {
				repository.delete(commerceStyle);
				response.setMsg(CommerceStyleMessages.DELETE_OK);
				response.setResult(Result.OK);
			} else {
				response.setMsg(CommerceStyleMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			}
		} catch (Exception e) {
			response.setMsg(CommerceStyleMessages.DELETE_ERR);
			response.setResult(Result.ERROR);
		}
		return response;
	}

	public ResponseBody get(long id) {
		ResponseBody response = new ResponseBody("getCommerceStyle");
		try {
			CommerceStyle commerceStyle = repository.findById(id);
			if (commerceStyle != null) {
				response.setMsg(CommerceStyleMessages.GET_OK);
				response.setResult(Result.OK);
				response.setData(new MCommerceStyle(commerceStyle));
			} else {
				response.setMsg(CommerceStyleMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			}
		} catch (Exception e) {
			response.setMsg(CommerceStyleMessages.GET_ERR);
			response.setResult(Result.ERROR);
		}
		return response;
	}

	public ResponseBody getByCommerce(long idCommerce) {
		ResponseBody response = new ResponseBody("getCommerceStyleByIdCommerce");
		try {
			CommerceStyle commerceStyle = repository.findByIdCommerce(idCommerce);
			if (commerceStyle != null) {
				response.setMsg(CommerceStyleMessages.GET_OK);
				response.setResult(Result.OK);
				response.setData(new MCommerceStyle(commerceStyle));
			} else {
				response.setMsg(CommerceStyleMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			}
		} catch (Exception e) {
			response.setMsg(CommerceStyleMessages.GET_ERR);
			response.setResult(Result.ERROR);
		}
		return response;
	}
}
