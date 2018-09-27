package com.huawei.frs.client;


import com.alibaba.fastjson.JSONObject;
import com.huawei.frs.access.FrsAccess;
import com.huawei.frs.common.FrsConstant;
import com.huawei.frs.common.FrsException;
import com.huawei.frs.common.ImageType;
import com.huawei.frs.result.DetectFaceResult;
import com.huawei.frs.utils.HttpResponseUtils;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class DetectService {
    private FrsAccess service;
    private String projectId;
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    DetectService(FrsAccess service, String projectId) {
        this.service = service;
        this.projectId = projectId;
    }

    private DetectFaceResult detectFace(String image, ImageType imageType, String attributes) throws FrsException, UnsupportedOperationException, IOException {
        String uri = String.format(FrsConstant.getFaceDetectUri(), this.projectId);
        JSONObject json = new JSONObject();
        if (ImageType.BASE64 == imageType) {
            json.put("image_base64", image);
        } else {
            json.put("image_url", image);
        }

        if (null != attributes) {
            json.put("attributes", attributes);
        }

        RequestBody requestBody = RequestBody.create(JSON, json.toJSONString());
        Response httpResponse = this.service.post(uri, requestBody);
        return (DetectFaceResult) HttpResponseUtils.httpResponse2Result(httpResponse, DetectFaceResult.class);
    }

    //Base64
    public DetectFaceResult detectFaceByBase64(String imageBase64, String attributes) throws FrsException, UnsupportedOperationException, IOException {
        return this.detectFace(imageBase64, ImageType.BASE64, attributes);
    }

    public DetectFaceResult detectFaceByBase64(String imageBase64) throws FrsException, UnsupportedOperationException, IOException {
        return this.detectFaceByBase64(imageBase64, null);
    }

    //File
    public DetectFaceResult detectFaceByFile(String filePath, String attributes) throws FrsException, UnsupportedOperationException, IOException {
        File image = new File(filePath);
        byte[] fileData = FileUtils.readFileToByteArray(image);
        String imageBase64 = Base64.encodeBase64String(fileData);
        return this.detectFace(imageBase64, ImageType.BASE64, attributes);
    }

    public DetectFaceResult detectFaceByFile(String filePath) throws FrsException, UnsupportedOperationException, IOException {
        return this.detectFaceByFile(filePath, null);
    }

    //Obs
    public DetectFaceResult detectFaceByObsUrl(String obsUrl, String attributes) throws FrsException, UnsupportedOperationException, IOException {
        return this.detectFace(obsUrl, ImageType.OBSURL, attributes);
    }

    public DetectFaceResult detectFaceByObsUrl(String obsUrl) throws FrsException, UnsupportedOperationException, IOException {
        return this.detectFaceByObsUrl(obsUrl, null);
    }
}
