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
import com.myecommerce.entity.Category;
import com.myecommerce.service.CategoryService;

@RestController
@RequestMapping("/myecommerce/category")
public class CategoryController {

	@Autowired
	@Qualifier("categoryService")
	private CategoryService service;
	
	@PutMapping("")
	public ResponseEntity<ResponseBody> insert(@RequestBody @Validated Category category) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "insertCategory");
		return ResponseEntity.ok().headers(header).body(service.insert(category));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseBody> delete(@PathVariable("id") long id) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "deleteCategory");
		return ResponseEntity.ok().headers(header).body(service.delete(id));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseBody> getById(@PathVariable("id") long id) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "getCategoryById");
		return ResponseEntity.ok().headers(header).body(service.get(id));
	}
	
	@GetMapping("/commerce/{idCommerce}")
	public ResponseEntity<ResponseBody> getByCommerce(@PathVariable("idCommerce") long idCommerce) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "getCategoriesByCommerce");
		return ResponseEntity.ok().headers(header).body(service.getByCommerce(idCommerce));
	}
}
