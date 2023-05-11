package com.nimap.pro.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cate_id;// Category Id
	private String cate_name;// Category Name
	@OneToMany(mappedBy ="ct",cascade = CascadeType.ALL)
	
	private List<Product> product;
	
	
	public List<Product> getPro() {
		return product;
	}
	public void setPro(List<Product> product) {
		this.product = product;
	}
	public int getCate_id() {
		return cate_id;
	}
	public void setCate_id(int cate_id) {
		this.cate_id = cate_id;
	}
	public String getCate_name() {
		return cate_name;
	}
	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}
	@Override
	public String toString() {
		return "Categories... [ Category-id=" + cate_id + ", Category-name=" + cate_name + "]";
	}

}

