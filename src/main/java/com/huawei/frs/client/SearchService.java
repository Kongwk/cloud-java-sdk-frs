package com.huawei.frs.client;

import com.alibaba.fastjson.JSONObject;
import com.huawei.frs.access.FrsAccess;
import com.huawei.frs.utils.HttpResponseUtils;
import com.huawei.frs.common.FrsConstant;
import com.huawei.frs.common.FrsException;
import com.huawei.frs.common.ImageType;
import com.huawei.frs.result.SearchFaceResult;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;

import java.io.File;
import java.io.IOException;

public class SearchService {
    private FrsAccess service;
    private String projectId;

    SearchService(FrsAccess service, String projectId) {
        this.service = service;
        this.projectId = projectId;
    }

    private SearchFaceResult searchFace(String faceSetName, String image, int topN, double threshold, ImageType imageType) throws FrsException, UnsupportedOperationException, IOException {
        String uri = String.format(FrsConstant.getFaceSearchUri(), this.projectId, faceSetName);
        JSONObject json = new JSONObject();
        if (ImageType.BASE64 == imageType) {
            json.put("image_base64", image);
        } else {
            json.put("image_url", image);
        }

        json.put("top_n", topN);
        json.put("threshold", threshold);
        StringEntity stringEntity = new StringEntity(json.toJSONString(), "utf-8");
        HttpResponse httpResponse = this.service.post(uri, stringEntity);
        return (SearchFaceResult)HttpResponseUtils.httpResponse2Result(httpResponse, SearchFaceResult.class);
    }

    public SearchFaceResult searchFaceByBase64(String faceSetName, String imageBase64) throws FrsException, UnsupportedOperationException, IOException {
        return this.searchFace(faceSetName, imageBase64, 10, 0.0D, ImageType.BASE64);
    }

    public SearchFaceResult searchFaceByFile(String faceSetName, String filePath) throws FrsException, UnsupportedOperationException, IOException {
        File image = new File(filePath);
        byte[] fileData = FileUtils.readFileToByteArray(image);
        String imageBase64 = Base64.encodeBase64String(fileData);
        return this.searchFace(faceSetName, imageBase64, 10, 0.0D, ImageType.BASE64);
    }

    public SearchFaceResult searchFaceByObsUrl(String faceSetName, String obsUrl) throws FrsException, UnsupportedOperationException, IOException {
        return this.searchFace(faceSetName, obsUrl, 10, 0.0D, ImageType.OBSURL);
    }

    public SearchFaceResult searchFaceByBase64(String faceSetName, String imageBase64, int topN, double threshold) throws FrsException, UnsupportedOperationException, IOException {
        return this.searchFace(faceSetName, imageBase64, topN, threshold, ImageType.BASE64);
    }

    public SearchFaceResult searchFaceByFile(String faceSetName, String filePath, int topN, double threshold) throws FrsException, UnsupportedOperationException, IOException {
        File image = new File(filePath);
        byte[] fileData = FileUtils.readFileToByteArray(image);
        String imageBase64 = Base64.encodeBase64String(fileData);
        return this.searchFace(faceSetName, imageBase64, topN, threshold, ImageType.BASE64);
    }

    public SearchFaceResult searchFaceByObsUrl(String faceSetName, String obsUrl, int topN, double threshold) throws FrsException, UnsupportedOperationException, IOException {
        return this.searchFace(faceSetName, obsUrl, topN, threshold, ImageType.OBSURL);
    }
}
