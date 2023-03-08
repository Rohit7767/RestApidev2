package com.RestApiDevProject2.MobService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestApiDevProject2.Entity.Category;
import com.RestApiDevProject2.MDao.CategoryDao;


@Service
public class CategoryService {

	@Autowired
	CategoryDao catdao;

	public Category saveCategory(Category categ) {
		return catdao.saveCategory(categ);
	}

	public Category getCategory(int cid) {
		return catdao.getCategory(cid);

	}
	
	public Category getCategory1(int cid) {
		return catdao.getCategory1(cid);

	}
	

	public Category updateCategory(Category cate) {
		return catdao.updateCategory(cate);
	}

	public Category deleteCategory(int cid) {
		return catdao.deleteCategory(cid);
	}
	
	public List<Category> getAllCategory() {
		return catdao.getAllCategory();

	}
	

}
