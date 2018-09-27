package com.huawei.frs.common;

public class FaceSet {
    private int faceNumber;
    private String faceSetId;
    private String faceSetName;
    private String createDate;
    private int faceSetCapacity;
    private String externalFields;

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

    public String getExternalFields() {
        return externalFields;
    }

    public void setExternalFields(String externalFields) {
        this.externalFields = externalFields;
    }

    public String toString() {
        if (null == faceSetId) {
            return "{}";
        }
        return String.format("{\"faceNumber\":%d,\"faceSetId\":\"%s\",\"faceSetName\":\"%s\",\"createDate\":\"%s\",\"faceSetCapacity\":%d,\"externalFields\":%s}",
                this.faceNumber, this.faceSetId, this.faceSetName, this.createDate, this.faceSetCapacity, this.externalFields);
    }

    public String toJSONString() {
        if (null == faceSetId) {
            return "{}";
        }
        return String.format("{\"face_number\":%d,\"face_set_id\":\"%s\",\"face_set_name\":\"%s\",\"create_date\":\"%s\",\"face_set_capacity\":%d,\"external_fields\":%s}",
                this.faceNumber, this.faceSetId, this.faceSetName, this.createDate, this.faceSetCapacity, this.externalFields);
    }
}
