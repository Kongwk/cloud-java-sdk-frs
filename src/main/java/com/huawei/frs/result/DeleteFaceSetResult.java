package com.huawei.frs.result;

public class DeleteFaceSetResult {
    private String faceSetName;

    public DeleteFaceSetResult() {
    }

    public String getFaceSetName() {
        return this.faceSetName;
    }

    public void setFaceSetName(String faceSetName) {
        this.faceSetName = faceSetName;
    }

    public String toString() {
        return String.format("{\"faceSetName\":\"%s\"}", this.faceSetName);
    }

    public String toJSONString() {
        return String.format("{\"face_set_name\":\"%s\"}", this.faceSetName);
    }
}
