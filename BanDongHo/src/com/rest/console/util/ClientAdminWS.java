package com.rest.console.util;

import java.util.HashMap;
import java.util.Set;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rest.utils.constants.GenericConstants;

public class ClientAdminWS {

	private Client _client;
	private final String _baseUrl;
	private WebTarget _webTarget;
	private WebTarget _resourceWebTarget;
	private Response _response;

	public ClientAdminWS(String _baseUrl) {
		super();
		this._baseUrl = _baseUrl;
		init();
	}

	private void init() {
		this._client = ClientBuilder.newClient();
		this._webTarget = this._client.target(_baseUrl);
	}

	public void setPath(String path) {
		this._resourceWebTarget = this._webTarget.path(path);
	}

	public Object invokeAndReadEntity(HashMap<String, String> mapParams, Class<?> clazz, String method) {
		Form form = new Form();

		Set<String> keys = mapParams.keySet();
		for (String keyCurr : keys) {
			form.param(keyCurr, mapParams.get(keyCurr));
		}
		switch (method) {
		case GenericConstants.PUT_METHOD:
			this._response = this._resourceWebTarget.request().put(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED));
			break;
		case GenericConstants.POST_METHOD:
			this._response = this._resourceWebTarget.request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED));
			break;
		case GenericConstants.DELETE_METHOD:
			break;
		case GenericConstants.GET_METHOD:
			break;
		}
		int statusCode = this._response.getStatus();
		Object result = null;
		if (statusCode == Response.Status.OK.getStatusCode()) {
			this._response.bufferEntity();
			result = this._response.readEntity(clazz);
		} else {
			try {
				result = this._response.readEntity(Exception.class);
			} catch (Exception e) {
			}
		}
		return result;
	}

	public Object invokeAndReadEntityWithParamObject(Object param, Class<?> clazz, String method) {

		switch (method) {
		case GenericConstants.PUT_METHOD:
			this._response = this._resourceWebTarget.request().put(Entity.entity(param, MediaType.APPLICATION_XML));
			break;
		case GenericConstants.POST_METHOD:
			this._response = this._resourceWebTarget.request().post(Entity.entity(param, MediaType.APPLICATION_XML));
			break;
		case GenericConstants.DELETE_METHOD:
			
			break;
		case GenericConstants.GET_METHOD:
			break;
		}

		int statusCode = this._response.getStatus();
		Object result = null;
		if (statusCode == Response.Status.OK.getStatusCode()) {
			result = this._response.readEntity(clazz);
		} else {
			try {
				result = this._response.readEntity(Exception.class);
			} catch (Exception e) {
			}
		}

		return result;
	}
}
