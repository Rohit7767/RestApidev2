package com.RestApiDevProject2.MobController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RestApiDevProject2.Entity.Category;
import com.RestApiDevProject2.Entity.ObjectNotFoundException;
import com.RestApiDevProject2.MobService.CategoryService;



@RestController
@RequestMapping("CategoryInfo")
public class CategoryController {
	
	@Autowired
	CategoryService cateserv;
	
	@PostMapping("saveCategory")
	public Category saveCategory(@RequestBody Category categ)
	{
		System.out.println(categ);
		cateserv.saveCategory(categ);
		return categ;
	}
	
	
	@GetMapping("getCategory/{cid}")
	public Category getCategory(@PathVariable int cid)
	{
		Category category = cateserv.getCategory(cid);
		if(category==null)
		{
			throw new ObjectNotFoundException("no record found with cid " + cid);
		}
		else
		{
		return category;
		}
		
	}
	
	
	@GetMapping("getCategory1/{cid}")
	public Category getCategory1(@PathVariable int cid)
	{
		Category category = cateserv.getCategory(cid);
		return category;
		
	}
	
	
	
	@PutMapping("updateCategory")
	public Category updateCategory(@RequestBody Category cat)
	{
		System.out.println(cat);
		return cateserv.updateCategory(cat);
	}
	
	
	@DeleteMapping("deleteCategory/{cid}")
	public Category deleteCategory1(@PathVariable int cid)
	{
		Category category = cateserv.deleteCategory(cid);
		return category;
		
	}
	
	
	@RequestMapping("getAllCategory")
	public List<Category> getAllCategory() {
		return cateserv.getAllCategory();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	


}
