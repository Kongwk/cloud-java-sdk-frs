package com.huawei.frs.result;


public class DeleteFaceResult {
    private int faceNumber;
    private String faceSetId;
    private String faceSetName;

    public int getFaceNumber() {
        return faceNumber;
    }

    public void setFaceNumber(int faceNumber) {
        this.faceNumber = faceNumber;
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
        return String.format("{\"faceNumber\":%d,\"faceSetId\":\"%s\",\"faceSetName\":\"%s\"}",
                this.faceNumber, this.faceSetId, this.faceSetName);
    }

    public String toJSONString() {
        return String.format("{\"face_number\":%d,\"face_set_id\":\"%s\",\"face_set_name\":\"%s\"}",
                this.faceNumber, this.faceSetId, this.faceSetName);
    }
}
