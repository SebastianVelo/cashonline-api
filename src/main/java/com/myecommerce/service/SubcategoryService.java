package com.myecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.myecommerce.converter.Converter;
import com.myecommerce.dto.ResponseBody;
import com.myecommerce.entity.Category;
import com.myecommerce.entity.Product;
import com.myecommerce.entity.Subcategory;
import com.myecommerce.enumerator.CategoryMessages;
import com.myecommerce.enumerator.Result;
import com.myecommerce.enumerator.SubcategoryMessages;
import com.myecommerce.model.MSubcategory;
import com.myecommerce.repository.CategoryRepository;
import com.myecommerce.repository.ProductRepository;
import com.myecommerce.repository.SubcategoryRepository;

@Service("subcategoryService")
public class SubcategoryService {

	@Autowired
	@Qualifier("subcategoryRepository")
	private SubcategoryRepository repository;

	@Autowired
	@Qualifier("categoryRepository")
	private CategoryRepository categoryRepository;
	
	@Autowired
	@Qualifier("productRepository")
	private ProductRepository productRepository;
	
	@Autowired
	@Qualifier("productService")
	private ProductService productService;
	
	@Autowired
	@Qualifier("converter")
	private Converter converter;

	public ResponseBody insert(Subcategory subcategory) {
		ResponseBody response = new ResponseBody("insertSubcategory");
		try {
			Category category = categoryRepository.findById(subcategory.getIdCategory());
			if(category != null) {
				repository.save(subcategory);
				response.setMsg(SubcategoryMessages.INSERT_OK);
				response.setResult(Result.OK);
				response.setData(subcategory);
			} else {
				response.setMsg(CategoryMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			}
		} catch (Exception e) {
			response.setMsg(SubcategoryMessages.INSERT_ERR);
			response.setResult(Result.ERROR);
		}
		return response;
	}

	public ResponseBody delete(long id) {
		ResponseBody response = new ResponseBody("deleteSubcategory");
		try {
			Subcategory subcategory = repository.findById(id);
			if(subcategory != null) {
				repository.delete(subcategory);
				List<Product> products = productRepository.findByIdSubcategory(id);
				for(Product product : products) {
					productService.delete(product.getId());
				}
				response.setMsg(SubcategoryMessages.DELETE_OK);
				response.setResult(Result.OK);
			} else {
				response.setMsg(SubcategoryMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			}
			
		} catch (Exception e) {
			response.setMsg(SubcategoryMessages.DELETE_ERR);
			response.setResult(Result.ERROR);
		}
		return response;
	}

	public ResponseBody get(long id) {
		ResponseBody response = new ResponseBody("getCategory");
		try {
			Subcategory subcategory = repository.findById(id);
			if(subcategory != null) {
				response.setMsg(SubcategoryMessages.GET_OK);
				response.setResult(Result.OK);
				response.setData(new MSubcategory(subcategory));
			} else {
				response.setMsg(SubcategoryMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			}
		} catch (Exception e) {
			response.setMsg(SubcategoryMessages.GET_ERR);
			response.setResult(Result.ERROR);
		}
		return response;
	}

	public ResponseBody getByCategory(long idCategory) {
		ResponseBody response = new ResponseBody("getCategoriesByCommerce");
		List<Subcategory> subcategories = repository.findByIdCategory(idCategory);
		if(subcategories.size() > 0) {
			response.setMsg(SubcategoryMessages.GET_MANY_OK);
			response.setResult(Result.OK);
		} else {
			response.setMsg(SubcategoryMessages.GET_MANY_ERR);
			response.setResult(Result.ERROR);
		}
		response.setData(converter.getMSubcategories(subcategories));
		return response;
	}

}
