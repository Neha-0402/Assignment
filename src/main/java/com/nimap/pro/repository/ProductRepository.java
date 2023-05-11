package com.nimap.pro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nimap.pro.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{

}
