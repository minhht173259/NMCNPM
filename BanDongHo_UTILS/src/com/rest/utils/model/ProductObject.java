package com.rest.utils.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductObject {
	private int id;
	private String name;
	private int price;
	private String image;
	private String brand;
	private String origin;
	private String detail;
	private int amount;

	public ProductObject() {
		this.id = 0;
		this.image = null;
		this.detail = null;
		this.name = null;
		this.origin = null;
		this.brand = null;
		this.price = 0;
		this.amount = 1;
	}

	public ProductObject(int id, String name, int price, String image, String brand, String origin, String detail) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.image = image;
		this.brand = brand;
		this.origin = origin;
		this.detail = detail;
		this.amount = 1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}