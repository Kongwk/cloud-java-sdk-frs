package com.huawei.frs.result;

public class FaceQualityResult {
    private BlurClassifyResult blur;
    private HeadPoseEstimateResult pose;

    public BlurClassifyResult getBlur() {
        return blur;
    }

    public void setBlur(BlurClassifyResult blur) {
        this.blur = blur;
    }

    public HeadPoseEstimateResult getPose() {
        return pose;
    }

    public void setPose(HeadPoseEstimateResult pose) {
        this.pose = pose;
    }

    public String toString() {
        return String.format("{\"blur\":%s,\"pose\":%s}", blur.toString(), pose.toString());
    }

    public String toJSONString() {
        return String.format("{\"blur\":%s,\"pose\":%s}", blur.toJSONString(), pose.toJSONString());
    }
}