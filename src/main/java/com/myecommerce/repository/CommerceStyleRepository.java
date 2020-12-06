 package com.myecommerce.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myecommerce.entity.CommerceStyle;

@Repository("commerceStyleRepository")
public interface CommerceStyleRepository extends JpaRepository<CommerceStyle, Serializable>{

	public abstract CommerceStyle findById(long id);
	public abstract CommerceStyle findByIdCommerce(long idCommerce);
	
}
