package com.rest.dao;

import com.rest.console.util.ClientAWSFactory;
import com.rest.console.util.ClientAdminWS;
import com.rest.utils.constants.GenericConstants;
import com.rest.utils.model.InvoiceObject;

public class InvoiceDAO {
	static ClientAWSFactory factory = new ClientAWSFactory();

	public static String addInvoice(InvoiceObject invoice) {
		ClientAdminWS client = factory.getClient("invoice/addInvoice");
		String result = "KO";
		result = (String) client.invokeAndReadEntityWithParamObject(invoice, String.class, GenericConstants.PUT_METHOD);
		return result;
	}
}
