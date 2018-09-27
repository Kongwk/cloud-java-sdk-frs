package com.huawei.frs.access;


import com.huawei.frs.common.AuthInfo;
import com.huawei.frs.common.ProxyHostInfo;

public class FrsAccessClient {

    /**
     * 单例对象
     */
    private static FrsAccessClient instance = new FrsAccessClient();

    /**
     * 是否通过proxy访问
     */
    private boolean accessWithProxy = false;

    /**
     * 代理的主机信息
     */
    private ProxyHostInfo proxyHostInfo = null;

    /**
     * 基本的认证信息
     */
    private AuthInfo authInfo = null;

    /**
     * 获得单例对象
     *
     * @return FrsAccessClient instance
     */
    public static FrsAccessClient getInstance() {
        return instance;
    }

    public void init(AuthInfo authInfo) {
        this.authInfo = authInfo;
    }

    public FrsAccess getAccessService(AuthInfo inAuthInfo) {
        return accessWithProxy ? new FrsAccessWithProxy(inAuthInfo, proxyHostInfo) : new FrsAccess(inAuthInfo);
    }

    public FrsAccess getAccessService() {
        return accessWithProxy ? new FrsAccessWithProxy(authInfo, proxyHostInfo) : new FrsAccess(authInfo);
    }

    public FrsAccessClient setAccessWithProxy(boolean accessWithProxy) {
        this.accessWithProxy = accessWithProxy;
        return this;
    }

    public FrsAccessClient setProxyHostInfo(ProxyHostInfo proxyHostInfo) {
        this.proxyHostInfo = proxyHostInfo;
        return this;
    }
}
