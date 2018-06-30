package com.huawei.frs.client;

import com.alibaba.fastjson.JSONObject;
import com.huawei.frs.access.FrsAccess;
import com.huawei.frs.utils.HttpResponseUtils;
import com.huawei.frs.common.FrsConstant;
import com.huawei.frs.common.FrsException;
import com.huawei.frs.result.CreateFaceSetResult;
import com.huawei.frs.result.DeleteFaceSetResult;
import com.huawei.frs.result.GetAllFaceSetsResult;
import com.huawei.frs.result.GetFaceSetResult;
import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;

import java.io.IOException;

public class FaceSetService {
    private FrsAccess service;
    private String projectId;

    FaceSetService(FrsAccess service, String projectId) {
        this.service = service;
        this.projectId = projectId;
    }

    public CreateFaceSetResult createFaceSet(String faceSetName, int faceSetCapacity) throws FrsException, UnsupportedOperationException, IOException {
        String uri = String.format(FrsConstant.getFaceSetCreateUri(), this.projectId);
        JSONObject json = new JSONObject();
        json.put("face_set_name", faceSetName);
        json.put("face_set_capacity", faceSetCapacity);
        StringEntity stringEntity = new StringEntity(json.toJSONString(), "utf-8");
        HttpResponse httpResponse = this.service.post(uri, stringEntity);
        return (CreateFaceSetResult)HttpResponseUtils.httpResponse2Result(httpResponse, CreateFaceSetResult.class);
    }

    public GetAllFaceSetsResult getAllFaceSets() throws FrsException, UnsupportedOperationException, IOException {
        String uri = String.format(FrsConstant.getFaceSetGetAllUri(), this.projectId);
        HttpResponse httpResponse = this.service.get(uri);
        return (GetAllFaceSetsResult)HttpResponseUtils.httpResponse2Result(httpResponse, GetAllFaceSetsResult.class);
    }

    public GetFaceSetResult getFaceSet(String faceSetName) throws FrsException, UnsupportedOperationException, IOException {
        String uri = String.format(FrsConstant.getFaceSetGetOneUri(), this.projectId, faceSetName);
        HttpResponse httpResponse = this.service.get(uri);
        return (GetFaceSetResult)HttpResponseUtils.httpResponse2Result(httpResponse, GetFaceSetResult.class);
    }

    public DeleteFaceSetResult deleteFaceSet(String faceSetName) throws FrsException, UnsupportedOperationException, IOException {
        String uri = String.format(FrsConstant.getFaceSetDeleteUri(), this.projectId, faceSetName);
        HttpResponse httpResponse = this.service.delete(uri);
        return (DeleteFaceSetResult)HttpResponseUtils.httpResponse2Result(httpResponse, DeleteFaceSetResult.class);
    }
}
