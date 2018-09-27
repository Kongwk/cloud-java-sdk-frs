package com.huawei.frs.result;

public class HeadPoseEstimateResult {
    private double yaw;
    private double roll;
    private double pitch;

    public double getYaw() {
        return yaw;
    }

    public void setYaw(double yaw) {
        this.yaw = yaw;
    }

    public double getRoll() {
        return roll;
    }

    public void setRoll(double roll) {
        this.roll = roll;
    }

    public double getPitch() {
        return pitch;
    }

    public void setPitch(double pitch) {
        this.pitch = pitch;
    }

    public String toString() {
        return String.format("{\"yaw\":%s,\"roll\":%s,\"pitch\":%s}", String.valueOf(yaw), String.valueOf(roll), String.valueOf(pitch));
    }

    public String toJSONString() {
        return String.format("{\"yaw\":%s,\"roll\":%s,\"pitch\":%s}", String.valueOf(yaw), String.valueOf(roll), String.valueOf(pitch));
    }
}
