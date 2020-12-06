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

import com.myecommerce.dto.ResponseBody;
import com.myecommerce.entity.Purchase;
import com.myecommerce.service.PurchaseService;

@RestController
@RequestMapping("/myecommerce/purchase")
public class PurchaseController {

	@Autowired
	@Qualifier("purchaseService")
	private PurchaseService service;
	
	@PutMapping("")
	public ResponseEntity<ResponseBody> insert(@RequestBody @Validated Purchase purchase) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "insertPurchase");
		return ResponseEntity.ok().headers(header).body(service.insert(purchase));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseBody> delete(@PathVariable("id") long id) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "deletePurchase");
		return ResponseEntity.ok().headers(header).body(service.delete(id));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseBody> get(@PathVariable("id") long id) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "getPurchaseById");
		return ResponseEntity.ok().headers(header).body(service.get(id));
	}
	
	@GetMapping("/cart/{idCart}")
	public ResponseEntity<ResponseBody> getByCart(@PathVariable("idCart") long idCart) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "getPurchasesByCart");
		return ResponseEntity.ok().headers(header).body(service.getByCart(idCart));
	}
	
	@GetMapping("/product/{idProduct}")
	public ResponseEntity<ResponseBody> getByProduct(@PathVariable("idProduct") long idProduct) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "getPurchasesByProduct");
		return ResponseEntity.ok().headers(header).body(service.getByProduct(idProduct));
	}
}
