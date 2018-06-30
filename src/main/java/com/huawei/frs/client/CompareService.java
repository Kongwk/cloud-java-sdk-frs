package com.huawei.frs.client;

import com.alibaba.fastjson.JSONObject;
import com.huawei.frs.access.FrsAccess;
import com.huawei.frs.utils.HttpResponseUtils;
import com.huawei.frs.common.FrsConstant;
import com.huawei.frs.common.FrsException;
import com.huawei.frs.common.ImageType;
import com.huawei.frs.result.CompareFaceResult;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;

import java.io.File;
import java.io.IOException;

public class CompareService {
    private FrsAccess service;
    private String projectId;

    CompareService(FrsAccess service, String projectId) {
        this.service = service;
        this.projectId = projectId;
    }

    private CompareFaceResult compareFace(String image1, String image2, ImageType imageType) throws FrsException, UnsupportedOperationException, IOException {
        String uri = String.format(FrsConstant.getFaceCompareUri(), this.projectId);
        JSONObject json = new JSONObject();
        if (ImageType.BASE64 == imageType) {
            json.put("image1_base64", image1);
            json.put("image2_base64", image2);
        } else {
            json.put("image1_url", image1);
            json.put("image2_url", image2);
        }

        StringEntity stringEntity = new StringEntity(json.toJSONString(), "utf-8");
        HttpResponse httpResponse = this.service.post(uri, stringEntity);
        return (CompareFaceResult)HttpResponseUtils.httpResponse2Result(httpResponse, CompareFaceResult.class);
    }

    public CompareFaceResult compareFaceByBase64(String image1Base64, String image2Base64) throws FrsException, UnsupportedOperationException, IOException {
        return this.compareFace(image1Base64, image2Base64, ImageType.BASE64);
    }

    public CompareFaceResult compareFaceByFile(String filePath1, String filePath2) throws FrsException, UnsupportedOperationException, IOException {
        File image1 = new File(filePath1);
        byte[] fileData1 = FileUtils.readFileToByteArray(image1);
        String image1Base64 = Base64.encodeBase64String(fileData1);
        File image2 = new File(filePath2);
        byte[] fileData2 = FileUtils.readFileToByteArray(image2);
        String image2Base64 = Base64.encodeBase64String(fileData2);
        return this.compareFace(image1Base64, image2Base64, ImageType.BASE64);
    }

    public CompareFaceResult compareFaceByObsUrl(String obsUrl1, String obsUrl2) throws FrsException, UnsupportedOperationException, IOException {
        return this.compareFace(obsUrl1, obsUrl2, ImageType.OBSURL);
    }
}
