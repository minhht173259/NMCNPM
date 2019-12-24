package com.rest.dao;

import java.util.HashMap;
import java.util.List;

import com.rest.console.util.ClientAWSFactory;
import com.rest.console.util.ClientAdminWS;
import com.rest.utils.constants.GenericConstants;
import com.rest.utils.model.ProductObject;
import com.rest.utils.model.list.ProductObjectList;

public class ProductDAO {
	static ClientAWSFactory factory = new ClientAWSFactory();

	public static String deleteProductByID(String id) {
		ClientAdminWS client = factory.getClient("product/deleteProductByID");
		String result = "KO";
		HashMap<String, String> mapParams = new HashMap<String, String>();
		mapParams.put("id", id);
		result = (String) client.invokeAndReadEntity(mapParams, String.class, GenericConstants.POST_METHOD);
		return result;
	}

	public static String updateProduct(ProductObject product) {
		ClientAdminWS client = factory.getClient("product/updateProduct");
		String result = "KO";
		result = (String) client.invokeAndReadEntityWithParamObject(product, String.class, GenericConstants.POST_METHOD);
		return result;
	}

	public static int getNumberProductByName(String name) {
		ClientAdminWS client = factory.getClient("product/getNumberProductByName");
		HashMap<String, String> mapParams = new HashMap<String, String>();
		mapParams.put("name", name);
		String result = (String) client.invokeAndReadEntity(mapParams, String.class, GenericConstants.POST_METHOD);
		return Integer.valueOf(result);
	}

	public static String insertProduct(ProductObject product) {
		ClientAdminWS client = factory.getClient("product/insertProduct");
		String result = "KO";
		result = (String) client.invokeAndReadEntityWithParamObject(product, String.class, GenericConstants.PUT_METHOD);
		return result;
	}

	public static List<ProductObject> getAllProudctPage(String brand, int start, int display) {
		ClientAdminWS client = factory.getClient("product/getAllProudctPage");
		HashMap<String, String> mapParams = new HashMap<String, String>();
		mapParams.put("brand", brand);
		mapParams.put("start", String.valueOf(start));
		mapParams.put("display", String.valueOf(display));

		ProductObjectList list = (ProductObjectList) client.invokeAndReadEntity(mapParams, ProductObjectList.class, GenericConstants.POST_METHOD);
		return list.getList();
	}

	public static ProductObject getDetailProductById(String id) {
		ClientAdminWS client = factory.getClient("product/getDetailProductById");
		HashMap<String, String> mapParams = new HashMap<String, String>();
		mapParams.put("id", id);

		ProductObject list = (ProductObject) client.invokeAndReadEntity(mapParams, ProductObject.class, GenericConstants.POST_METHOD);
		return list;
	}

	public static int getTotalAllByBrand(String brand) {
		ClientAdminWS client = factory.getClient("product/getTotalAllByBrand");
		HashMap<String, String> mapParams = new HashMap<String, String>();
		mapParams.put("brand", brand);
		String resultStr = (String) client.invokeAndReadEntity(mapParams, String.class, GenericConstants.POST_METHOD);
		return Integer.valueOf(resultStr);
	}

	public static List<ProductObject> getListProductByBrand(String brand) {
		ClientAdminWS client = factory.getClient("product/getListProductByBrand");
		HashMap<String, String> mapParams = new HashMap<String, String>();
		mapParams.put("brand", brand);

		ProductObjectList list = (ProductObjectList) client.invokeAndReadEntity(mapParams, ProductObjectList.class, GenericConstants.POST_METHOD);
		return list.getList();
	}

	public static List<ProductObject> getListAllProduct() {
		ClientAdminWS client = factory.getClient("product/getListAllProduct");
		HashMap<String, String> mapParams = new HashMap<String, String>();

		ProductObjectList list = (ProductObjectList) client.invokeAndReadEntity(mapParams, ProductObjectList.class, GenericConstants.POST_METHOD);
		return list.getList();
	}

	public static int getTotalAll() {
		ClientAdminWS client = factory.getClient("product/getTotalAll");
		HashMap<String, String> mapParams = new HashMap<String, String>();
		String result = (String) client.invokeAndReadEntity(mapParams, String.class, GenericConstants.POST_METHOD);
		return Integer.valueOf(result);
	}

}
