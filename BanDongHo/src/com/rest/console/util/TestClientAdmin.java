package com.rest.console.util;

import java.util.HashMap;

import com.rest.utils.constants.GenericConstants;
import com.rest.utils.model.UserObject;

public class TestClientAdmin {

	public static void main(String[] args) {
		ClientAWSFactory factory = new ClientAWSFactory("http://localhost:8080/BanDongHo_WS/webapi");

		ClientAdminWS client = factory.getClient("user/login");
		HashMap<String, String> mapParams = new HashMap<String, String>();
		mapParams.put("username", "admin");
		mapParams.put("password", "admin");

		try {
			UserObject list = (UserObject) client.invokeAndReadEntity(mapParams, UserObject.class, GenericConstants.POST_METHOD);

			System.out.println("\n Result");
			System.out.println(list.toString());
			System.out.println("-------------------------------------------------------------------");

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("----- TEST END ------");
	}
}
