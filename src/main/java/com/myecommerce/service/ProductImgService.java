package com.myecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.myecommerce.converter.Converter;
import com.myecommerce.dto.ResponseBody;
import com.myecommerce.entity.Product;
import com.myecommerce.entity.ProductImg;
import com.myecommerce.enumerator.ProductImgMessages;
import com.myecommerce.enumerator.ProductMessages;
import com.myecommerce.enumerator.Result;
import com.myecommerce.repository.ProductImgRepository;
import com.myecommerce.repository.ProductRepository;

@Service("productImgService")
public class ProductImgService {

	@Autowired
	@Qualifier("productImgRepository")
	private ProductImgRepository repository;

	@Autowired
	@Qualifier("productRepository")
	private ProductRepository productRepository;
	
	@Autowired
	@Qualifier("converter")
	private Converter converter;

	public ResponseBody insert(ProductImg productImg) {
		ResponseBody response = new ResponseBody("insertProduct");
		try {
			Product product = productRepository.findById(productImg.getId());
			if(product != null) {
				repository.save(productImg);
				response.setMsg(ProductImgMessages.INSERT_OK);
				response.setResult(Result.OK);
				response.setData(productImg);
			} else {
				response.setMsg(ProductMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			}
		} catch (Exception e) {
			response.setMsg(ProductMessages.INSERT_ERR);
			response.setResult(Result.ERROR);
		}
		return response;
	}

	public ResponseBody delete(long id) {
		ResponseBody response = new ResponseBody("deleteProduct");
		try {
			ProductImg productImg = repository.findById(id);
			if (productImg != null) {
				repository.delete(productImg);
				response.setMsg(ProductImgMessages.DELETE_OK);
				response.setResult(Result.OK);
			} else {
				response.setMsg(ProductImgMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			}
		} catch (Exception e) {
			response.setMsg(ProductImgMessages.DELETE_ERR);
			response.setResult(Result.ERROR);
		}
		return response;
	}

	public ResponseBody get(long id) {
		ResponseBody response = new ResponseBody("getProduct");
		try {
			ProductImg productImg = repository.findById(id);
			if (productImg != null) {
				response.setMsg(ProductMessages.GET_OK);
				response.setResult(Result.OK);
				response.setData(productImg);
			} else {
				response.setMsg(ProductMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			}
		} catch (Exception e) {
			response.setMsg(ProductMessages.GET_ERR);
			response.setResult(Result.ERROR);
		}
		return response;
	}

}
