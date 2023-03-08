package com.RestApiDevProject2.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	
	
	@Id
	Integer prodid;
	String prodname;
	Integer prodprice;
	Integer cid;
	
	
	public Product() {
	
	}


	public Product(Integer prodid, String prodname, Integer prodprice, Integer cid) {
		super();
		this.prodid = prodid;
		this.prodname = prodname;
		this.prodprice = prodprice;
		this.cid = cid;
	}


	public Integer getProdid() {
		return prodid;
	}


	public void setProdid(Integer prodid) {
		this.prodid = prodid;
	}


	public String getProdname() {
		return prodname;
	}


	public void setProdname(String prodname) {
		this.prodname = prodname;
	}


	public Integer getProdprice() {
		return prodprice;
	}


	public void setProdprice(Integer prodprice) {
		this.prodprice = prodprice;
	}


	public Integer getCid() {
		return cid;
	}


	public void setCid(Integer cid) {
		this.cid = cid;
	}


	@Override
	public String toString() {
		return "Product [prodid=" + prodid + ", prodname=" + prodname + ", prodprice=" + prodprice + ", cid=" + cid
				+ "]";
	}










	



	
	
	



}
