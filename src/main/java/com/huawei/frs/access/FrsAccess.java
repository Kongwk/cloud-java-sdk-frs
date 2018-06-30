package com.huawei.frs.access;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;

import com.cloud.sdk.http.HttpMethodName;
import com.huawei.frs.access.auth.AccessServiceImpl;
import com.huawei.frs.common.AuthInfo;
import com.huawei.frs.access.utils.HttpClientUtils;

public class FrsAccess extends AccessServiceImpl{

	/**
	 * 服务名
	 */
	private static final String SERVICE_NAME = "frs";
		
	public int connectionTimeout = HttpClientUtils.DEFAULT_CONNECTION_TIMEOUT;
	public int connectionRequestTimeout = HttpClientUtils.DEFAULT_CONNECTION_REQUEST_TIMEOUT;
	public int socketTimeout =  HttpClientUtils.DEFAULT_SOCKET_TIMEOUT;
	
	
	public FrsAccess(AuthInfo authInfo) {
		super(FrsAccess.SERVICE_NAME, authInfo.getRegion(), authInfo.getAk(), authInfo.getSk());
		this.authInfo = authInfo;
	}
	
	public FrsAccess(AuthInfo authInfo, int connectionTimeout, int connectionRequestTimeout, int socketTimeout) {
		super(FrsAccess.SERVICE_NAME, authInfo.getRegion(), authInfo.getAk(), authInfo.getSk());
		this.authInfo = authInfo;
		
		this.connectionTimeout = connectionTimeout;
		this.connectionRequestTimeout = connectionRequestTimeout;
		this.socketTimeout = socketTimeout;
		
	}
	
	/**
	 * 基本的认证信息
	 */
	private AuthInfo authInfo = null;

	@Override
	protected CloseableHttpClient getHttpClient()
			throws KeyManagementException, KeyStoreException, NoSuchAlgorithmException {
		return HttpClientUtils.acceptsUntrustedCertsHttpClient(false, null, this.connectionTimeout, this.connectionRequestTimeout, this.socketTimeout);
	}

	protected boolean useDefaultHttpClient()
	{
		return false;
	}

	public HttpResponse put(String requestUrl, String putBody) {

		HttpResponse response = null;
		try {
			URL url = new URL(generateWholeUrl(authInfo.getEndPoint(), requestUrl));
			HttpMethodName httpMethod = HttpMethodName.PUT;

			InputStream content = new ByteArrayInputStream(putBody.getBytes());
			response = access(url, content, (long) putBody.getBytes().length, httpMethod);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return response;
	}

	public HttpResponse get(String requestUrl) {

		HttpResponse response = null;
		try {
			URL url = new URL(generateWholeUrl(authInfo.getEndPoint(), requestUrl));
			HttpMethodName httpMethod = HttpMethodName.GET;
			response = access(url, httpMethod);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return response;
	}

	public HttpResponse post(String requestUrl, String postbody) {

		URL url = null;
		try {
			url = new URL(generateWholeUrl(authInfo.getEndPoint(), requestUrl));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		InputStream content = new ByteArrayInputStream(postbody.getBytes());
		HttpMethodName httpMethod = HttpMethodName.POST;
		HttpResponse response = null;

		Map<String, String> header = new HashMap<>();
		header.put("Content-Type", ContentType.APPLICATION_JSON.toString());
		try {
			response = access(url, header, content, (long) postbody.getBytes().length, httpMethod);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return response;
	}

	public HttpResponse post(String requestUrl, HttpEntity entity) {

		URL url = null;
		try {
			url = new URL(generateWholeUrl(authInfo.getEndPoint(), requestUrl));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		HttpMethodName httpMethod = HttpMethodName.POST;
		HttpResponse response = null;

		Map<String, String> header = new HashMap<>();
		header.put("Content-Type", ContentType.APPLICATION_JSON.toString());
		try {
			response = accessEntity(url, header, entity, (long) entity.getContentLength(), httpMethod);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return response;
	}

	public HttpResponse delete(String requestUrl) {
		HttpResponse response = null;

		try {
			URL url = new URL(generateWholeUrl(this.authInfo.getEndPoint(), requestUrl));
			HttpMethodName httpMethod = HttpMethodName.DELETE;
			Map<String, String> header = new HashMap<>();
			header.put("Content-Type", ContentType.APPLICATION_JSON.toString());
			response = this.access(url, header, httpMethod);
			return response;
		} catch (Exception var6) {
			var6.printStackTrace();
			return null;
		}
	}
	
	//
	// Generate the whole url for the specific ais service
	//
	private static String generateWholeUrl(String endPoint, String uri) {
		return String.format("%s%s", endPoint, uri);
	}

}
