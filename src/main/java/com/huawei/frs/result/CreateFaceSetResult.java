package com.huawei.frs.result;

import com.huawei.frs.common.FaceSet;

public class CreateFaceSetResult {
    private FaceSet faceSetInfo;

    public CreateFaceSetResult() {
    }

    public FaceSet getFaceSetInfo() {
        return this.faceSetInfo;
    }

    public void setFaceSetInfo(FaceSet faceSetInfo) {
        this.faceSetInfo = faceSetInfo;
    }

    public String toString() {
        return String.format("{\"faceSetInfo\":%s}", this.faceSetInfo.toString());
    }

    public String toJSONString() {
        return String.format("{\"face_set_info\":%s}", this.faceSetInfo.toJSONString());
    }
}
