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
import com.myecommerce.entity.Subcategory;
import com.myecommerce.service.SubcategoryService;

@RestController
@RequestMapping("/myecommerce/subcategory")
public class SubcategoryController {

	@Autowired
	@Qualifier("subcategoryService")
	private SubcategoryService service;
	
	@PutMapping("")
	public ResponseEntity<ResponseBody> insert(@RequestBody @Validated Subcategory subcategory) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "insertSubcategory");
		return ResponseEntity.ok().headers(header).body(service.insert(subcategory));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseBody> delete(@PathVariable("id") long id) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "deleteSubcategory");
		return ResponseEntity.ok().headers(header).body(service.delete(id));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseBody> getById(@PathVariable("id") long id) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "getSubcategoryById");
		return ResponseEntity.ok().headers(header).body(service.get(id));
	}
	
	@GetMapping("/category/{idCategory}")
	public ResponseEntity<ResponseBody> getByCommerce(@PathVariable("idCategory") long idCategory) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "getSubcategoriesByCategory");
		return ResponseEntity.ok().headers(header).body(service.getByCategory(idCategory));
	}
}
