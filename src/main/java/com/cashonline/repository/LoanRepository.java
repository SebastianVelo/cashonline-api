package com.cashonline.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cashonline.entity.Loan;

@Repository("loanRepository")
public interface LoanRepository extends PagingAndSortingRepository<Loan, Serializable>{

	public abstract Page<Loan> findAll(Pageable pageable);
	public abstract Loan findById(long id);
	public abstract List<Loan> findByIdUser(long idUser);
	public abstract Page<Loan> findByIdUserPaging(long idUser, Pageable pageable);
	public abstract Long deleteByIdUser(long idUser);
}
