package com.rest.utils.model.list;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.rest.utils.model.UserObject;

@XmlRootElement
public class UserObjectList {

	private List<UserObject> list;

	public UserObjectList() {
		super();
	}

	public UserObjectList(List<UserObject> list) {
		super();
		this.setList(list);
	}

	public List<UserObject> getList() {
		return list;
	}

	public void setList(List<UserObject> list) {
		this.list = list;
	}

}
