package com.myecommerce.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myecommerce.entity.Commerce;

@Repository("commerceRepository")
public interface CommerceRepository extends JpaRepository<Commerce, Serializable>{

	public abstract Commerce findById(long id);
	public abstract Commerce findByPath(String path);
	public abstract List<Commerce> findByIdUser(long idUser);
	
}
