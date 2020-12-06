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
import com.myecommerce.entity.CommerceStyle;
import com.myecommerce.service.CommerceStyleService;

@RestController
@RequestMapping("/myecommerce/commerce-style")
public class CommerceStyleController {

	@Autowired
	@Qualifier("commerceStyleService")
	private CommerceStyleService service;
	
	@PutMapping("")
	public ResponseEntity<ResponseBody> insert(@RequestBody @Validated CommerceStyle commerceStyle) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "insertCommerce");
		return ResponseEntity.ok().headers(header).body(service.insert(commerceStyle));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseBody> delete(@PathVariable("id") long id) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "deleteCommerce");
		return ResponseEntity.ok().headers(header).body(service.delete(id));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseBody> get(@PathVariable("id") long id) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "getCommerceById");
		return ResponseEntity.ok().headers(header).body(service.get(id));
	}
	
	@GetMapping("/commerce/{idCommerce}")
	public ResponseEntity<ResponseBody> getByCommerce(@PathVariable("idCommerce") long idCommerce) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "getCategoriesByCommerce");
		return ResponseEntity.ok().headers(header).body(service.getByCommerce(idCommerce));
	}
}
