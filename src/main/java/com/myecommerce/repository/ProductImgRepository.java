package com.myecommerce.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myecommerce.entity.ProductImg;

@Repository("productImgRepository")
public interface ProductImgRepository extends JpaRepository<ProductImg, Serializable>{

	public abstract ProductImg findById(long id);
	public abstract List<ProductImg> findByIdProduct(long idProduct);
	
}
