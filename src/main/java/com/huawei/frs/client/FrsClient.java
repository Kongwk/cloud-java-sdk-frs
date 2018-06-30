package com.huawei.frs.client;

import com.huawei.frs.access.FrsAccess;
import com.huawei.frs.access.FrsAccessWithProxy;
import com.huawei.frs.common.AuthInfo;
import com.huawei.frs.common.FrsConstant;
import com.huawei.frs.common.ProxyHostInfo;

public class FrsClient implements AutoCloseable {
    private AuthInfo authInfo;
    private ProxyHostInfo proxyHostInfo;
    private String projectId;
    private FrsAccess service;
    private DetectService detectService;
    private CompareService compareService;
    private SearchService searchService;
    private FaceService faceService;
    private FaceSetService faceSetService;

    private void initService() {
        this.detectService = new DetectService(this.service, this.projectId);
        this.compareService = new CompareService(this.service, this.projectId);
        this.searchService = new SearchService(this.service, this.projectId);
        this.faceService = new FaceService(this.service, this.projectId);
        this.faceSetService = new FaceSetService(this.service, this.projectId);
    }

    public FrsClient(String ak, String sk, String projectId) {
        this.authInfo = new AuthInfo(FrsConstant.getEndPoint(), FrsConstant.getRegion(), ak, sk);
        this.projectId = projectId;
        this.service = new FrsAccess(this.authInfo);
        this.initService();
    }

    public FrsClient(AuthInfo authInfo, String projectId) {
        this.authInfo = authInfo;
        this.projectId = projectId;
        this.service = new FrsAccess(this.authInfo);
        this.initService();
    }

    public FrsClient(String ak, String sk, String projectId, ProxyHostInfo proxyHostInfo) {
        this.authInfo = new AuthInfo(FrsConstant.getEndPoint(), FrsConstant.getRegion(), ak, sk);
        this.projectId = projectId;
        this.proxyHostInfo = proxyHostInfo;
        this.service = new FrsAccessWithProxy(this.authInfo, this.proxyHostInfo);
        this.initService();
    }

    public FrsClient(AuthInfo authInfo, String projectId, ProxyHostInfo proxyHostInfo) {
        this.authInfo = authInfo;
        this.projectId = projectId;
        this.proxyHostInfo = proxyHostInfo;
        this.service = new FrsAccessWithProxy(this.authInfo, this.proxyHostInfo);
        this.initService();
    }

    public FrsClient(String ak, String sk, String projectId, int connectionTimeout, int connectionRequestTimeout, int socketTimeout) {
        this.authInfo = new AuthInfo(FrsConstant.getEndPoint(), FrsConstant.getRegion(), ak, sk);
        this.projectId = projectId;
        this.service = new FrsAccess(this.authInfo, connectionTimeout, connectionRequestTimeout, socketTimeout);
        this.initService();
    }

    public FrsClient(AuthInfo authInfo, String projectId, int connectionTimeout, int connectionRequestTimeout, int socketTimeout) {
        this.authInfo = authInfo;
        this.projectId = projectId;
        this.service = new FrsAccess(this.authInfo, connectionTimeout, connectionRequestTimeout, socketTimeout);
        this.initService();
    }

    public FrsClient(String ak, String sk, String projectId, ProxyHostInfo proxyHostInfo, int connectionTimeout, int connectionRequestTimeout, int socketTimeout) {
        this.authInfo = new AuthInfo(FrsConstant.getEndPoint(), FrsConstant.getRegion(), ak, sk);
        this.projectId = projectId;
        this.proxyHostInfo = proxyHostInfo;
        this.service = new FrsAccessWithProxy(this.authInfo, this.proxyHostInfo, connectionTimeout, connectionRequestTimeout, socketTimeout);
        this.initService();
    }

    public FrsClient(AuthInfo authInfo, String projectId, ProxyHostInfo proxyHostInfo, int connectionTimeout, int connectionRequestTimeout, int socketTimeout) {
        this.authInfo = authInfo;
        this.projectId = projectId;
        this.proxyHostInfo = proxyHostInfo;
        this.service = new FrsAccessWithProxy(this.authInfo, this.proxyHostInfo, connectionTimeout, connectionRequestTimeout, socketTimeout);
        this.initService();
    }

    public DetectService getDetectService() {
        return this.detectService;
    }

    public CompareService getCompareService() {
        return this.compareService;
    }

    public SearchService getSearchService() {
        return this.searchService;
    }

    public FaceService getFaceService() {
        return this.faceService;
    }

    public FaceSetService getFaceSetService() {
        return this.faceSetService;
    }

    public void close() {
        try {
            this.service.close();
            System.out.println("Closed client connection");
        } catch (Exception var2) {
            var2.printStackTrace();
        }
    }

}
