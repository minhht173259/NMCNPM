package com.rest.utils.model.list;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.rest.utils.model.ProductObject;

@XmlRootElement
public class ProductObjectList {

	private List<ProductObject> list;

	public ProductObjectList() {
		super();
	}

	public ProductObjectList(List<ProductObject> list) {
		super();
		this.setList(list);
	}

	public List<ProductObject> getList() {
		return list;
	}

	public void setList(List<ProductObject> list) {
		this.list = list;
	}

}
