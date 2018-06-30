package com.huawei.frs.utils;

import com.alibaba.fastjson.JSONObject;
import com.huawei.frs.access.utils.HttpClientUtils;
import com.huawei.frs.common.FrsException;
import org.apache.http.HttpResponse;

import java.io.IOException;

public class HttpResponseUtils {
    public static <T> T httpResponse2Result(HttpResponse httpResponse, Class<T> clazz) throws FrsException, UnsupportedOperationException, IOException {
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        String content = HttpClientUtils.convertStreamToString(httpResponse.getEntity().getContent());
        if (200 != statusCode) {
            throw new FrsException(statusCode, content);
        } else {
            return JSONObject.parseObject(content, clazz);
        }
    }
}
