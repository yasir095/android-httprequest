package com.msdk.android.app.core.http;


public interface HttpRequestDelegate {
	public void onCompleteHttpRequest(String result);
	public void onFailHttpRequest(com.msdk.android.app.core.model.Error e);
	public void onProgressHttpRequest(int progress);
}
