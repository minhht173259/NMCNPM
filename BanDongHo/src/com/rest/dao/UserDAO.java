package com.rest.dao;

import java.util.HashMap;
import java.util.List;

import com.rest.console.util.ClientAWSFactory;
import com.rest.console.util.ClientAdminWS;
import com.rest.utils.constants.GenericConstants;
import com.rest.utils.model.UserObject;
import com.rest.utils.model.list.UserObjectList;

public class UserDAO {
	static ClientAWSFactory factory = new ClientAWSFactory();

	public static UserObject login(String username, String password) {
		ClientAdminWS client = factory.getClient("user/login");
		HashMap<String, String> mapParams = new HashMap<String, String>();
		mapParams.put("username", username);
		mapParams.put("password", password);
		UserObject user = (UserObject) client.invokeAndReadEntity(mapParams, UserObject.class, GenericConstants.POST_METHOD);
		return user;
	}

	public static String deleteUser(String id) {
		ClientAdminWS client = factory.getClient("user/deleteUser");
		String result = "KO";
		HashMap<String, String> mapParams = new HashMap<String, String>();
		mapParams.put("id", id);
		result = (String) client.invokeAndReadEntity(mapParams, String.class, GenericConstants.DELETE_METHOD);
		return result;
	}

	public static int getNumberUserByName(String name) {
		ClientAdminWS client = factory.getClient("user/getNumberUserByName");
		HashMap<String, String> mapParams = new HashMap<String, String>();
		mapParams.put("name", name);
		String result = (String) client.invokeAndReadEntity(mapParams, String.class, GenericConstants.POST_METHOD);
		return Integer.valueOf(result);
	}

	public static int insertUser(UserObject user) {
		ClientAdminWS client = factory.getClient("user/insertUser");
		String result = (String) client.invokeAndReadEntityWithParamObject(user, String.class, GenericConstants.PUT_METHOD);
		return Integer.valueOf(result);
	}

	public static String updateUser(UserObject user) {
		ClientAdminWS client = factory.getClient("user/updateUser");
		String result = "KO";
		result = (String) client.invokeAndReadEntityWithParamObject(user, String.class, GenericConstants.POST_METHOD);
		return result;
	}

	public static List<UserObject> getListAllUser() {
		ClientAdminWS client = factory.getClient("user/getListAllUser");
		HashMap<String, String> mapParams = new HashMap<String, String>();
		UserObjectList list = (UserObjectList) client.invokeAndReadEntity(mapParams, UserObjectList.class, GenericConstants.POST_METHOD);
		return list.getList();
	}

	public static List<UserObject> getAllPage(int start, int display) {
		ClientAdminWS client = factory.getClient("user/getAllPage");
		HashMap<String, String> mapParams = new HashMap<String, String>();
		mapParams.put("start", String.valueOf(start));
		mapParams.put("display", String.valueOf(display));

		UserObjectList list = (UserObjectList) client.invokeAndReadEntity(mapParams, UserObjectList.class, GenericConstants.POST_METHOD);
		return list.getList();
	}

}
