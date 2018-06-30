package com.huawei.frs.common;

public class SimpleFace {
    protected BoundingBox boundingBox;

    public SimpleFace() {
    }

    public BoundingBox getBoundingBox() {
        return this.boundingBox;
    }

    public void setBoundingBox(BoundingBox boundingBox) {
        this.boundingBox = boundingBox;
    }

    public String toString() {
        return String.format("{\"boundingBox\":%s}", this.boundingBox.toString());
    }

    public String toJSONString() {
        return String.format("{\"bounding_box\":%s}", this.boundingBox.toJSONString());
    }
}
