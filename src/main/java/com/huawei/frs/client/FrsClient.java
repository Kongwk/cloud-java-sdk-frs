package com.huawei.frs.client;

import com.huawei.frs.common.FrsConstant;
import com.huawei.frs.common.ProxyHostInfo;
import com.huawei.frs.access.FrsAccess;
import com.huawei.frs.access.FrsAccessWithProxy;
import com.huawei.frs.common.AuthInfo;

public class FrsClient implements AutoCloseable {
    private AuthInfo authInfo;
    private String projectId;
    private FrsAccess service;
    private DetectService detectService;
    private CompareService compareService;
    private SearchService searchService;
    private FaceService faceService;
    private FaceSetService faceSetService;
    private LiveDetectService liveDetectService;
    private QualityService qualityService;

    private void initService() {
        this.detectService = new DetectService(this.service, this.projectId);
        this.compareService = new CompareService(this.service, this.projectId);
        this.searchService = new SearchService(this.service, this.projectId);
        this.faceService = new FaceService(this.service, this.projectId);
        this.faceSetService = new FaceSetService(this.service, this.projectId);
        this.liveDetectService = new LiveDetectService(this.service, this.projectId);
        this.qualityService = new QualityService(this.service, this.projectId);
    }

    public FrsClient(String ak, String sk, String projectId) {
        this.init(new AuthInfo(FrsConstant.getEndPoint(), FrsConstant.getRegion(), ak, sk), projectId, null);
    }

    public FrsClient(AuthInfo authInfo, String projectId) {
        this.init(authInfo, projectId, null);
    }

    public FrsClient(String ak, String sk, String projectId, ProxyHostInfo proxyHostInfo) {
        this.init(new AuthInfo(FrsConstant.getEndPoint(), FrsConstant.getRegion(), ak, sk), projectId, proxyHostInfo);
    }

    public FrsClient(AuthInfo authInfo, String projectId, ProxyHostInfo proxyHostInfo) {
        this.init(authInfo, projectId, proxyHostInfo);
    }

    public FrsClient(String ak, String sk, String projectId, int connectionTimeout, int connectionRequestTimeout, int socketTimeout) {
        this.init(new AuthInfo(FrsConstant.getEndPoint(), FrsConstant.getRegion(), ak, sk), projectId, null, connectionTimeout, connectionRequestTimeout, socketTimeout);
    }

    public FrsClient(AuthInfo authInfo, String projectId, int connectionTimeout, int connectionRequestTimeout, int socketTimeout) {
        this.init(authInfo, projectId, null, connectionTimeout, connectionRequestTimeout, socketTimeout);
    }

    public FrsClient(String ak, String sk, String projectId, ProxyHostInfo proxyHostInfo, int connectionTimeout, int connectionRequestTimeout, int socketTimeout) {
        this.init(new AuthInfo(FrsConstant.getEndPoint(), FrsConstant.getRegion(), ak, sk), projectId, proxyHostInfo, connectionTimeout, connectionRequestTimeout, socketTimeout);
    }

    public FrsClient(AuthInfo authInfo, String projectId, ProxyHostInfo proxyHostInfo, int connectionTimeout, int connectionRequestTimeout, int socketTimeout) {
        this.init(authInfo, projectId, proxyHostInfo, connectionTimeout, connectionRequestTimeout, socketTimeout);
    }

    private void init(AuthInfo authInfo, String projectId, ProxyHostInfo proxyHostInfo) {
        this.authInfo = authInfo;
        this.projectId = projectId;
        if (null == proxyHostInfo) {
            this.service = new FrsAccess(this.authInfo);
        } else {
            this.service = new FrsAccessWithProxy(this.authInfo, proxyHostInfo);
        }
        this.initService();
    }

    private void init(AuthInfo authInfo, String projectId, ProxyHostInfo proxyHostInfo, int connectionTimeout, int connectionRequestTimeout, int socketTimeout) {
        this.authInfo = authInfo;
        this.projectId = projectId;
        if (null == proxyHostInfo) {
            this.service = new FrsAccess(this.authInfo, connectionTimeout, connectionRequestTimeout, socketTimeout);
        } else {
            this.service = new FrsAccessWithProxy(this.authInfo, proxyHostInfo, connectionTimeout, connectionRequestTimeout, socketTimeout);
        }
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

    public LiveDetectService getLiveDetectService() {
        return this.liveDetectService;
    }

    public QualityService getQualityService() {
        return this.qualityService;
    }

    @Override
    public void close() throws Exception {

    }
}
