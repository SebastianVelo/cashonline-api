package com.myecommerce.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.myecommerce.entity.Cart;
import com.myecommerce.entity.Category;
import com.myecommerce.entity.Commerce;
import com.myecommerce.entity.Product;
import com.myecommerce.entity.Purchase;
import com.myecommerce.entity.Subcategory;
import com.myecommerce.model.MCart;
import com.myecommerce.model.MCategory;
import com.myecommerce.model.MCommerce;
import com.myecommerce.model.MProduct;
import com.myecommerce.model.MPurchase;
import com.myecommerce.model.MSubcategory;

@Component("converter")
public class Converter {
	
	public List<MCommerce> getMCommerces(List<Commerce> commerces) {
		List<MCommerce> mcommerces = new ArrayList<>();
		for (Commerce commerce : commerces)
			mcommerces.add(new MCommerce(commerce));
		return mcommerces;
	}
	
	public List<MCategory> getMCategories(List<Category> categories) {
		List<MCategory> mcategories = new ArrayList<>();
		for (Category category : categories)
			mcategories.add(new MCategory(category));
		return mcategories;
	}

	public List<MProduct> getMProducts(List<Product> products) {
		List<MProduct> mproducts = new ArrayList<>();
		for (Product commerce : products)
			mproducts.add(new MProduct(commerce));
		return mproducts;
	}

	public List<MSubcategory> getMSubcategories(List<Subcategory> subcategories) {
		List<MSubcategory> msubcategories = new ArrayList<>();
		for (Subcategory commerce : subcategories)
			msubcategories.add(new MSubcategory(commerce));
		return msubcategories;
	}
	
	public List<MCart> getMCarts(List<Cart> carts) {
		List<MCart> mcarts = new ArrayList<>();
		for(Cart cart : carts)
			mcarts.add(new MCart(cart));
		return mcarts;
	}
	
	public List<MPurchase> getMPurchases(List<Purchase> purchases) {
		List<MPurchase> mpurchases = new ArrayList<>();
		for(Purchase purchase : purchases)
			mpurchases.add(new MPurchase(purchase));
		return mpurchases;
	}
}
