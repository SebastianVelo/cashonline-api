package com.myecommerce.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.myecommerce.dto.CartDTO;
import com.myecommerce.dto.CommerceDTO;
import com.myecommerce.dto.ProductDTO;
import com.myecommerce.dto.UserDTO;
import com.myecommerce.entity.Cart;
import com.myecommerce.entity.Category;
import com.myecommerce.entity.Commerce;
import com.myecommerce.entity.Product;
import com.myecommerce.entity.Purchase;
import com.myecommerce.entity.Subcategory;
import com.myecommerce.entity.User;
import com.myecommerce.entity.UserData;
import com.myecommerce.model.MCategory;
import com.myecommerce.model.MPurchase;
import com.myecommerce.model.MSubcategory;

@Component("converter")
public class Converter {

	public List<MCategory> getMCategories(List<Category> categories) {
		List<MCategory> mcategories = new ArrayList<>();
		for (Category category : categories)
			mcategories.add(new MCategory(category));
		return mcategories;
	}

	public List<MSubcategory> getMSubcategories(List<Subcategory> subcategories) {
		List<MSubcategory> msubcategories = new ArrayList<>();
		for (Subcategory commerce : subcategories)
			msubcategories.add(new MSubcategory(commerce));
		return msubcategories;
	}

	public List<MPurchase> getMPurchases(List<Purchase> purchases) {
		List<MPurchase> mpurchases = new ArrayList<>();
		for(Purchase purchase : purchases)
			mpurchases.add(new MPurchase(purchase));
		return mpurchases;
	}

	public User getUserFromDTO(UserDTO userDTO) {
		User user = new User();
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		user.setEmail(userDTO.getEmail());
		return user;
	}

	public UserData getUserDataFromDTO(UserDTO userDTO) {
		UserData userData = new UserData();
		userData.setIdUser(userDTO.getId());
		userData.setAddress(userDTO.getAddress());
		userData.setName(userDTO.getName());
		userData.setLastname(userDTO.getLastname());
		userData.setPhone(userDTO.getPhone());
		return userData;
	}

	public Commerce getCommerceFromDTO(CommerceDTO commerceDTO) {
		Commerce commerce = new Commerce();
		commerce.setIdUser(commerceDTO.getIdUser());
		commerce.setName(commerceDTO.getName());
		commerce.setPath(commerceDTO.getPath());
		commerce.setDescription(commerceDTO.getDescription());
		return commerce;
	}

	public Product getProductFromDTO(ProductDTO productDTO) {
		Product product = new Product();
		product.setCurrency(productDTO.getCurrency());
		product.setDescription(productDTO.getDescription());
		product.setIdSubcategory(productDTO.getIdSubcategory());
		product.setName(productDTO.getName());
		product.setPrice(productDTO.getPrice());
		product.setShowInHome(productDTO.isShowInHome());
		product.setStock(productDTO.getStock());
		return product;
	}

	public Cart getCartFromDTO(CartDTO cartDTO) {
		Cart cart = new Cart();
		cart.setIdUser(cartDTO.getIdUser());
		cart.setIdCommerce(cartDTO.getIdCommerce());
		return cart;
	}
 }
