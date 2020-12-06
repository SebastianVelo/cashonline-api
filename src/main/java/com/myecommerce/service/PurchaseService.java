package com.myecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.myecommerce.converter.Converter;
import com.myecommerce.dto.ResponseBody;
import com.myecommerce.entity.Cart;
import com.myecommerce.entity.Purchase;
import com.myecommerce.enumerator.CartMessages;
import com.myecommerce.enumerator.PurchaseMessages;
import com.myecommerce.enumerator.Result;
import com.myecommerce.model.MPurchase;
import com.myecommerce.repository.CartRepository;
import com.myecommerce.repository.PurchaseRepository;

@Service("purchaseService")
public class PurchaseService {

	@Autowired
	@Qualifier("purchaseRepository")
	private PurchaseRepository repository;

	@Autowired
	@Qualifier("cartRepository")
	private CartRepository cartRepository;
	
	@Autowired
	@Qualifier("converter")
	private Converter converter;
	
	public ResponseBody insert(Purchase purchase) {
		ResponseBody response = new ResponseBody("insertPurchase");
		try {
			Cart cart = cartRepository.findById(purchase.getIdCart());
			if(cart != null) {
				repository.save(purchase);
				response.setMsg(PurchaseMessages.INSERT_OK);
				response.setResult(Result.OK);
				response.setData(purchase);
			}else {
				response.setMsg(CartMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			}
		} catch (Exception e) {
			response.setMsg(PurchaseMessages.INSERT_ERR);
			response.setResult(Result.ERROR);
		}
		return response;
	}

	public ResponseBody delete(long id) {
		ResponseBody response = new ResponseBody("deletePurchase");
		try {
			Purchase purchase = repository.findById(id);
			if (purchase != null) {
				repository.delete(purchase);
				response.setMsg(PurchaseMessages.DELETE_OK);
				response.setResult(Result.OK);
			} else {
				response.setMsg(PurchaseMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			}
		} catch (Exception e) {
			response.setMsg(PurchaseMessages.DELETE_ERR);
			response.setResult(Result.ERROR);
		}
		return response;
	}

	public ResponseBody get(long id) {
		ResponseBody response = new ResponseBody("getPurchase");
		try {
			Purchase purchase = repository.findById(id);
			if (purchase != null) {
				response.setMsg(PurchaseMessages.GET_OK);
				response.setResult(Result.OK);
				response.setData(new MPurchase(purchase));
			} else {
				response.setMsg(PurchaseMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			}
		} catch (Exception e) {
			response.setMsg(PurchaseMessages.GET_ERR);
			response.setResult(Result.ERROR);
		}
		return response;
	}

	public ResponseBody getByCart(long idCart) {
		ResponseBody response = new ResponseBody("getPurchaseByIdCart");
		List<Purchase> purchases = repository.findByIdCart(idCart);
		if(purchases.size() > 0) {
			response.setMsg(PurchaseMessages.GET_MANY_OK);
			response.setResult(Result.OK);
		} else {
			response.setMsg(PurchaseMessages.GET_MANY_ERR);
			response.setResult(Result.ERROR);
		}
		response.setData(converter.getMPurchases(purchases));
		return response;
	}
	
	public ResponseBody getByProduct(long idProduct) {
		ResponseBody response = new ResponseBody("getPurchaseByIdProduct");
		List<Purchase> purchases = repository.findByIdProduct(idProduct);
		if(purchases.size() > 0) {
			response.setMsg(PurchaseMessages.GET_MANY_OK);
			response.setResult(Result.OK);
		} else {
			response.setMsg(PurchaseMessages.GET_MANY_ERR);
			response.setResult(Result.ERROR);
		}
		response.setData(converter.getMPurchases(purchases));
		return response;
	}
}
