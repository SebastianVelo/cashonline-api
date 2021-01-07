package com.cashonline.controller;

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

import com.cashonline.dto.ResponseBody;
import com.cashonline.dto.LoanDTO;
import com.cashonline.service.LoanService;

@RestController
@RequestMapping("/cashonline/loan")
public class LoanController {

	@Autowired
	@Qualifier("loanService")
	private LoanService service;
	
	@PutMapping("")
	public ResponseEntity<ResponseBody> insert(@RequestBody @Validated LoanDTO loan) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "insertLoan");
		return ResponseEntity.ok().headers(header).body(service.insert(loan));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseBody> delete(@PathVariable("id") long id) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "deleteLoan");
		return ResponseEntity.ok().headers(header).body(service.delete(id));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseBody> get(@PathVariable("id") long id) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "getLoanById");
		return ResponseEntity.ok().headers(header).body(service.get(id));
	}

	@GetMapping("/user/{idUser}")
	public ResponseEntity<ResponseBody> getByUser(@PathVariable("idUser") long idUser) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "getLoanByUser");
		return ResponseEntity.ok().headers(header).body(service.getByUser(idUser));
	}

	@GetMapping("/all/{page}/{size}")
	public ResponseEntity<ResponseBody> getAll(@PathVariable("page") int page, @PathVariable("page") int size) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "getLoanByUser");
		return ResponseEntity.ok().headers(header).body(service.getAll(page, size));
	}
}
