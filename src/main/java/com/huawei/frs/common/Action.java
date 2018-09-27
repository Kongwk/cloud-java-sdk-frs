package com.huawei.frs.common;

public class Action {
    private int action;
    private double confidence;

    public Action() {

    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }

    public String toString() {
        return String.format("{\"action\":%d,\"confidence\":%s}", action, String.valueOf(confidence));
    }

    public String toJSONString() {
        return String.format("{\"action\":%d,\"confidence\":%s}", action, String.valueOf(confidence));
    }
}
