package com.rest.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rest.utils.model.InvoiceObject;

public class InvoiceDAO {
	private static SQLconnection factory = new SQLconnection();

	public static String addInvoice(InvoiceObject invoice) throws ClassNotFoundException {
		String result = "KO";
		PreparedStatement preStmt = null;
		String sqlQuery = "Insert Into invoice(user_id, product_id, amount, total) values('" + invoice.getUserID() + "','" + invoice.getProduct().getId()
				+ "','" + invoice.getProduct().getAmount() + "','" + invoice.getTotal() + "')";
		try {
			preStmt = factory.getConnectionDB().prepareStatement(sqlQuery);
			preStmt.executeUpdate();
			preStmt.close();
			result = "OK";
		} catch (SQLException e) {
			System.out.print(e.toString());
		}
		return result;
	}
}
