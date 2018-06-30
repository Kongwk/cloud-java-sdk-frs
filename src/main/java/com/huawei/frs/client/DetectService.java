package com.huawei.frs.client;

import com.alibaba.fastjson.JSONObject;
import com.huawei.frs.access.FrsAccess;
import com.huawei.frs.utils.HttpResponseUtils;
import com.huawei.frs.common.FrsConstant;
import com.huawei.frs.common.FrsException;
import com.huawei.frs.common.ImageType;
import com.huawei.frs.result.DetectFaceResult;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;

import java.io.File;
import java.io.IOException;

public class DetectService {
    private FrsAccess service;
    private String projectId;

    DetectService(FrsAccess service, String projectId) {
        this.service = service;
        this.projectId = projectId;
    }

    private DetectFaceResult detectFace(String image, ImageType imageType) throws FrsException, UnsupportedOperationException, IOException {
        String uri = String.format(FrsConstant.getFaceDetectUri(), this.projectId);
        JSONObject json = new JSONObject();
        if (ImageType.BASE64 == imageType) {
            json.put("image_base64", image);
        } else {
            json.put("image_url", image);
        }

        StringEntity stringEntity = new StringEntity(json.toJSONString(), "utf-8");
        HttpResponse httpResponse = this.service.post(uri, stringEntity);
        return (DetectFaceResult)HttpResponseUtils.httpResponse2Result(httpResponse, DetectFaceResult.class);
    }

    public DetectFaceResult detectFaceByBase64(String imageBase64) throws FrsException, UnsupportedOperationException, IOException {
        return this.detectFace(imageBase64, ImageType.BASE64);
    }

    public DetectFaceResult detectFaceByFile(String filePath) throws FrsException, UnsupportedOperationException, IOException {
        File image = new File(filePath);
        byte[] fileData = FileUtils.readFileToByteArray(image);
        String imageBase64 = Base64.encodeBase64String(fileData);
        return this.detectFace(imageBase64, ImageType.BASE64);
    }

    public DetectFaceResult detectFaceByObsUrl(String obsUrl) throws FrsException, UnsupportedOperationException, IOException {
        return this.detectFace(obsUrl, ImageType.OBSURL);
    }
}
