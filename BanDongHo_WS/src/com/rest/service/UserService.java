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

import com.rest.dao.UserDAO;
import com.rest.utils.model.UserObject;
import com.rest.utils.model.list.UserObjectList;

@Path("/user")
public class UserService {
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(@FormParam("username") String username, @FormParam("password") String password) {
		String method = "login()";
		System.out.println("Start: " + method + " -----------------------------");
		
		UserObject result = null;
		try {
			result = UserDAO.login(username, password);
		} catch (ClassNotFoundException ce) {
			System.out.println("Error: " + method + " -----------------------------");
			return Response.ok(ce).build();
		}
		
		System.out.println("End: " + method + " -----------------------------");
		return Response.ok(result).build();
	}

	@POST
	@Path("updateUser")
	@Consumes("application/xml")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUser(UserObject user) {
		String method = "updateUser()";
		System.out.println("Start: " + method + " -----------------------------");
		
		String result = "KO";
		try {
			result = UserDAO.updateUser(user);
		} catch (Exception e) {
			return Response.ok(e).build();
		}
		
		System.out.println("End: " + method + " -----------------------------");
		return Response.ok(result).build();
	}

	@POST
	@Path("/deleteUser")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUser(@FormParam("id") String id) {
		String method = "deleteUser()";
		System.out.println("Start: " + method + " -----------------------------");
		
		String result = "KO";
		try {
			result = UserDAO.deleteUser(id);
		} catch (Exception e) {
			System.out.println("Error: " + method + " -----------------------------");
			return Response.ok(e).build();
		}
		
		System.out.println("End: " + method + " -----------------------------");
		return Response.ok(result).build();
	}

	@POST
	@Path("/getNumberUserByName")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNumberUserByName(@FormParam("name") String name) {
		String method = "getNumberUserByName()";
		System.out.println("Start: " + method + " -----------------------------");
		
		int result;
		try {
			result = UserDAO.getNumberUserByName(name);
		} catch (ClassNotFoundException ce) {
			System.out.println("Error: " + method + " -----------------------------");
			return Response.ok(ce).build();
		}
		
		System.out.println("End: " + method + " -----------------------------");
		return Response.ok(String.valueOf(result)).build();
	}

	@Path("insertUser")
	@PUT
	@Consumes("application/xml")
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertUser(UserObject user) {
		String method = "insertUser()";
		System.out.println("Start: " + method + " -----------------------------");
		
		int result;
		try {
			result = UserDAO.insertUser(user);
		} catch (Exception e) {
			System.out.println("Error: " + method + " -----------------------------");
			return Response.ok(e).build();
		}
		
		System.out.println("End: " + method + " -----------------------------");
		return Response.ok(String.valueOf(result)).build();
	}

	@POST
	@Path("getListAllUser")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListAllUser() {
		String method = "getListAllUser()";
		System.out.println("Start: " + method + " -----------------------------");
		
		UserObjectList list = new UserObjectList();
		try {
			List<UserObject> reslist = UserDAO.getListAllUser();
			list.setList(reslist);
		} catch (Exception e) {
			System.out.println("Error: " + method + " -----------------------------");
			return Response.ok(e).build();
		}
		
		System.out.println("End: " + method + " -----------------------------");
		return Response.ok(list).build();
	}

	@POST
	@Path("getAllPage")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllPage(@FormParam("start") int start, @FormParam("display") int display) {
		String method = "getAllPage()";
		System.out.println("Start: " + method + " -----------------------------");
		
		UserObjectList list = new UserObjectList();
		try {
			List<UserObject> reslist = UserDAO.getAllPage(start, display);
			list.setList(reslist);
		} catch (Exception e) {
			System.out.println("Error: " + method + " -----------------------------");
			return Response.ok(e).build();
		}
		
		System.out.println("End: " + method + " -----------------------------");
		return Response.ok(list).build();
	}

}
