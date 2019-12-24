package com.rest.console.util;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class ClientAWSFactory {

	private String _baseUrl = "http://localhost:8080/BanDongHo_WS/webapi";
	@SuppressWarnings("unused")
	private final String _authUser = "";
	@SuppressWarnings("unused")
	private final String _authPassword = "";

	public ClientAWSFactory() {

	}

	public ClientAWSFactory(String _baseUrl) {
		super();
		this._baseUrl = _baseUrl;

		HostnameVerifier hnv = new HostnameVerifier() {
			@Override
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		};
		HttpsURLConnection.setDefaultHostnameVerifier(hnv);
	}

	public ClientAdminWS getClient(String path) {
		ClientAdminWS client = new ClientAdminWS(this._baseUrl);
		client.setPath(path);
		return client;
	}

}
