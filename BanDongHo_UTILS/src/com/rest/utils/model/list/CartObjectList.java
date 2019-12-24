package com.rest.utils.model.list;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.rest.utils.model.CartObject;

@XmlRootElement
public class CartObjectList {

	private List<CartObject> list;

	public CartObjectList() {
		super();
	}

	public CartObjectList(List<CartObject> list) {
		super();
		this.setList(list);
	}

	public List<CartObject> getList() {
		return list;
	}

	public void setList(List<CartObject> list) {
		this.list = list;
	}

}
