package com.huawei.frs.result;

import com.huawei.frs.utils.StringUtils;
import com.huawei.frs.common.DetectFace;

import java.util.List;

public class DetectFaceResult {
    private List<DetectFace> faces;

    public DetectFaceResult() {
    }

    public List<DetectFace> getFaces() {
        return this.faces;
    }

    public void setFaces(List<DetectFace> faces) {
        this.faces = faces;
    }

    public String toString() {
        return String.format("{\"faces\":%s}", this.faces.toString());
    }

    public String toJSONString() {
        return String.format("{\"faces\":%s}", StringUtils.simpleFaceList2JSONString(this.faces));
    }
}
