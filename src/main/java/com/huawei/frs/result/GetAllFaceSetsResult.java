package com.huawei.frs.result;

import com.huawei.frs.common.FaceSet;
import com.huawei.frs.utils.StringUtils;

import java.util.List;

public class GetAllFaceSetsResult {
    private List<FaceSet> faceSetsInfo;

    public GetAllFaceSetsResult() {
    }

    public List<FaceSet> getFaceSetsInfo() {
        return this.faceSetsInfo;
    }

    public void setFaceSetsInfo(List<FaceSet> faceSetsInfo) {
        this.faceSetsInfo = faceSetsInfo;
    }

    public String toString() {
        return String.format("{\"faceSetsInfo\":%s}", this.faceSetsInfo.toString());
    }

    public String toJSONString() {
        return String.format("{\"face_sets_info\":%s}", StringUtils.faceSetList2JSONString(this.faceSetsInfo));
    }
}
