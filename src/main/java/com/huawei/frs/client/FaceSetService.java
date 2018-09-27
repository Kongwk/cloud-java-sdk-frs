package com.huawei.frs.client;

import com.alibaba.fastjson.JSONObject;
import com.huawei.frs.access.FrsAccess;
import com.huawei.frs.common.CreateExternalFields;
import com.huawei.frs.common.FrsConstant;
import com.huawei.frs.common.FrsException;
import com.huawei.frs.result.CreateFaceSetResult;
import com.huawei.frs.result.DeleteFaceSetResult;
import com.huawei.frs.result.GetAllFaceSetsResult;
import com.huawei.frs.result.GetFaceSetResult;
import com.huawei.frs.utils.HttpResponseUtils;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public class FaceSetService {
    private FrsAccess service;
    private String projectId;
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    FaceSetService(FrsAccess service, String projectId) {
        this.service = service;
        this.projectId = projectId;
    }

    //Create
    public CreateFaceSetResult createFaceSet(String faceSetName, Integer faceSetCapacity, CreateExternalFields createExternalFields) throws FrsException, UnsupportedOperationException, IOException {
        String uri = String.format(FrsConstant.getFaceSetCreateUri(), this.projectId);
        JSONObject json = new JSONObject();
        json.put("face_set_name", faceSetName);
        if (null != faceSetCapacity) {
            json.put("face_set_capacity", faceSetCapacity);
        }
        if (null != createExternalFields) {
            json.put("external_fields", createExternalFields.getExternalFields());
        }
        RequestBody requestBody = RequestBody.create(JSON, json.toJSONString());
        Response httpResponse = this.service.post(uri, requestBody);
        return (CreateFaceSetResult) HttpResponseUtils.httpResponse2Result(httpResponse, CreateFaceSetResult.class);
    }

    public CreateFaceSetResult createFaceSet(String faceSetName, int faceSetCapacity) throws FrsException, UnsupportedOperationException, IOException {
        return createFaceSet(faceSetName, faceSetCapacity, null);
    }

    public CreateFaceSetResult createFaceSet(String faceSetName) throws FrsException, UnsupportedOperationException, IOException {
        return createFaceSet(faceSetName, null, null);
    }

    //Get all set
    public GetAllFaceSetsResult getAllFaceSets() throws FrsException, UnsupportedOperationException, IOException {
        String uri = String.format(FrsConstant.getFaceSetGetAllUri(), this.projectId);
        Response httpResponse = this.service.get(uri);
        return (GetAllFaceSetsResult) HttpResponseUtils.httpResponse2Result(httpResponse, GetAllFaceSetsResult.class);
    }

    //Get set
    public GetFaceSetResult getFaceSet(String faceSetName) throws FrsException, UnsupportedOperationException, IOException {
        String uri = String.format(FrsConstant.getFaceSetGetOneUri(), this.projectId, faceSetName);
        Response httpResponse = this.service.get(uri);
        return (GetFaceSetResult) HttpResponseUtils.httpResponse2Result(httpResponse, GetFaceSetResult.class);
    }

    //Delete set
    public DeleteFaceSetResult deleteFaceSet(String faceSetName) throws FrsException, UnsupportedOperationException, IOException {
        String uri = String.format(FrsConstant.getFaceSetDeleteUri(), this.projectId, faceSetName);
        Response httpResponse = this.service.delete(uri);
        return (DeleteFaceSetResult) HttpResponseUtils.httpResponse2Result(httpResponse, DeleteFaceSetResult.class);
    }
}
