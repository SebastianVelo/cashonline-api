package com.myecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.myecommerce.converter.Converter;
import com.myecommerce.dto.ProductDTO;
import com.myecommerce.dto.ResponseBody;
import com.myecommerce.entity.Product;
import com.myecommerce.entity.ProductImg;
import com.myecommerce.entity.Subcategory;
import com.myecommerce.enumerator.ProductMessages;
import com.myecommerce.enumerator.Result;
import com.myecommerce.enumerator.SubcategoryMessages;
import com.myecommerce.repository.CategoryRepository;
import com.myecommerce.repository.ProductImgRepository;
import com.myecommerce.repository.ProductRepository;
import com.myecommerce.repository.SubcategoryRepository;

@Service("productService")
public class ProductService {

	@Autowired
	@Qualifier("productRepository")
	private ProductRepository repository;

	@Autowired 
	@Qualifier("subcategoryRepository")
	private SubcategoryRepository subcategoryRepository;
	
	@Autowired
	@Qualifier("categoryRepository")
	private CategoryRepository categoryRepository;

	@Autowired
	@Qualifier("productImgRepository")
	private ProductImgRepository productImgRepository;
	
	@Autowired
	@Qualifier("converter")
	private Converter converter;

	public ResponseBody insert(ProductDTO productDTO) {
		ResponseBody response = new ResponseBody("insertProduct");
		Product product = converter.getProductFromDTO(productDTO);
		try {
			Subcategory subcategory = subcategoryRepository.findById(product.getIdSubcategory());
			if(subcategory != null) {
				productDTO.setId(repository.save(product).getId());
				productImgRepository.saveAll(productDTO.getImgs());
				response.setMsg(ProductMessages.INSERT_OK);
				response.setResult(Result.OK);
				response.setData(productDTO);
			} else {
				response.setMsg(SubcategoryMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			}
		} catch (Exception e) {
			response.setMsg(ProductMessages.INSERT_ERR);
			response.setResult(Result.ERROR);
		}
		return response;
	}

	public ResponseBody delete(long id) {
		ResponseBody response = new ResponseBody("deleteProduct");
		try {
			Product product = repository.findById(id);
			if (product != null) {
				repository.delete(product);
				response.setMsg(ProductMessages.DELETE_OK);
				response.setResult(Result.OK);
			} else {
				response.setMsg(ProductMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			}
		} catch (Exception e) {
			response.setMsg(ProductMessages.DELETE_ERR);
			response.setResult(Result.ERROR);
		}
		return response;
	}

	public ResponseBody get(long id) {
		ResponseBody response = new ResponseBody("getProduct");
		try {
			Product product = repository.findById(id);
			if (product != null) {
				List<ProductImg> imgs = productImgRepository.findByIdProduct(product.getId());
				response.setMsg(ProductMessages.GET_OK);
				response.setResult(Result.OK);
				response.setData(new ProductDTO(product, imgs));
			} else {
				response.setMsg(ProductMessages.ERR_NOT_EXISTS);
				response.setResult(Result.ERROR);
			}
		} catch (Exception e) {
			response.setMsg(ProductMessages.GET_ERR);
			response.setResult(Result.ERROR);
		}
		return response;
	}

	public ResponseBody getByCategory(long idCategory) {
		List<Product> products = repository.findByIdCategory(idCategory);
		return this.getMany("getProductsByCategory", products);
	}
	
	public ResponseBody getBySubcategory(long idSubategory) {
		List<Product> products = repository.findByIdSubcategory(idSubategory);
		return this.getMany("getProductsBySubcategory", products);
	}
	
	public ResponseBody getByShowInHome(long idCommerce) {
		List<Product> products = repository.findByShowInHome(idCommerce);
		return this.getMany("getProductsByShowInHome", products);
	}
	
	private ResponseBody getMany(String request, List<Product> products) {
		ResponseBody response = new ResponseBody(request);
		List<ProductDTO> productsDTO = new ArrayList<>();
		for(Product product : products) {
			productsDTO.add((ProductDTO) this.get(product.getId()).getData());
		}

		if (!productsDTO.isEmpty()) {
			response.setMsg(ProductMessages.GET_MANY_OK);
			response.setResult(Result.OK);
			response.setData(productsDTO);
		} else {
			response.setMsg(ProductMessages.GET_MANY_ERR);
			response.setResult(Result.ERROR);
		}
		return response;
	}
}
