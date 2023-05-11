package com.nimap.pro.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pro_id;  //Product id
	private String pro_name;  //Product name
	private int pro_price;
	private String pro_warranty;
	private String pro_rating;
	@ManyToOne
	@JoinColumn
	private Category ct;
	
	public int getPro_id() {
		return pro_id;
	}
	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public int getPro_price() {
		return pro_price;
	}
	public void setPro_price(int pro_price) {
		this.pro_price = pro_price;
	}
	public String getPro_warranty() {
		return pro_warranty;
	}
	public void setPro_warranty(String pro_warranty) {
		this.pro_warranty = pro_warranty;
	}
	public String getPro_rating() {
		return pro_rating;
	}
	public void setPro_rating(String pro_rating) {
		this.pro_rating = pro_rating;
	}
	@Override
	public String toString() {
		return "Products ...[ Sr_no : " + pro_id + ", Product_Name=" + pro_name + ", Product_Price=" + pro_price + ", Product_warranty=" + pro_warranty
				+ ", Product_Rating=" + pro_rating + "]";
	}
	
	
	
}
