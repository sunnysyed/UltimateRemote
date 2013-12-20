package com.SuNnY.ultimateremote;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class EpgConnecter {
 
    private static final String BASE_URL = "http://api.rovicorp.com/TVlistings/v9/listings/";
    private static AsyncHttpClient client = new AsyncHttpClient();
 
    public static void get(String url, RequestParams params,
            AsyncHttpResponseHandler responseHandler) {
    	client.setTimeout(1000000);
    	Log.d("LOG", getAbsoluteUrl(url)+params.toString());
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }
 
    public static void post(String url, RequestParams params,
            AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }
 
    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}