package com.RestApiDevProject2.MobController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RestApiDevProject2.Entity.Product;
import com.RestApiDevProject2.MobService.ProductService;


@RestController
@RequestMapping("productinfo")
public class ProductController {
	
	@Autowired
	ProductService prodserv;
	
	
	@PostMapping("insert")
	public String saveProductInfo(@RequestBody Product prod)
	{
		String produ = prodserv.saveProductInfo(prod);
		return produ;	
	}
	
	
	@PostMapping("product/{cid}")
	public Product addProduct(@RequestBody Product product,@PathVariable int cid)
	{
		return prodserv.addProduct(product, cid);
	}
	
	
	
	
	
	
	

}
