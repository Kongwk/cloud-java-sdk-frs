package com.huawei.frs.result;

import com.huawei.frs.common.Face;
import com.huawei.frs.utils.StringUtils;

import java.util.List;

public class AddFaceResult {
    private String faceSetId;
    private String faceSetName;
    private List<Face> faces;

    public AddFaceResult() {
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

    public List<Face> getFaces() {
        return this.faces;
    }

    public void setFaces(List<Face> faces) {
        this.faces = faces;
    }

    public String toString() {
        return String.format("{\"faceSetId\":\"%s\",\"faceSetName\":\"%s\",\"faces\":%s}", this.faceSetId, this.faceSetName, this.faces.toString());
    }

    public String toJSONString() {
        return String.format("{\"face_set_id\":\"%s\",\"face_set_name\":\"%s\",\"faces\":%s}", this.faceSetId, this.faceSetName, StringUtils.faceList2JSONString(this.faces));
    }
}
