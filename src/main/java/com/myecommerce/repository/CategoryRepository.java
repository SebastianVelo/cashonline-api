package com.myecommerce.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myecommerce.entity.Category;

@Repository("categoryRepository")
public interface CategoryRepository extends JpaRepository<Category, Serializable>{

	public abstract Category findById(long id);
	public abstract List<Category> findByIdCommerce(long idCommerce);
	public abstract long deleteByIdCommerce(long idCommerce);
	
}
