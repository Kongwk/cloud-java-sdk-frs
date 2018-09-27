package com.huawei.frs.utils;

import com.alibaba.fastjson.JSONObject;
import com.huawei.frs.common.FrsException;
import okhttp3.Response;

import java.io.IOException;

public class HttpResponseUtils {
    public static <T> T httpResponse2Result(Response httpResponse, Class<T> clazz) throws FrsException, UnsupportedOperationException, IOException {
        int statusCode = httpResponse.code();
        String content = httpResponse.body().string();
        if (200 != statusCode) {
            throw new FrsException(statusCode, content);
        } else {
            return JSONObject.parseObject(content, clazz);
        }
    }
}
