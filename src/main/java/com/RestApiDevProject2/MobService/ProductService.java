package com.RestApiDevProject2.MobService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.RestApiDevProject2.Entity.Product;
import com.RestApiDevProject2.MDao.ProductDao;



@Service
public class ProductService {
	
	@Autowired
	ProductDao proddao;
	
	public String saveProductInfo(Product prod)
	{
		return proddao.saveProductInfo(prod);
	}

	public Product addProduct(@RequestBody Product product,@PathVariable int cid)
	{
		return proddao.addProduct(product, cid);
		
	}
	
}
