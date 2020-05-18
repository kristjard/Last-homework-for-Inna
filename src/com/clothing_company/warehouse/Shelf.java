package com.clothing_company.warehouse;

import com.clothing_company.product.Product;

public class Shelf {
    private String loc;
    private Product product;

    public Shelf(String loc, Product product) {
        this.loc = loc;
        this.product = product;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Shelf{" +
                "stack='" + loc + '\'' +
                ", product=" + product +
                '}';
    }
}
