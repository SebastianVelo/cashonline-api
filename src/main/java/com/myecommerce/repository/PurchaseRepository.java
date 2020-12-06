package com.myecommerce.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myecommerce.entity.Purchase;

@Repository("purchaseRepository")
public interface PurchaseRepository extends JpaRepository<Purchase, Serializable>{
	public abstract Purchase findById(long id);
	public abstract List<Purchase> findByIdCart(long idCart);
	public abstract List<Purchase> findByIdProduct(long idProduct);
}
