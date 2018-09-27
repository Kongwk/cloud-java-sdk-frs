package com.huawei.frs.result;

import com.huawei.frs.common.SimpleFace;

public class CompareFaceResult {
    private double similarity;
    private SimpleFace image1Face;
    private SimpleFace image2Face;

    public CompareFaceResult() {
    }

    public double getSimilarity() {
        return this.similarity;
    }

    public void setSimilarity(double similarity) {
        this.similarity = similarity;
    }

    public SimpleFace getImage1Face() {
        return this.image1Face;
    }

    public void setImage1Face(SimpleFace image1Face) {
        this.image1Face = image1Face;
    }

    public SimpleFace getImage2Face() {
        return this.image2Face;
    }

    public void setImage2Face(SimpleFace image2Face) {
        this.image2Face = image2Face;
    }

    public String toString() {
        return String.format("{\"image1Face\":%s,\"similarity\":%s,\"image2Face\":%s}", this.image1Face.toString(), String.valueOf(this.similarity), this.image2Face.toString());
    }

    public String toJSONString() {
        return String.format("{\"image1_face\":%s,\"similarity\":%s,\"image2_face\":%s}", this.image1Face.toJSONString(), String.valueOf(this.similarity), this.image2Face.toJSONString());
    }
}
