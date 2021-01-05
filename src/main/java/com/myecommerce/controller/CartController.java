package com.myecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myecommerce.dto.CartDTO;
import com.myecommerce.dto.ResponseBody;
import com.myecommerce.service.CartService;

@RestController
@RequestMapping("/myecommerce/cart")
public class CartController {

	@Autowired
	@Qualifier("cartService")
	private CartService service;
	
	@PutMapping("")
	public ResponseEntity<ResponseBody> insert(@RequestBody @Validated CartDTO cart) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "insertCart");
		return ResponseEntity.ok().headers(header).body(service.insert(cart));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseBody> delete(@PathVariable("id") long id) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "deleteCart");
		return ResponseEntity.ok().headers(header).body(service.delete(id));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseBody> get(@PathVariable("id") long id) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "getCartById");
		return ResponseEntity.ok().headers(header).body(service.get(id));
	}
	
	@GetMapping("/user/{idUser}")
	public ResponseEntity<ResponseBody> getByUser(@PathVariable("idUser") long idUser) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "getCartsByUser");
		return ResponseEntity.ok().headers(header).body(service.getByUser(idUser));
	}
	
	@GetMapping("/commerce/{idCommerce}")
	public ResponseEntity<ResponseBody> getByCommerce(@PathVariable("idCommerce") long idCommerce) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "getCartsByCommerce");
		return ResponseEntity.ok().headers(header).body(service.getByCommerce(idCommerce));
	}
}
