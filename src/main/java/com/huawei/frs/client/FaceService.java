package com.huawei.frs.client;


import com.alibaba.fastjson.JSONObject;
import com.huawei.frs.access.FrsAccess;
import com.huawei.frs.common.AddExternalFields;
import com.huawei.frs.common.FrsConstant;
import com.huawei.frs.common.FrsException;
import com.huawei.frs.common.ImageType;
import com.huawei.frs.result.AddFaceResult;
import com.huawei.frs.result.DeleteFaceResult;
import com.huawei.frs.result.GetFaceResult;
import com.huawei.frs.utils.HttpResponseUtils;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FaceService {
    private FrsAccess service;
    private String projectId;
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    FaceService(FrsAccess service, String projectId) {
        this.service = service;
        this.projectId = projectId;
    }

    //Add face
    private AddFaceResult addFace(String faceSetName, String externalImageId, String image, ImageType imageType, AddExternalFields addExternalFields) throws FrsException, UnsupportedOperationException, IOException {
        String uri = String.format(FrsConstant.getFaceAddUri(), this.projectId, faceSetName);
        JSONObject json = new JSONObject();
        if (ImageType.BASE64 == imageType) {
            json.put("image_base64", image);
        } else {
            json.put("image_url", image);
        }
        if (null != externalImageId) {
            json.put("external_image_id", externalImageId);
        }
        if (null != addExternalFields) {
            json.put("external_fields", addExternalFields.getExternalFields());
        }

        RequestBody requestBody = RequestBody.create(JSON, json.toJSONString());
        Response httpResponse = this.service.post(uri, requestBody);
        return (AddFaceResult) HttpResponseUtils.httpResponse2Result(httpResponse, AddFaceResult.class);
    }

    //Base64
    public AddFaceResult addFaceByBase64(String faceSetName, String externalImageId, String imageBase64, AddExternalFields addExternalFields) throws FrsException, UnsupportedOperationException, IOException {
        return this.addFace(faceSetName, externalImageId, imageBase64, ImageType.BASE64, addExternalFields);
    }

    public AddFaceResult addFaceByBase64(String faceSetName, String imageBase64, AddExternalFields addExternalFields) throws FrsException, UnsupportedOperationException, IOException {
        return this.addFaceByBase64(faceSetName, null, imageBase64, addExternalFields);
    }

    public AddFaceResult addFaceByBase64(String faceSetName, String externalImageId, String imageBase64) throws FrsException, UnsupportedOperationException, IOException {
        return this.addFaceByBase64(faceSetName, externalImageId, imageBase64, null);
    }

    public AddFaceResult addFaceByBase64(String faceSetName, String imageBase64) throws FrsException, UnsupportedOperationException, IOException {
        return this.addFaceByBase64(faceSetName, null, imageBase64, null);
    }

    //File
    public AddFaceResult addFaceByFile(String faceSetName, String externalImageId, String filePath, AddExternalFields addExternalFields) throws FrsException, UnsupportedOperationException, IOException {
        File image = new File(filePath);
        byte[] fileData = FileUtils.readFileToByteArray(image);
        String imageBase64 = Base64.encodeBase64String(fileData);
        return this.addFace(faceSetName, externalImageId, imageBase64, ImageType.BASE64, addExternalFields);
    }

    public AddFaceResult addFaceByFile(String faceSetName, String filePath, AddExternalFields addExternalFields) throws FrsException, UnsupportedOperationException, IOException {
        return this.addFaceByFile(faceSetName, null, filePath, addExternalFields);
    }

    public AddFaceResult addFaceByFile(String faceSetName, String externalImageId, String filePath) throws FrsException, UnsupportedOperationException, IOException {
        return this.addFaceByFile(faceSetName, externalImageId, filePath, null);
    }

    public AddFaceResult addFaceByFile(String faceSetName, String filePath) throws FrsException, UnsupportedOperationException, IOException {
        return this.addFaceByFile(faceSetName, null, filePath, null);
    }

    //Obs url
    public AddFaceResult addFaceByObsUrl(String faceSetName, String externalImageId, String obsUrl, AddExternalFields addExternalFields) throws FrsException, UnsupportedOperationException, IOException {
        return this.addFace(faceSetName, externalImageId, obsUrl, ImageType.OBSURL, addExternalFields);
    }

    public AddFaceResult addFaceByObsUrl(String faceSetName, String obsUrl, AddExternalFields addExternalFields) throws FrsException, UnsupportedOperationException, IOException {
        return this.addFaceByObsUrl(faceSetName, null, obsUrl, addExternalFields);
    }

    public AddFaceResult addFaceByObsUrl(String faceSetName, String externalImageId, String obsUrl) throws FrsException, UnsupportedOperationException, IOException {
        return this.addFaceByObsUrl(faceSetName, externalImageId, obsUrl, null);
    }

    public AddFaceResult addFaceByObsUrl(String faceSetName, String obsUrl) throws FrsException, UnsupportedOperationException, IOException {
        return this.addFaceByObsUrl(faceSetName, null, obsUrl, null);
    }

    //Get faces
    public GetFaceResult getFaces(String faceSetName, int offset, int limit) throws FrsException, UnsupportedOperationException, IOException {
        String uri = String.format(FrsConstant.getFaceGetRangeUri(), this.projectId, faceSetName, offset, limit);
        Response httpResponse = this.service.get(uri);
        return (GetFaceResult) HttpResponseUtils.httpResponse2Result(httpResponse, GetFaceResult.class);
    }

    //Get face
    public GetFaceResult getFace(String faceSetName, String faceId) throws FrsException, UnsupportedOperationException, IOException {
        String uri = String.format(FrsConstant.getFaceGetOneUri(), this.projectId, faceSetName, faceId);
        Response httpResponse = this.service.get(uri);
        return (GetFaceResult) HttpResponseUtils.httpResponse2Result(httpResponse, GetFaceResult.class);
    }

    //Delete face
    public DeleteFaceResult deleteFaceByFaceId(String faceSetName, String faceId) throws FrsException, UnsupportedOperationException, IOException {
        String uri = String.format(FrsConstant.getFaceDeleteByFaceIdUri(), this.projectId, faceSetName, faceId);
        Response httpResponse = this.service.delete(uri);
        return (DeleteFaceResult) HttpResponseUtils.httpResponse2Result(httpResponse, DeleteFaceResult.class);
    }

    public DeleteFaceResult deleteFaceByExternalImageId(String faceSetName, String externalImageId) throws FrsException, UnsupportedOperationException, IOException {
        String uri = String.format(FrsConstant.getFaceDeleteByExternalImageIdUri(), this.projectId, faceSetName, externalImageId);
        Response httpResponse = this.service.delete(uri);
        return (DeleteFaceResult) HttpResponseUtils.httpResponse2Result(httpResponse, DeleteFaceResult.class);
    }

    public DeleteFaceResult deleteFaceByFieldId(String faceSetName, String fieldId, String fieldValue) throws FrsException, UnsupportedOperationException, IOException {
        String uri = String.format(FrsConstant.getFaceDeleteByFieldIdUri(), this.projectId, faceSetName, fieldId, fieldValue);
        Response httpResponse = this.service.delete(uri);
        return HttpResponseUtils.httpResponse2Result(httpResponse, DeleteFaceResult.class);
    }
}
