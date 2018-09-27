package com.huawei.frs.client;


import com.alibaba.fastjson.JSONObject;
import com.huawei.frs.access.FrsAccess;
import com.huawei.frs.common.FrsConstant;
import com.huawei.frs.common.FrsException;
import com.huawei.frs.common.ImageType;
import com.huawei.frs.result.LiveDetectResult;
import com.huawei.frs.utils.HttpResponseUtils;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class LiveDetectService {
    private FrsAccess service;
    private String projectId;
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public LiveDetectService(FrsAccess service, String projectId) {
        this.service = service;
        this.projectId = projectId;
    }

    //Live detect
    private LiveDetectResult liveDetect(String video, ImageType videoType, String actions, String actionTime) throws FrsException, UnsupportedOperationException, IOException {
        String uri = String.format(FrsConstant.getLiveDetectUri(), this.projectId);
        JSONObject json = new JSONObject();
        if (ImageType.BASE64 == videoType) {
            json.put("video_base64", video);
        } else {
            json.put("video_url", video);
        }
        json.put("actions", actions);
        if (null != actionTime) {
            json.put("action_time", actionTime);
        }

        RequestBody requestBody = RequestBody.create(JSON, json.toJSONString());
        Response httpResponse = this.service.post(uri, requestBody);
        return (LiveDetectResult) HttpResponseUtils.httpResponse2Result(httpResponse, LiveDetectResult.class);
    }

    //Live detect by base64
    public LiveDetectResult liveDetectByBase64(String videoBase64, String actions, String actionTime) throws FrsException, UnsupportedOperationException, IOException {
        return liveDetect(videoBase64, ImageType.BASE64, actions, actionTime);
    }

    public LiveDetectResult liveDetectByBase64(String videoBase64, String actions) throws FrsException, UnsupportedOperationException, IOException {
        return liveDetectByBase64(videoBase64, actions, null);
    }

    //Live detect by file
    public LiveDetectResult liveDetectByFile(String videoPath, String actions, String actionTime) throws FrsException, UnsupportedOperationException, IOException {
        File file = new File(videoPath);
        byte[] fileData = FileUtils.readFileToByteArray(file);
        String videoBase64 = Base64.encodeBase64String(fileData);
        return liveDetect(videoBase64, ImageType.BASE64, actions, actionTime);
    }

    public LiveDetectResult liveDetectByFile(String videoPath, String actions) throws FrsException, UnsupportedOperationException, IOException {
        return liveDetectByFile(videoPath, actions, null);
    }

    //Live detect by obs url
    public LiveDetectResult liveDetectByObsUrl(String videoUrl, String actions, String actionTime) throws FrsException, UnsupportedOperationException, IOException {
        return liveDetect(videoUrl, ImageType.OBSURL, actions, actionTime);
    }

    public LiveDetectResult liveDetectByObsUrl(String videoUrl, String actions) throws FrsException, UnsupportedOperationException, IOException {
        return liveDetectByObsUrl(videoUrl, actions, null);
    }
}
