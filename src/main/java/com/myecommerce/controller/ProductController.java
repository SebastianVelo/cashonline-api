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

import com.myecommerce.dto.ProductDTO;
import com.myecommerce.dto.ResponseBody;
import com.myecommerce.service.ProductService;

@RestController
@RequestMapping("/myecommerce/product")
public class ProductController {

	@Autowired
	@Qualifier("productService")
	private ProductService service;
	
	@PutMapping("")
	public ResponseEntity<ResponseBody> insert(@RequestBody @Validated ProductDTO product) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "insertProduct");
		return ResponseEntity.ok().headers(header).body(service.insert(product));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseBody> delete(@PathVariable("id") long id) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "deleteProduct");
		return ResponseEntity.ok().headers(header).body(service.delete(id));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseBody> getById(@PathVariable("id") long id) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "getProductById");
		return ResponseEntity.ok().headers(header).body(service.get(id));
	}
	
	@GetMapping("/category/{idCategory}")
	public ResponseEntity<ResponseBody> getByCategory(@PathVariable("idCategory") long idCategory) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "getProductsByCategory");
		return ResponseEntity.ok().headers(header).body(service.getByCategory(idCategory));
	}
	
	@GetMapping("/subcategory/{idSubategory}")
	public ResponseEntity<ResponseBody> getBySubcategory(@PathVariable("idSubategory") long idSubcategory) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "getProductsByCategory");
		return ResponseEntity.ok().headers(header).body(service.getBySubcategory(idSubcategory));
	}
	
	@GetMapping("/home/{idCommerce}")
	public ResponseEntity<ResponseBody> getByShowInHome(@PathVariable("idCommerce") long idCommerce) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "getProductsByShowInHome");
		return ResponseEntity.ok().headers(header).body(service.getByShowInHome(idCommerce));
	}
}
