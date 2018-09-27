package com.huawei.frs.common;

public class DetectFace extends SimpleFace {
    protected String attributes;

    protected String landmark;

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String toString() {
        if (null != landmark && null != attributes) {
            return String.format("{\"boundingBox\":%s,\"attributes\":%s,\"landmark\":%s}",
                    this.boundingBox.toString(), this.attributes, this.landmark);
        } else if (null == landmark && null != attributes) {
            return String.format("{\"boundingBox\":%s,\"attributes\":%s}",
                    this.boundingBox.toString(), this.attributes);
        } else if (null != landmark) {
            return String.format("{\"boundingBox\":%s,\"landmark\":%s}",
                    this.boundingBox.toString(), this.landmark);
        } else {
            return String.format("{\"boundingBox\":%s}",
                    this.boundingBox.toString());
        }
    }

    public String toJSONString() {
        if (null != landmark && null != attributes) {
            return String.format("{\"bounding_box\":%s,\"attributes\":%s,\"landmark\":%s}",
                    this.boundingBox.toJSONString(), this.attributes, this.landmark);
        } else if (null == landmark && null != attributes) {
            return String.format("{\"bounding_box\":%s,\"attributes\":%s}",
                    this.boundingBox.toJSONString(), this.attributes);
        } else if (null != landmark) {
            return String.format("{\"bounding_box\":%s,\"landmark\":%s}",
                    this.boundingBox.toJSONString(), this.landmark);
        } else {
            return String.format("{\"bounding_box\":%s",
                    this.boundingBox.toJSONString());
        }
    }
}
