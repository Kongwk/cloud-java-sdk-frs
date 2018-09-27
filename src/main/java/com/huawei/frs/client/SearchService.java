package com.huawei.frs.client;

import com.alibaba.fastjson.JSONObject;
import com.huawei.frs.access.FrsAccess;
import com.huawei.frs.common.*;
import com.huaweicloud.frs.common.*;
import com.huawei.frs.result.SearchFaceResult;
import com.huawei.frs.utils.HttpResponseUtils;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class SearchService {
    private FrsAccess service;
    private String projectId;
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    SearchService(FrsAccess service, String projectId) {
        this.service = service;
        this.projectId = projectId;
    }

    private SearchFaceResult searchFace(String faceSetName, String image, Integer topN, Double threshold, ImageType imageType,
                                        SearchSort searchSort, SearchReturnFields searchReturnFields, String filter) throws FrsException, UnsupportedOperationException, IOException {
        String uri = String.format(FrsConstant.getFaceSearchUri(), this.projectId, faceSetName);
        JSONObject json = new JSONObject();
        if (ImageType.BASE64 == imageType) {
            json.put("image_base64", image);
        } else if (ImageType.FACEID == imageType) {
            json.put("face_id", image);
        } else {
            json.put("image_url", image);
        }
        if (null != topN) {
            json.put("top_n", topN);
        }
        if (null != threshold) {
            json.put("threshold", threshold);
        }
        if (null != searchSort) {
            json.put("sort", searchSort.getSearchSort());
        }
        if (null != searchReturnFields) {
            json.put("return_fields", searchReturnFields.getReturnFields());
        }
        if (null != filter) {
            json.put("filter", filter);
        }

        RequestBody requestBody = RequestBody.create(JSON, json.toJSONString());
        Response httpResponse = this.service.post(uri, requestBody);
        return (SearchFaceResult) HttpResponseUtils.httpResponse2Result(httpResponse, SearchFaceResult.class);
    }

    //Base64
    public SearchFaceResult searchFaceByBase64(String faceSetName, String imageBase64, Integer topN, Double threshold,
                                               SearchSort searchSort, SearchReturnFields searchReturnFields, String filter) throws FrsException, UnsupportedOperationException, IOException {
        return searchFace(faceSetName, imageBase64, topN, threshold, ImageType.BASE64, searchSort, searchReturnFields, filter);
    }

    public SearchFaceResult searchFaceByBase64(String faceSetName, String imageBase64, Integer topN, Double threshold) throws FrsException, UnsupportedOperationException, IOException {
        return searchFaceByBase64(faceSetName, imageBase64, topN, threshold, null, null, null);
    }

    public SearchFaceResult searchFaceByBase64(String faceSetName, String imageBase64) throws FrsException, UnsupportedOperationException, IOException {
        return searchFaceByBase64(faceSetName, imageBase64, null, null, null, null, null);
    }

    //File
    public SearchFaceResult searchFaceByFile(String faceSetName, String filePath, Integer topN, Double threshold,
                                             SearchSort searchSort, SearchReturnFields searchReturnFields, String filter) throws FrsException, UnsupportedOperationException, IOException {
        File image = new File(filePath);
        byte[] fileData = FileUtils.readFileToByteArray(image);
        String imageBase64 = Base64.encodeBase64String(fileData);
        return this.searchFace(faceSetName, imageBase64, topN, threshold, ImageType.BASE64, searchSort, searchReturnFields, filter);
    }

    public SearchFaceResult searchFaceByFile(String faceSetName, String filePath, Integer topN, Double threshold) throws FrsException, UnsupportedOperationException, IOException {
        return this.searchFaceByFile(faceSetName, filePath, topN, threshold, null, null, null);
    }

    public SearchFaceResult searchFaceByFile(String faceSetName, String filePath) throws FrsException, UnsupportedOperationException, IOException {
        return this.searchFaceByFile(faceSetName, filePath, null, null, null, null, null);
    }

    //Obs url
    public SearchFaceResult searchFaceByObsUrl(String faceSetName, String obsUrl, Integer topN, Double threshold,
                                               SearchSort searchSort, SearchReturnFields searchReturnFields, String filter) throws FrsException, UnsupportedOperationException, IOException {
        return this.searchFace(faceSetName, obsUrl, topN, threshold, ImageType.OBSURL, searchSort, searchReturnFields, filter);
    }

    public SearchFaceResult searchFaceByObsUrl(String faceSetName, String obsUrl, Integer topN, Double threshold) throws FrsException, UnsupportedOperationException, IOException {
        return this.searchFaceByObsUrl(faceSetName, obsUrl, topN, threshold, null, null, null);
    }

    public SearchFaceResult searchFaceByObsUrl(String faceSetName, String obsUrl) throws FrsException, UnsupportedOperationException, IOException {
        return this.searchFaceByObsUrl(faceSetName, obsUrl, null, null, null, null, null);
    }

    //Face id
    public SearchFaceResult searchFaceByFaceId(String faceSetName, String faceId, Integer topN, Double threshold,
                                               SearchSort searchSort, SearchReturnFields searchReturnFields, String filter) throws FrsException, UnsupportedOperationException, IOException {
        return searchFace(faceSetName, faceId, topN, threshold, ImageType.FACEID, searchSort, searchReturnFields, filter);
    }

    public SearchFaceResult searchFaceByFaceId(String faceSetName, String faceId, Integer topN, Double threshold) throws FrsException, UnsupportedOperationException, IOException {
        return searchFaceByFaceId(faceSetName, faceId, topN, threshold, null, null, null);
    }

    public SearchFaceResult searchFaceByFaceId(String faceSetName, String faceId) throws FrsException, UnsupportedOperationException, IOException {
        return searchFaceByFaceId(faceSetName, faceId, null, null, null, null, null);
    }
}
