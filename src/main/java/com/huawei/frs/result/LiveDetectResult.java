package com.huawei.frs.result;

import com.huawei.frs.common.VideoResult;
import com.huawei.frs.utils.StringUtils;

import java.util.List;

public class LiveDetectResult {
    private VideoResult videoResult;
    private List<String> warningList;

    public VideoResult getVideoResult() {
        return videoResult;
    }

    public void setVideoResult(VideoResult videoResult) {
        this.videoResult = videoResult;
    }

    public List<String> getWarningList() {
        return warningList;
    }

    public void setWarningList(List<String> warningList) {
        this.warningList = warningList;
    }

    public String toString() {
        return String.format("{\"videoResult\":%s,\"warningList\":%s}",
                videoResult.toString(), warningList.toString());
    }

    public String toJSONString() {
        return String.format("{\"video-result\":%s,\"warning-list\":%s}",
                videoResult.toJSONString(), StringUtils.stringList2JSONString(warningList));
    }
}
