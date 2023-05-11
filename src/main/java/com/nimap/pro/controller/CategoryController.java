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

import com.nimap.pro.repository.CategoryRepository;
import com.nimap.pro.entities.Category;
@RequestMapping("/api")
@RestController
public class CategoryController {
	
	@Autowired
	CategoryRepository cr;
	
	@GetMapping("/product/page")
	public List<Category> getAllProducts(@RequestParam(defaultValue = "0")int page,@RequestParam(defaultValue = "I")int size){
		Page<Category> pagePost = cr.findAll(PageRequest.of(page, size));
		List<Category> allPost = pagePost.getContent();
		return allPost;
	} 
	
	@GetMapping(path="/category")
	public List<Category> getCategory() {
		return (List<Category>) cr.findAll();
	}
	@PostMapping("/category")
	public Category addCategory(@RequestBody Category ct)
	{
		cr.save(ct);
		return ct;	
	}
	@GetMapping("/category/{id}")
	public Category getCategory(@PathVariable int cate_id) {

		Category ct = cr.findById(cate_id).orElse(new Category());
		return ct;		
	}
	@PutMapping("/category/{id}")
	public Category updateCategory(@RequestBody Category ct ,@PathVariable int cate_id) {
		cr.save(ct);
		return  ct;	
	}
	@DeleteMapping("/category/{id}")
	public Category deleteCategory(@PathVariable int cate_id) {
		
		Category ct = cr.findById(cate_id).orElse(new Category());
		cr.delete(ct);
		return ct;
		
	}
	
}
