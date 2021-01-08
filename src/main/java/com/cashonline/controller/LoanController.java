package com.cashonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cashonline.dto.ResponseBody;
import com.cashonline.dto.LoanDTO;
import com.cashonline.service.LoanService;
import com.cashonline.util.Util;

@RestController
@RequestMapping("/cashonline/loan")
public class LoanController {

	@Autowired
	@Qualifier("loanService")
	private LoanService service;

	@Autowired
	@Qualifier("util")
	private Util util;
	
	@PutMapping("")
	public ResponseEntity<ResponseBody> insert(@RequestBody @Validated LoanDTO loan) {
		return ResponseEntity.ok().headers(util.getHeaders("insert")).body(service.insert(loan));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseBody> delete(@PathVariable("id") long id) {
		return ResponseEntity.ok().headers(util.getHeaders("delete")).body(service.delete(id));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseBody> get(@PathVariable("id") long id) {
		return ResponseEntity.ok().headers(util.getHeaders("get")).body(service.get(id));
	}

	@GetMapping("/user/{idUser}")
	public ResponseEntity<ResponseBody> getByUser(@PathVariable("idUser") long idUser) {
		return ResponseEntity.ok().headers(util.getHeaders("getByUser")).body(service.getByUser(idUser));
	}

	@GetMapping("/all/{page}/{size}")
	public ResponseEntity<ResponseBody> getAll(@PathVariable("page") int page, @PathVariable("size") int size) {
		return ResponseEntity.ok().headers(util.getHeaders("getAll")).body(service.getAll(page, size));
	}
}
