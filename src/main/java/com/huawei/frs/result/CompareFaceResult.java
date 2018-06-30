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
        return String.format("{\"similarity\":%f,\"image1Face\":%s,\"image2Face\":%s}", this.similarity, this.image1Face.toString(), this.image2Face.toString());
    }

    public String toJSONString() {
        return String.format("{\"similarity\":%f,\"image1_face\":%s,\"image2_face\":%s}", this.similarity, this.image1Face.toJSONString(), this.image2Face.toJSONString());
    }
}
