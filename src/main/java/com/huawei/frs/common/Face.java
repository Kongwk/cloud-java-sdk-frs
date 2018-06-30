package com.huawei.frs.common;

public class Face extends SimpleFace {
    protected String externalImageId;
    protected String faceId;

    public Face() {
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
        return String.format("{\"boundingBox\":%s,\"externalImageId\":\"%s\",\"faceId\":\"%s\"}", this.boundingBox.toString(), this.externalImageId, this.faceId);
    }

    public String toJSONString() {
        return String.format("{\"bounding_box\":%s,\"external_image_id\":\"%s\",\"face_id\":\"%s\"}", this.boundingBox.toJSONString(), this.externalImageId, this.faceId);
    }
}
