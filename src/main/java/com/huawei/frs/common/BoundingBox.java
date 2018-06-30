package com.huawei.frs.common;

public class BoundingBox {
    private int width;
    private int height;
    private int topLeftX;
    private int topLeftY;

    public BoundingBox() {
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getTopLeftX() {
        return this.topLeftX;
    }

    public void setTopLeftX(int topLeftX) {
        this.topLeftX = topLeftX;
    }

    public int getTopLeftY() {
        return this.topLeftY;
    }

    public void setTopLeftY(int topLeftY) {
        this.topLeftY = topLeftY;
    }

    public String toString() {
        return String.format("{\"width\":%d,\"height\":%d,\"topLeftX\":%d,\"topLeftY\":%d}", this.width, this.height, this.topLeftX, this.topLeftY);
    }

    public String toJSONString() {
        return String.format("{\"width\":%d,\"height\":%d,\"top_left_x\":%d,\"top_left_y\":%d}", this.width, this.height, this.topLeftX, this.topLeftY);
    }
}
