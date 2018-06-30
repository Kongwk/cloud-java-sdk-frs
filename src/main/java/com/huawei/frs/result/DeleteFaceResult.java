package com.huawei.frs.result;

import com.huawei.frs.utils.StringUtils;

import java.util.List;

public class DeleteFaceResult {
    private List<String> faceIds;
    private String externalImageId;
    private String faceSetId;
    private String faceSetName;

    public DeleteFaceResult() {
    }

    public List<String> getFaceIds() {
        return this.faceIds;
    }

    public void setFaceIds(List<String> faceIds) {
        this.faceIds = faceIds;
    }

    public String getExternalImageId() {
        return this.externalImageId;
    }

    public void setExternalImageId(String externalImageId) {
        this.externalImageId = externalImageId;
    }

    public String getFaceSetId() {
        return this.faceSetId;
    }

    public void setFaceSetId(String faceSetId) {
        this.faceSetId = faceSetId;
    }

    public String getFaceSetName() {
        return this.faceSetName;
    }

    public void setFaceSetName(String faceSetName) {
        this.faceSetName = faceSetName;
    }

    public String toString() {
        return String.format("{\"faceIds\":%s,\"externalImageId\":\"%s\",\"faceSetId\":\"%s\",\"faceSetName\":\"%s\"}", StringUtils.stringList2JSONString(this.faceIds), this.externalImageId, this.faceSetId, this.faceSetName);
    }

    public String toJSONString() {
        return String.format("{\"face_ids\":%s,\"external_image_id\":\"%s\",\"face_set_id\":\"%s\",\"face_set_name\":\"%s\"}", StringUtils.stringList2JSONString(this.faceIds), this.externalImageId, this.faceSetId, this.faceSetName);
    }
}
