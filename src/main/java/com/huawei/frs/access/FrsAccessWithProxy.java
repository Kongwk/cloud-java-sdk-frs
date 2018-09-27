package com.huawei.frs.access;

import com.huawei.frs.access.utils.HttpClientUtils;
import com.huawei.frs.common.AuthInfo;
import com.huawei.frs.common.ProxyHostInfo;
import okhttp3.OkHttpClient;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

public class FrsAccessWithProxy extends FrsAccess {

    /**
     * 代理的主机信息
     */
    private ProxyHostInfo proxyHostInfo = null;

    public FrsAccessWithProxy(AuthInfo authInfo, ProxyHostInfo hostInfo) {
        super(authInfo);
        proxyHostInfo = hostInfo;
    }

    public FrsAccessWithProxy(AuthInfo authInfo, ProxyHostInfo hostInfo, int connectionTimeout, int connectionRequestTimeout, int socketTimeout) {
        super(authInfo);
        proxyHostInfo = hostInfo;
        this.connectionTimeout = connectionTimeout;

    }


    @Override
    protected OkHttpClient getHttpClient()
            throws KeyManagementException, KeyStoreException, NoSuchAlgorithmException {
        return HttpClientUtils.acceptsUntrustedCertsHttpClient(true, proxyHostInfo, this.connectionTimeout);
    }

}
