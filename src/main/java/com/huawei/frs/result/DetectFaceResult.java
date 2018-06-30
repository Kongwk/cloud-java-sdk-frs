package com.huawei.frs.result;

import com.huawei.frs.common.SimpleFace;
import com.huawei.frs.utils.StringUtils;

import java.util.List;

public class DetectFaceResult {
    private List<SimpleFace> faces;

    public DetectFaceResult() {
    }

    public List<SimpleFace> getFaces() {
        return this.faces;
    }

    public void setFaces(List<SimpleFace> faces) {
        this.faces = faces;
    }

    public String toString() {
        return String.format("{\"faces\":%s}", this.faces.toString());
    }

    public String toJSONString() {
        return String.format("{\"faces\":%s}", StringUtils.simpleFaceList2JSONString(this.faces));
    }
}
