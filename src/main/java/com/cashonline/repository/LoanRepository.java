package com.cashonline.repository;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cashonline.entity.Loan;

@Repository("loanRepository")
public interface LoanRepository extends PagingAndSortingRepository<Loan, Serializable>{

	public abstract Page<Loan> findAll(Pageable pageable);
	public abstract Loan findById(long id);
	public abstract Page<Loan> findByIdUser(long idUser, Pageable pageable);
	public abstract Long deleteByIdUser(long idUser);
}
