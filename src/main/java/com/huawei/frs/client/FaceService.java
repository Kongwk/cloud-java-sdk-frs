package com.huawei.frs.client;

import com.alibaba.fastjson.JSONObject;
import com.huawei.frs.access.FrsAccess;
import com.huawei.frs.utils.HttpResponseUtils;
import com.huawei.frs.common.FrsConstant;
import com.huawei.frs.common.FrsException;
import com.huawei.frs.common.ImageType;
import com.huawei.frs.result.AddFaceResult;
import com.huawei.frs.result.DeleteFaceResult;
import com.huawei.frs.result.GetFaceResult;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;

import java.io.File;
import java.io.IOException;

public class FaceService {
    private FrsAccess service;
    private String projectId;

    FaceService(FrsAccess service, String projectId) {
        this.service = service;
        this.projectId = projectId;
    }

    private AddFaceResult addFace(String faceSetName, String externalImageId, String image, ImageType imageType) throws FrsException, UnsupportedOperationException, IOException {
        String uri = String.format(FrsConstant.getFaceAddUri(), this.projectId, faceSetName);
        JSONObject json = new JSONObject();
        if (ImageType.BASE64 == imageType) {
            json.put("image_base64", image);
        } else {
            json.put("image_url", image);
        }

        json.put("external_image_id", externalImageId);
        StringEntity stringEntity = new StringEntity(json.toJSONString(), "utf-8");
        HttpResponse httpResponse = this.service.post(uri, stringEntity);
        return (AddFaceResult)HttpResponseUtils.httpResponse2Result(httpResponse, AddFaceResult.class);
    }

    public AddFaceResult addFaceByBase64(String faceSetName, String externalImageId, String imageBase64) throws FrsException, UnsupportedOperationException, IOException {
        return this.addFace(faceSetName, externalImageId, imageBase64, ImageType.BASE64);
    }

    public AddFaceResult addFaceByFile(String faceSetName, String externalImageId, String filePath) throws FrsException, UnsupportedOperationException, IOException {
        File image = new File(filePath);
        byte[] fileData = FileUtils.readFileToByteArray(image);
        String imageBase64 = Base64.encodeBase64String(fileData);
        return this.addFace(faceSetName, externalImageId, imageBase64, ImageType.BASE64);
    }

    public AddFaceResult addFaceByObsUrl(String faceSetName, String externalImageId, String obsUrl) throws FrsException, UnsupportedOperationException, IOException {
        return this.addFace(faceSetName, externalImageId, obsUrl, ImageType.OBSURL);
    }

    public GetFaceResult getFaces(String faceSetName, int offset, int limit) throws FrsException, UnsupportedOperationException, IOException {
        String uri = String.format(FrsConstant.getFaceGetRangeUri(), this.projectId, faceSetName, offset, limit);
        HttpResponse httpResponse = this.service.get(uri);
        return (GetFaceResult)HttpResponseUtils.httpResponse2Result(httpResponse, GetFaceResult.class);
    }

    public GetFaceResult getFace(String faceSetName, String faceId) throws FrsException, UnsupportedOperationException, IOException {
        String uri = String.format(FrsConstant.getFaceGetOneUri(), this.projectId, faceSetName, faceId);
        HttpResponse httpResponse = this.service.get(uri);
        return (GetFaceResult)HttpResponseUtils.httpResponse2Result(httpResponse, GetFaceResult.class);
    }

    public DeleteFaceResult deleteFaceByFaceId(String faceSetName, String faceId) throws FrsException, UnsupportedOperationException, IOException {
        String uri = String.format(FrsConstant.getFaceDeleteByFaceIdUri(), this.projectId, faceSetName, faceId);
        HttpResponse httpResponse = this.service.delete(uri);
        return (DeleteFaceResult)HttpResponseUtils.httpResponse2Result(httpResponse, DeleteFaceResult.class);
    }

    public DeleteFaceResult deleteFaceByExternalImageId(String faceSetName, String externalImageId) throws FrsException, UnsupportedOperationException, IOException {
        String uri = String.format(FrsConstant.getFaceDeleteByExternalImageIdUri(), this.projectId, faceSetName, externalImageId);
        HttpResponse httpResponse = this.service.delete(uri);
        return (DeleteFaceResult)HttpResponseUtils.httpResponse2Result(httpResponse, DeleteFaceResult.class);
    }
}
