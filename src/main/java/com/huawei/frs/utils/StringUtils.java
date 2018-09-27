package com.huawei.frs.utils;

import com.huawei.frs.common.*;
import com.huaweicloud.frs.common.*;

import java.util.List;

public class StringUtils {
    public static String actionList2JSONString(List<Action> actions) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        for (int i = 0; i < actions.size(); ++i) {
            stringBuilder.append(actions.get(i).toJSONString());
            if (actions.size() - 1 != i) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static String simpleFaceList2JSONString(List<DetectFace> faces) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');

        for (int i = 0; i < faces.size(); ++i) {
            stringBuilder.append(((DetectFace) faces.get(i)).toJSONString());
            if (faces.size() - 1 != i) {
                stringBuilder.append(',');
            }
        }

        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public static String faceList2JSONString(List<Face> faces) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');

        for (int i = 0; i < faces.size(); ++i) {
            stringBuilder.append(((Face) faces.get(i)).toJSONString());
            if (faces.size() - 1 != i) {
                stringBuilder.append(',');
            }
        }

        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public static String complexFaceList2JSONString(List<ComplexFace> faces) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');

        for (int i = 0; i < faces.size(); ++i) {
            stringBuilder.append(((ComplexFace) faces.get(i)).toJSONString());
            if (faces.size() - 1 != i) {
                stringBuilder.append(',');
            }
        }

        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public static String faceSetList2JSONString(List<FaceSet> faceSets) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');

        for (int i = 0; i < faceSets.size(); ++i) {
            stringBuilder.append(((FaceSet) faceSets.get(i)).toJSONString());
            if (faceSets.size() - 1 != i) {
                stringBuilder.append(',');
            }
        }

        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public static String stringList2JSONString(List<String> stringList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');

        for (int i = 0; i < stringList.size(); ++i) {
            stringBuilder.append('"');
            stringBuilder.append((String) stringList.get(i));
            stringBuilder.append('"');
            if (stringList.size() - 1 != i) {
                stringBuilder.append(",");
            }
        }

        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
