package com.rest.utils.model.list;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.rest.utils.model.InvoiceObject;

@XmlRootElement
public class InvoiceObjectList {

	private List<InvoiceObject> list;

	public InvoiceObjectList() {
		super();
	}

	public InvoiceObjectList(List<InvoiceObject> list) {
		super();
		this.setList(list);
	}

	public List<InvoiceObject> getList() {
		return list;
	}

	public void setList(List<InvoiceObject> list) {
		this.list = list;
	}

}
