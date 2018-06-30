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
        return String.format("{\"boundingBox\":%s,\"externalImageId\":\"%s\",\"faceId\":\"%s\",\"similarity\":%f}", this.boundingBox.toString(), this.externalImageId, this.faceId, this.similarity);
    }

    public String toJSONString() {
        return String.format("{\"bounding_box\":%s,\"external_image_id\":\"%s\",\"face_id\":\"%s\",\"similarity\":%f}", this.boundingBox.toJSONString(), this.externalImageId, this.faceId, this.similarity);
    }
}
