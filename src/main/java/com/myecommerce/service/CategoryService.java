package com.myecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.myecommerce.converter.Converter;
import com.myecommerce.dto.ResponseBody;
import com.myecommerce.entity.Category;
import com.myecommerce.entity.Commerce;
import com.myecommerce.entity.Subcategory;
import com.myecommerce.enumerator.CategoryMessages;
import com.myecommerce.enumerator.CommerceMessages;
import com.myecommerce.enumerator.Result;
import com.myecommerce.model.MCategory;
import com.myecommerce.repository.CategoryRepository;
import com.myecommerce.repository.CommerceRepository;
import com.myecommerce.repository.SubcategoryRepository;

@Service("categoryService")
public class CategoryService {

	@Autowired
	@Qualifier("categoryRepository")
	private CategoryRepository repository;

	@Autowired
	@Qualifier("commerceRepository")
	private CommerceRepository commerceRepository;
	
	@Autowired
	@Qualifier("subcategoryRepository")
	private SubcategoryRepository subcategoryRepository;
	
	@Autowired
	@Qualifier("subcategoryService")
	private SubcategoryService subcategoryService;
	
	@Autowired
	@Qualifier("converter")
	private Converter converter;

	public ResponseBody insert(Category category) {
		ResponseBody response = new ResponseBody("insertCategory");
		try {
			Commerce commerce = commerceRepository.findById(category.getIdCommerce());
			if(commerce != null) {
				repository.save(category);
				response.setMsg(CategoryMessages.INSERT_OK);
				response.setResult(Result.OK);
				response.setData(category);
			} else {
				response.setMsg(CommerceMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			}
		} catch (Exception e) {
			response.setMsg(CategoryMessages.INSERT_ERR);
			response.setResult(Result.ERROR);
		}
		return response;
	}

	public ResponseBody delete(long id) {
		ResponseBody response = new ResponseBody("deleteCategory");
		try {
			Category category = repository.findById(id);
			if(category != null) {
				repository.delete(category);
				List<Subcategory> subcategories = subcategoryRepository.findByIdCategory(id);
				for(Subcategory subcategory : subcategories) {
					subcategoryService.delete(subcategory.getId());
				}
				response.setMsg(CategoryMessages.DELETE_OK);
				response.setResult(Result.OK);
			} else {
				response.setMsg(CategoryMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			}
			
		} catch (Exception e) {
			response.setMsg(CategoryMessages.DELETE_ERR);
			response.setResult(Result.ERROR);
		}
		return response;
	}

	public ResponseBody get(long id) {
		ResponseBody response = new ResponseBody("getCategory");
		try {
			Category category = repository.findById(id);
			if(category != null) {
				response.setMsg(CategoryMessages.GET_OK);
				response.setResult(Result.OK);
				response.setData(new MCategory(category));
			} else {
				response.setMsg(CategoryMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			}
		} catch (Exception e) {
			response.setMsg(CategoryMessages.GET_ERR);
			response.setResult(Result.ERROR);
		}
		return response;
	}

	public ResponseBody getByCommerce(long idCommerce) {
		ResponseBody response = new ResponseBody("getCategoriesByCommerce");
		List<Category> categories = repository.findByIdCommerce(idCommerce);
		if(categories.size() > 0) {
			response.setMsg(CategoryMessages.GET_MANY_OK);
			response.setResult(Result.OK);
		} else {
			response.setMsg(CategoryMessages.GET_MANY_ERR);
			response.setResult(Result.ERROR);
		}
		response.setData(converter.getMCategories(categories));
		return response;
	}

}
