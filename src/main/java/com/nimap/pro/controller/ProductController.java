package com.nimap.pro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.pro.repository.ProductRepository;
import com.nimap.pro.entities.Product;

@RequestMapping("/api")
@RestController
public class ProductController {
	
	@Autowired
	ProductRepository pr;
	
	@GetMapping("/product/page")
	public List<Product> getAllProducts(@RequestParam(defaultValue = "0")int page,@RequestParam(defaultValue = "I")int size){
		Page<Product> pagePost = pr.findAll(PageRequest.of(page, size));
		List<Product> allPost = pagePost.getContent();
		return allPost;
	} 
	
	@GetMapping("/product")
	public List<Product> getPro(){
		
		return (List<Product>)pr.findAll();
	}
	@PostMapping("/product")
	public Product addProduct(Product product) {
		
		pr.save(product);		
		return product;	
	}
	@GetMapping("/product/{id}")
	public Product addProduct(@PathVariable int pro_id) {
		
		Product product = pr.findById(pro_id).orElse(new Product());
		return product;
	}
	@PutMapping("/product/{id}")
	public Product updateProduct(@RequestBody Product product,@PathVariable int pro_id) {
		
		pr.save(product);
		return product;
	} 
	@DeleteMapping("/product/{id}")
	public Product deleteProduct(@PathVariable int pro_id) {
		
		Product product = pr.findById(pro_id).orElse(new Product());
		pr.delete(product);
		return product;
	}
		
}
