package com.msdk.android.app.core.http;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

//LoaderManager look at
public class HttpRequestRunnable implements Runnable {
	
	private URL url;
	private HttpRequest httpRequest;
	private String requestType;
	private HashMap<String, String> httpPostParams;
 
	public HttpRequestRunnable(String urlString, String requestType, HttpRequestDelegate delegate){
		
		try {
			this.url = new URL(urlString);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		this.requestType = requestType;
		httpRequest = new HttpRequest();
		httpRequest.setDelegate(delegate);
	}
	
	public void setPostParams(HashMap<String, String> httpPostParams){
		this.httpPostParams = httpPostParams;
	}

	@Override
	public void run() {
		if(requestType != null && requestType == "POST"){
			httpRequest.post(url, httpPostParams);
		}else{
			httpRequest.get(url);
		}
		
	}
	
}
