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
import com.myecommerce.entity.Commerce;
import com.myecommerce.service.CommerceService;

@RestController
@RequestMapping("/myecommerce/commerce")
public class CommerceController {

	@Autowired
	@Qualifier("commerceService")
	private CommerceService service;
	
	@PutMapping("")
	public ResponseEntity<ResponseBody> insert(@RequestBody @Validated Commerce commerce) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "insertCommerce");
		return ResponseEntity.ok().headers(header).body(service.insert(commerce));
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
	
	@GetMapping("/path/{path}")
	public ResponseEntity<ResponseBody> getByPath(@PathVariable("path") String path) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "getCommerceByPath");
		return ResponseEntity.ok().headers(header).body(service.getByPath(path));
	}
	
	@GetMapping("/user/{idUser}")
	public ResponseEntity<ResponseBody> getByUser(@PathVariable("idUser") long idUser) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "getCommercesByUser");
		return ResponseEntity.ok().headers(header).body(service.getByUser(idUser));
	}
}
