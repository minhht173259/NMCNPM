package com.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rest.dao.InvoiceDAO;
import com.rest.utils.model.InvoiceObject;

@Path("invoice")
public class InvoiceService {

	@Path("addInvoice")
	@PUT
	@Consumes("application/xml")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addInvoice(InvoiceObject invoice) {
		String method = "addInvoice()";
		System.out.println("Start: " + method + " -----------------------------");
		
		String result = "KO";
		try {
			result = InvoiceDAO.addInvoice(invoice);
		} catch (Exception e) {
			System.out.println("Error: " + method + " -----------------------------");
			return Response.ok(e).build();
		}
	
		System.out.println("End: " + method + " -----------------------------");
		return Response.ok(result).build();
	}
	
}
