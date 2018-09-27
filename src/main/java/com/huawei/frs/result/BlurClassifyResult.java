package com.huawei.frs.result;

public class BlurClassifyResult {
    private boolean isClarity;

    public boolean isClarity() {
        return isClarity;
    }

    public void setClarity(boolean clarity) {
        isClarity = clarity;
    }

    public String toString() {
        return String.format("{\"isClarity\":%s}", isClarity ? "true" : "false");
    }

    public String toJSONString() {
        return String.format("{\"isClarity\":%s}", isClarity ? "true" : "false");
    }
}
