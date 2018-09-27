package com.huawei.frs.common;

public class ComplexFace extends Face {
    private double similarity;

    public ComplexFace() {
    }

    public double getSimilarity() {
        return this.similarity;
    }

    public void setSimilarity(double similarity) {
        this.similarity = similarity;
    }

    public String toString() {
        if (null == this.externalFields) {
            return String.format("{\"boundingBox\":%s,\"similarity\":%s,\"externalImageId\":\"%s\",\"faceId\":\"%s\"}",
                    this.boundingBox.toString(), String.valueOf(this.similarity), this.externalImageId, this.faceId);
        } else {
            return String.format("{\"boundingBox\":%s,\"similarity\":%s,\"externalImageId\":\"%s\",\"externalFields\":\"%s\",\"faceId\":\"%s\"}",
                    this.boundingBox.toString(), String.valueOf(this.similarity), this.externalImageId, this.externalFields, this.faceId);
        }
    }

    public String toJSONString() {
        if (null == this.externalFields) {
            return String.format("{\"bounding_box\":%s,\"similarity\":%s,\"external_image_id\":\"%s\",\"face_id\":\"%s\"}",
                    this.boundingBox.toJSONString(), String.valueOf(this.similarity), this.externalImageId, this.faceId);
        } else {
            return String.format("{\"bounding_box\":%s,\"similarity\":%s,\"external_image_id\":\"%s\",\"external_fields\":\"%s\",\"face_id\":\"%s\"}",
                    this.boundingBox.toJSONString(), String.valueOf(this.similarity), this.externalImageId, this.externalFields, this.faceId);
        }
    }
}
