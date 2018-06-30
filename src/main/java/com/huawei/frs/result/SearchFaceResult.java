package com.huawei.frs.result;

import com.huawei.frs.common.ComplexFace;
import com.huawei.frs.utils.StringUtils;

import java.util.List;

public class SearchFaceResult {
    private List<ComplexFace> faces;

    public SearchFaceResult() {
    }

    public List<ComplexFace> getFaces() {
        return this.faces;
    }

    public void setFaces(List<ComplexFace> faces) {
        this.faces = faces;
    }

    public String toString() {
        return String.format("{\"faces\":%s}", this.faces.toString());
    }

    public String toJSONString() {
        return String.format("{\"faces\":%s}", StringUtils.complexFaceList2JSONString(this.faces));
    }
}
