package com.huawei.frs.common;

public class Face extends SimpleFace {
    protected String externalImageId;
    protected String faceId;
    protected String externalFields;

    public Face() {
    }

    public String getExternalFields() {
        return externalFields;
    }

    public void setExternalFields(String externalFields) {
        this.externalFields = externalFields;
    }

    public String getExternalImageId() {
        return this.externalImageId;
    }

    public void setExternalImageId(String externalImageId) {
        this.externalImageId = externalImageId;
    }

    public String getFaceId() {
        return this.faceId;
    }

    public void setFaceId(String faceId) {
        this.faceId = faceId;
    }

    public String toString() {
        return String.format("{\"externalFields\":%s,\"boundingBox\":%s,\"externalImageId\":\"%s\",\"faceId\":\"%s\"}",
                this.externalFields, this.boundingBox.toString(), this.externalImageId, this.faceId);
    }

    public String toJSONString() {
        return String.format("{\"external_fields\":%s,\"bounding_box\":%s,\"external_image_id\":\"%s\",\"face_id\":\"%s\"}",
                this.externalFields, this.boundingBox.toJSONString(), this.externalImageId, this.faceId);
    }
}
