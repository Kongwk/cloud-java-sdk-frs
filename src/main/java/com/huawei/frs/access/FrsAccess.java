package com.huawei.frs.access;

import com.cloud.sdk.http.HttpMethodName;
import com.huawei.frs.access.auth.AccessServiceImpl;
import com.huawei.frs.access.utils.HttpClientUtils;
import com.huawei.frs.common.AuthInfo;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class FrsAccess extends AccessServiceImpl {

    /**
     * 服务名
     */
    private static final String SERVICE_NAME = "frs";

    public int connectionTimeout = HttpClientUtils.DEFAULT_CONNECTION_TIMEOUT;
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");


    public FrsAccess(AuthInfo authInfo) {
        super(FrsAccess.SERVICE_NAME, authInfo.getRegion(), authInfo.getAk(), authInfo.getSk());
        this.authInfo = authInfo;
    }

    public FrsAccess(AuthInfo authInfo, int connectionTimeout, int connectionRequestTimeout, int socketTimeout) {
        super(FrsAccess.SERVICE_NAME, authInfo.getRegion(), authInfo.getAk(), authInfo.getSk());
        this.authInfo = authInfo;

        this.connectionTimeout = connectionTimeout;

    }

    /**
     * 基本的认证信息
     */
    private AuthInfo authInfo = null;

    @Override
    protected OkHttpClient getHttpClient()
            throws KeyManagementException, KeyStoreException, NoSuchAlgorithmException {
        return HttpClientUtils.acceptsUntrustedCertsHttpClient(false, null, this.connectionTimeout);
    }

    protected boolean useDefaultHttpClient() {
        return false;
    }

    public Response put(String requestUrl, String putBody) {

        Response response = null;
        try {
            URL url = new URL(generateWholeUrl(authInfo.getEndPoint(), requestUrl));
            HttpMethodName httpMethod = HttpMethodName.PUT;

            RequestBody requestBody = RequestBody.create(JSON, putBody);
            response = access(url, requestBody, (long) putBody.getBytes().length, httpMethod);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return response;
    }

    public Response get(String requestUrl) {

        Response response = null;
        try {
            URL url = new URL(generateWholeUrl(authInfo.getEndPoint(), requestUrl));
            HttpMethodName httpMethod = HttpMethodName.GET;
            Map<String, String> header = new HashMap<>();
            header.put("Content-Type", "application/json; charset=utf-8");
            response = access(url, header, httpMethod);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return response;
    }

    public Response post(String requestUrl, RequestBody requestBody) {

        URL url = null;
        try {
            url = new URL(generateWholeUrl(authInfo.getEndPoint(), requestUrl));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpMethodName httpMethod = HttpMethodName.POST;
        Response response = null;
        Map<String, String> header = new HashMap<>();
        header.put("Content-Type", requestBody.contentType().toString());
        try {
            response = accessEntity(url, header, requestBody, (long) requestBody.contentLength(), httpMethod);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return response;
    }

    public Response delete(String requestUrl) {
        Response response = null;

        try {
            URL url = new URL(generateWholeUrl(this.authInfo.getEndPoint(), requestUrl));
            HttpMethodName httpMethod = HttpMethodName.DELETE;
            Map<String, String> header = new HashMap<>();
            header.put("Content-Type", "application/json; charset=utf-8");
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
