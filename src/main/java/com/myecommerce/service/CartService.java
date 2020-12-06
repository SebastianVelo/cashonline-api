package com.myecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.myecommerce.converter.Converter;
import com.myecommerce.dto.ResponseBody;
import com.myecommerce.entity.Cart;
import com.myecommerce.entity.Commerce;
import com.myecommerce.entity.Purchase;
import com.myecommerce.entity.User;
import com.myecommerce.enumerator.CartMessages;
import com.myecommerce.enumerator.CommerceMessages;
import com.myecommerce.enumerator.Result;
import com.myecommerce.enumerator.UserMessages;
import com.myecommerce.model.MCart;
import com.myecommerce.repository.CartRepository;
import com.myecommerce.repository.CommerceRepository;
import com.myecommerce.repository.PurchaseRepository;
import com.myecommerce.repository.UserRepository;

@Service("cartService")
public class CartService {

	@Autowired
	@Qualifier("cartRepository")
	private CartRepository repository;

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@Autowired
	@Qualifier("commerceRepository")
	private CommerceRepository commerceRepository;
	
	@Autowired
	@Qualifier("purchaseRepository")
	private PurchaseRepository purchaseRepository;
	
	@Autowired
	@Qualifier("converter")
	private Converter converter;
	
	public ResponseBody insert(Cart cart) {
		ResponseBody response = new ResponseBody("insertCart");
		try {
			User user = userRepository.findById(cart.getIdUser());
			Commerce commerce = commerceRepository.findById(cart.getIdCommerce());
			if(user == null) {
				response.setMsg(UserMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			} else if(commerce == null) {
				response.setMsg(CommerceMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			} else {
				repository.save(cart);
				response.setMsg(CartMessages.INSERT_OK);
				response.setResult(Result.OK);
				response.setData(cart);
			}
		} catch (Exception e) {
			response.setMsg(CartMessages.INSERT_ERR);
			response.setResult(Result.ERROR);
		}
		return response;
	}

	public ResponseBody delete(long id) {
		ResponseBody response = new ResponseBody("deleteCart");
		try {
			Cart cart = repository.findById(id);
			if (cart != null) {
				repository.delete(cart);
				List<Purchase> purchases = purchaseRepository.findByIdCart(id);
				purchaseRepository.deleteAll(purchases);
				response.setMsg(CartMessages.DELETE_OK);
				response.setResult(Result.OK);
			} else {
				response.setMsg(CartMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			}
		} catch (Exception e) {
			response.setMsg(CartMessages.DELETE_ERR);
			response.setResult(Result.ERROR);
		}
		return response;
	}

	public ResponseBody get(long id) {
		ResponseBody response = new ResponseBody("getCart");
		try {
			Cart cart = repository.findById(id);
			if (cart != null) {
				response.setMsg(CartMessages.GET_OK);
				response.setResult(Result.OK);
				response.setData(new MCart(cart));
			} else {
				response.setMsg(CartMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			}
		} catch (Exception e) {
			response.setMsg(CartMessages.GET_ERR);
			response.setResult(Result.ERROR);
		}
		return response;
	}

	public ResponseBody getByUser(long idUser) {
		ResponseBody response = new ResponseBody("getCartByIdUser");
		List<Cart> carts = repository.findByIdUser(idUser);
		if(carts.size() > 0) {
			response.setMsg(CartMessages.GET_MANY_OK);
			response.setResult(Result.OK);
		} else {
			response.setMsg(CartMessages.GET_MANY_ERR);
			response.setResult(Result.ERROR);
		}
		response.setData(converter.getMCarts(carts));
		return response;
	}
	
	public ResponseBody getByCommerce(long idCommerce) {
		ResponseBody response = new ResponseBody("getCartByIdCommerce");
		List<Cart> carts = repository.findByIdCommerce(idCommerce);
		if(carts.size() > 0) {
			response.setMsg(CartMessages.GET_MANY_OK);
			response.setResult(Result.OK);
		} else {
			response.setMsg(CartMessages.GET_MANY_ERR);
			response.setResult(Result.ERROR);
		}
		response.setData(converter.getMCarts(carts));
		return response;
	}
}
