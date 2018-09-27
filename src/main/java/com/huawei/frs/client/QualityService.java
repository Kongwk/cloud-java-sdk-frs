package com.huawei.frs.client;

import com.alibaba.fastjson.JSONObject;
import com.huawei.frs.access.FrsAccess;
import com.huawei.frs.common.FrsConstant;
import com.huawei.frs.common.FrsException;
import com.huawei.frs.common.ImageType;
import com.huawei.frs.result.BlurClassifyResult;
import com.huawei.frs.result.FaceQualityResult;
import com.huawei.frs.result.HeadPoseEstimateResult;
import com.huawei.frs.utils.HttpResponseUtils;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class QualityService {
    private FrsAccess service;
    private String projectId;
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public QualityService(FrsAccess service, String projectId) {
        this.service = service;
        this.projectId = projectId;
    }

    //Face quality
    private FaceQualityResult faceQuality(String image, ImageType imageType) throws FrsException, UnsupportedOperationException, IOException {
        String uri = String.format(FrsConstant.getFaceQualityUri(), this.projectId);
        JSONObject json = new JSONObject();
        if (ImageType.BASE64 == imageType) {
            json.put("image_base64", image);
        } else {
            json.put("image_url", image);
        }

        RequestBody requestBody = RequestBody.create(JSON, json.toJSONString());
        Response httpResponse = this.service.post(uri, requestBody);
        return (FaceQualityResult) HttpResponseUtils.httpResponse2Result(httpResponse, FaceQualityResult.class);
    }

    public FaceQualityResult faceQualityByBase64(String imageBase64) throws FrsException, UnsupportedOperationException, IOException {
        return faceQuality(imageBase64, ImageType.BASE64);
    }

    public FaceQualityResult faceQualityByFile(String filePath) throws FrsException, UnsupportedOperationException, IOException {
        File file = new File(filePath);
        byte[] data = FileUtils.readFileToByteArray(file);
        String imageBase64 = Base64.encodeBase64String(data);
        return faceQuality(imageBase64, ImageType.BASE64);
    }

    public FaceQualityResult faceQualityByObsUrl(String obsUrl) throws FrsException, UnsupportedOperationException, IOException {
        return faceQuality(obsUrl, ImageType.OBSURL);
    }

    //Blur classify
    private BlurClassifyResult blurClassify(String image, ImageType imageType) throws FrsException, UnsupportedOperationException, IOException {
        String uri = String.format(FrsConstant.getBlurClassifyUri(), this.projectId);
        JSONObject json = new JSONObject();
        if (ImageType.BASE64 == imageType) {
            json.put("image_base64", image);
        } else {
            json.put("image_url", image);
        }

        RequestBody requestBody = RequestBody.create(JSON, json.toJSONString());
        Response httpResponse = this.service.post(uri, requestBody);
        return (BlurClassifyResult) HttpResponseUtils.httpResponse2Result(httpResponse, BlurClassifyResult.class);
    }

    public BlurClassifyResult blurClassifyByBase64(String imageBase64) throws FrsException, UnsupportedOperationException, IOException {
        return blurClassify(imageBase64, ImageType.BASE64);
    }

    public BlurClassifyResult blurClassifyByFile(String filePath) throws FrsException, UnsupportedOperationException, IOException {
        File file = new File(filePath);
        byte[] data = FileUtils.readFileToByteArray(file);
        String imageBase64 = Base64.encodeBase64String(data);
        return blurClassify(imageBase64, ImageType.BASE64);
    }

    public BlurClassifyResult blurClassifyByObsUrl(String obsUrl) throws FrsException, UnsupportedOperationException, IOException {
        return blurClassify(obsUrl, ImageType.OBSURL);
    }

    //Head pose estimate
    private HeadPoseEstimateResult headPoseEstimate(String image, ImageType imageType) throws FrsException, UnsupportedOperationException, IOException {
        String uri = String.format(FrsConstant.getHeadPoseEstimate(), this.projectId);
        JSONObject json = new JSONObject();
        if (ImageType.BASE64 == imageType) {
            json.put("image_base64", image);
        } else {
            json.put("image_url", image);
        }

        RequestBody requestBody = RequestBody.create(JSON, json.toJSONString());
        Response httpResponse = this.service.post(uri, requestBody);
        return (HeadPoseEstimateResult) HttpResponseUtils.httpResponse2Result(httpResponse, HeadPoseEstimateResult.class);
    }

    public HeadPoseEstimateResult headPoseEstimateByBase64(String imageBase64) throws FrsException, UnsupportedOperationException, IOException {
        return headPoseEstimate(imageBase64, ImageType.BASE64);
    }

    public HeadPoseEstimateResult headPoseEstimateByFile(String filePath) throws FrsException, UnsupportedOperationException, IOException {
        File file = new File(filePath);
        byte[] data = FileUtils.readFileToByteArray(file);
        String imageBase64 = Base64.encodeBase64String(data);
        return headPoseEstimate(imageBase64, ImageType.BASE64);
    }

    public HeadPoseEstimateResult headPoseEstimateByObsUrl(String obsUrl) throws FrsException, UnsupportedOperationException, IOException {
        return headPoseEstimate(obsUrl, ImageType.OBSURL);
    }
}
