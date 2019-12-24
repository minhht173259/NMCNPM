package com.rest.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rest.dao.ProductDAO;
import com.rest.utils.model.ProductObject;
import com.rest.utils.model.list.ProductObjectList;

@Path("product")
public class ProductService {
	@POST
	@Path("/deleteProductByID")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteProductById(@FormParam("id") String id) {
		String method = "deleteProductByID()";
		System.out.println("Start: " + method + " -----------------------------");
		
		String result;
		try {
			result = ProductDAO.deleteProductById(id);
		} catch (ClassNotFoundException ce) {
			System.out.println("Error: " + method + " -----------------------------");
			return Response.ok(ce).build();
		}
		
		System.out.println("End: " + method + " -----------------------------");
		return Response.ok(result).build();
	}

	@Path("updateProduct")
	@POST
	@Consumes("application/xml")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateProduct(ProductObject product) {
		String method = "updateProduct()";
		System.out.println("Start: " + method + " -----------------------------");
		
		String result = "KO";
		try {
			result = ProductDAO.updateProduct(product);
		} catch (Exception e) {
			System.out.println("Error: " + method + " -----------------------------");
			return Response.ok(e).build();
		}

		System.out.println("End: " + method + " -----------------------------");
		return Response.ok(result).build();
	}

	@POST
	@Path("/getNumberProductByName")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNumberProductByName(@FormParam("name") String name) {
		String method = "getNumberProductByName()";
		System.out.println("Start: " + method + " -----------------------------");
		
		int result;
		try {
			result = ProductDAO.getNumberProductByName(name);
		} catch (ClassNotFoundException ce) {
			System.out.println("Error: " + method + " -----------------------------");
			return Response.ok(ce).build();
		}
		
		System.out.println("End: " + method + " -----------------------------");
		return Response.ok(String.valueOf(result)).build();
	}

	@Path("insertProduct")
	@PUT
	@Consumes("application/xml")
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertProduct(ProductObject product) {
		String method = "insertProduct()";
		System.out.println("Start: " + method + " -----------------------------");
		
		String result = "KO";
		try {
			result = ProductDAO.insertProduct(product);
		} catch (Exception e) {
			System.out.println("Error: " + method + " -----------------------------");
			return Response.ok(e).build();
		}

		System.out.println("End: " + method + " -----------------------------");
		return Response.ok(result).build();
	}

	@POST
	@Path("getAllProudctPage")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllProudctPage(@FormParam("brand") String brand, @FormParam("start") int start, @FormParam("display") int display) {
		String method = "getAllProudctPage()";
		System.out.println("Start: " + method + " -----------------------------");
		
		ProductObjectList list = new ProductObjectList();
		try {
			List<ProductObject> reslist = ProductDAO.getAllProudctPage(brand, start, display);
			list.setList(reslist);
		} catch (Exception e) {
			System.out.println("Error: " + method + " -----------------------------");
			return Response.ok(e).build();
		}
		
		System.out.println("End: " + method + " -----------------------------");
		return Response.ok(list).build();
	}

	@POST
	@Path("getDetailProductById")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetailProductById(@FormParam("id") String id) {
		String method = "getDetailProductById()";
		System.out.println("Start: " + method + " -----------------------------");
		
		ProductObject result = new ProductObject();
		try {
			result = ProductDAO.getDetailProductById(id);
		} catch (Exception e) {
			System.out.println("Error: " + method + " -----------------------------");
			return Response.ok(e).build();
		}
		
		System.out.println("End: " + method + " -----------------------------");
		return Response.ok(result).build();
	}

	@POST
	@Path("/getTotalAllByBrand")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTotalAllByBrand(@FormParam("brand") String brand) {
		String method = "getTotalAllByBrand()";
		System.out.println("Start: " + method + " -----------------------------");
		
		int result;
		try {
			result = ProductDAO.getTotalAllByBrand(brand);
		} catch (ClassNotFoundException ce) {
			System.out.println("Error: " + method + " -----------------------------");
			return Response.ok(ce).build();
		}
		
		System.out.println("End: " + method + " -----------------------------");
		return Response.ok(String.valueOf(result)).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("getListProductByBrand")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListProductByBrand(@FormParam("brand") String brand) {
		String method = "getListProductByBrand()";
		System.out.println("Start: " + method + " -----------------------------");
		
		ProductObjectList list = new ProductObjectList();
		try {
			List<ProductObject> reslist = ProductDAO.getListProductByBrand(brand);
			list.setList(reslist);
		} catch (Exception e) {
			System.out.println("Error: " + method + " -----------------------------");
			return Response.ok(e).build();
		}
		
		System.out.println("End: " + method + " -----------------------------");
		return Response.ok(list).build();
	}

	@POST
	@Path("getListAllProduct")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListAllProduct() {
		String method = "getListAllProduct()";
		System.out.println("Start: " + method + " -----------------------------");
		
		ProductObjectList list = new ProductObjectList();
		try {
			List<ProductObject> reslist = ProductDAO.getListAllProduct();
			list.setList(reslist);
		} catch (Exception e) {
			System.out.println("Error: " + method + " -----------------------------");
			return Response.ok(e).build();
		}
		
		System.out.println("End: " + method + " -----------------------------");
		return Response.ok(list).build();
	}

	@POST
	@Path("/getTotalAll")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTotalAll() {
		String method = "getTotalAll()";
		System.out.println("Start: " + method + " -----------------------------");
		
		int result;
		try {
			result = ProductDAO.getTotalAll();
		} catch (ClassNotFoundException ce) {
			System.out.println("Error: " + method + " -----------------------------");
			return Response.ok(ce).build();
		}
		
		System.out.println("End: " + method + " -----------------------------");
		return Response.ok(String.valueOf(result)).build();
	}

}
