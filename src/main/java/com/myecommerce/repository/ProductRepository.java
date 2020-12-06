package com.myecommerce.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myecommerce.entity.Product;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, Serializable>{

	public abstract Product findById(long id);
	public abstract List<Product> findByIdSubcategory(long idSubcategory);
	
	@Query(value = "SELECT p.* FROM product p, subcategory s, category c WHERE " + 
					"p.show_in_home = TRUE " + 
					"AND c.id_commerce = ?1 " + 
					"AND c.id = s.id_category " + 
					"AND s.id = p.id_subcategory", nativeQuery = true)
	public abstract List<Product> findByShowInHome(long idCommerce);
	
	@Query(value = "SELECT * FROM product p " + 
				   "INNER JOIN subcategory s " + 
				   "ON s.id_category = ?1 AND p.id_subcategory = s.id", nativeQuery = true)
	
	public abstract List<Product> findByIdCategory(long idCategory);
	
}
