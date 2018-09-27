package com.huawei.frs.common;

import com.huawei.frs.utils.StringUtils;

import java.util.List;

public class VideoResult {
    private boolean alive;
    private List<Action> actions;
    private String picture;

    public VideoResult() {

    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String toString() {
        return String.format("{\"alive\":%s,\"actions\":%s,\"picture\":\"%s\"}",
                alive ? "true" : "false", StringUtils.actionList2JSONString(actions), picture);
    }

    public String toJSONString() {
        return String.format("{\"alive\":%s,\"actions\":%s,\"picture\":\"%s\"}",
                alive ? "true" : "false", StringUtils.actionList2JSONString(actions), picture);
    }
}
