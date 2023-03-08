package com.RestApiDevProject2.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
	Integer cid;
	String cname;
	
	
	@OneToMany(targetEntity = Product.class,cascade = CascadeType.ALL)
	@JoinColumn(name="cid")
	List<Product> Products;


	public Category() {
		super();
	}


	public Category(Integer cid, String cname, List<Product> products) {
		super();
		this.cid = cid;
		this.cname = cname;
		Products = products;
	}


	public Integer getCid() {
		return cid;
	}


	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public List<Product> getProducts() {
		return Products;
	}


	public void setProducts(List<Product> products) {
		Products = products;
	}


	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + ", Products=" + Products + "]";
	}
	

}




