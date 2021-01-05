package com.myecommerce.dto;

import java.util.List;

import com.myecommerce.entity.Cart;
import com.myecommerce.entity.Purchase;

public class CartDTO {
    
    private long id;
    private long idCommerce;
    private long idUser;
    private List<Purchase> purchases;

    public CartDTO() {

    }

    public CartDTO(Cart cart, List<Purchase> purchases) {
        this.id = cart.getId();
        this.idCommerce = cart.getIdCommerce();
        this.idUser = cart.getIdUser();
        this.purchases = purchases;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
        for(Purchase purchase : this.purchases) {
            purchase.setIdCart(id);
        }
    }

    public long getIdCommerce() {
        return idCommerce;
    }

    public void setIdCommerce(long idCommerce) {
        this.idCommerce = idCommerce;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }
}
