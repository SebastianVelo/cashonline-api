package com.myecommerce.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myecommerce.entity.Subcategory;

@Repository("subcategoryRepository")
public interface SubcategoryRepository extends JpaRepository<Subcategory, Serializable>{

	public abstract Subcategory findById(long id);
	public abstract List<Subcategory> findByIdCategory(long idCategory);
	
}
