package com.myecommerce.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myecommerce.entity.Cart;

@Repository("cartRepository")
public interface CartRepository extends JpaRepository<Cart, Serializable>{
	public abstract Cart findById(long id);
	public abstract List<Cart> findByIdCommerce(long idCommerce);
	public abstract List<Cart> findByIdUser(long idUser);
}
