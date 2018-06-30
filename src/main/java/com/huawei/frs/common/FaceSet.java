package com.huawei.frs.common;

public class FaceSet {
    private int faceNumber;
    private String faceSetId;
    private String faceSetName;
    private String createDate;
    private int faceSetCapacity;

    public FaceSet() {
    }

    public int getFaceNumber() {
        return this.faceNumber;
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

    public String getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int getFaceSetCapacity() {
        return this.faceSetCapacity;
    }

    public void setFaceSetCapacity(int faceSetCapacity) {
        this.faceSetCapacity = faceSetCapacity;
    }

    public String toString() {
        return String.format("{\"faceNumber\":%d,\"faceSetId\":\"%s\",\"faceSetName\":\"%s\",\"createDate\":\"%s\",\"faceSetCapacity\":%d}", this.faceNumber, this.faceSetId, this.faceSetName, this.createDate, this.faceSetCapacity);
    }

    public String toJSONString() {
        return String.format("{\"face_number\":%d,\"face_set_id\":\"%s\",\"face_set_name\":\"%s\",\"create_date\":\"%s\",\"face_set_capacity\":%d}", this.faceNumber, this.faceSetId, this.faceSetName, this.createDate, this.faceSetCapacity);
    }
}
