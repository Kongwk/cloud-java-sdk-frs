package com.huawei.frs.access;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import org.apache.http.impl.client.CloseableHttpClient;

import com.huawei.frs.common.AuthInfo;
import com.huawei.frs.common.ProxyHostInfo;
import com.huawei.frs.access.utils.HttpClientUtils;

public class FrsAccessWithProxy extends FrsAccess{

	/**
	 * 代理的主机信息
	 */
	private ProxyHostInfo proxyHostInfo = null;
	
	public FrsAccessWithProxy(AuthInfo authInfo, ProxyHostInfo hostInfo) {
		super(authInfo);
		proxyHostInfo = hostInfo;
	}
	
	public FrsAccessWithProxy(AuthInfo authInfo, ProxyHostInfo hostInfo, int connectionTimeout, int connectionRequestTimeout, int socketTimeout ) {
		super(authInfo);
		proxyHostInfo = hostInfo;
		this.connectionTimeout = connectionTimeout;
		this.connectionRequestTimeout = connectionRequestTimeout;
		this.socketTimeout = socketTimeout;
		
	}
	
	
	@Override
	protected CloseableHttpClient getHttpClient()
			throws KeyManagementException, KeyStoreException, NoSuchAlgorithmException {
		return HttpClientUtils.acceptsUntrustedCertsHttpClient(true, proxyHostInfo, this.connectionTimeout, this.connectionRequestTimeout, this.socketTimeout);
	}

}
