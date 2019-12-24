package com.rest.utils.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author NMCNPM
 */
@XmlRootElement
public class InvoiceObject {
	private int id;
	private int userID;
	private ProductObject product;
	private int total;

	public InvoiceObject() {
	}

	public InvoiceObject(int userID, ProductObject sp) {
		this.userID = userID;
		this.product = sp;
		this.total = this.product.getPrice() * this.product.getAmount();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ProductObject getProduct() {
		return product;
	}

	public void setProduct(ProductObject sp) {
		this.product = sp;
	}

	public int getTotal() {
		this.total = this.product.getPrice() * this.product.getAmount();
		return total;
	}

	public void setTotal(ProductObject sp) {
		this.total = this.product.getPrice() * this.product.getAmount();
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

}
