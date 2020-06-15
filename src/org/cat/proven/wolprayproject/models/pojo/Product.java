/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cat.proven.wolprayproject.models.pojo;

import java.util.Map;

/**
 *
 * @author Lewis
 */
public class Product {
    private int id;
    private String name;
    private String category;
    private String description;
    private double price;
    private String imageUrl;
    private boolean status;

    public Product(int id, String name, String category, String description, double price, String imageUrl, boolean status) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.status = status;
    }

  

    

    public Product(int id) {
        this.id = id;
    }

    public Product() {
    }
    public Product(Product product) {
        this.id = product.id;
        this.name = product.name;
        this.category = product.category;
        this.description = product.description;
        this.price = product.price;
        this.imageUrl = product.imageUrl;
    }
    
    public Product(Map<String,Object> json) {
        this.id = (int) json.get("id");
        this.name = (String) json.get("name");
        this.category = (String) json.get("category");
        this.description = (String) json.get("description");
        this.price = (double) json.get("price");
        this.imageUrl = (String) json.get("imageUrl");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
    
    
    /** equals()
	 * compares this product to another one
	 * two persons are equals if their nifs are equals.
	 * @param obj other: the other product to compare to
	 * @return true if they are equals, false otherwise
	 */
    @Override
    public boolean equals(Object obj) {
		boolean b = false;
		if (obj == null) {
			b= false;
		} else {
			if (obj == this) {
				b = true;
			} else {
				if (obj instanceof Product) {
				    Product other = (Product) obj;
				    b = (this.id == other.id);
				} else {
					b = false;
				}
			}
		}
		return b;
	}

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", category=" + category + ", description=" + description + ", price=" + price + ", imageUrl=" + imageUrl + '}';
    }
    
    
    
}
