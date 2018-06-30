package com.huawei.frs.common;

public class FrsConstant {
    private static final String endPoint = "https://frs.cn-north-1.myhuaweicloud.com";
    private static final String region = "cn-north-1";
    private static final String userUri = "/v1/%s/subscribe";
    private static final String faceDetectUri = "/v1/%s/face-detect";
    private static final String faceCompareUri = "/v1/%s/face-compare";
    private static final String faceSearchUri = "/v1/%s/face-sets/%s/search";
    private static final String faceAddUri = "/v1/%s/face-sets/%s/faces";
    private static final String faceGetRangeUri = "/v1/%s/face-sets/%s/faces?offset=%d&&limit=%d";
    private static final String faceGetOneUri = "/v1/%s/face-sets/%s/faces?face_id=%s";
    private static final String faceDeleteByExternalImageIdUri = "/v1/%s/face-sets/%s/faces?external_image_id=%s";
    private static final String faceDeleteByFaceIdUri = "/v1/%s/face-sets/%s/faces?face_id=%s";
    private static final String faceSetCreateUri = "/v1/%s/face-sets";
    private static final String faceSetGetAllUri = "/v1/%s/face-sets";
    private static final String faceSetGetOneUri = "/v1/%s/face-sets/%s";
    private static final String faceSetDeleteUri = "/v1/%s/face-sets/%s";

    public static String getEndPoint() {
        return endPoint;
    }

    public static String getRegion() {
        return region;
    }

    public static String getUserUri() {
        return userUri;
    }

    public static String getFaceDetectUri() {
        return faceDetectUri;
    }

    public static String getFaceCompareUri() {
        return faceCompareUri;
    }

    public static String getFaceSearchUri() {
        return faceSearchUri;
    }

    public static String getFaceAddUri() {
        return faceAddUri;
    }

    public static String getFaceGetRangeUri() {
        return faceGetRangeUri;
    }

    public static String getFaceGetOneUri() {
        return faceGetOneUri;
    }

    public static String getFaceDeleteByExternalImageIdUri() {
        return faceDeleteByExternalImageIdUri;
    }

    public static String getFaceDeleteByFaceIdUri() {
        return faceDeleteByFaceIdUri;
    }

    public static String getFaceSetCreateUri() {
        return faceSetCreateUri;
    }

    public static String getFaceSetGetAllUri() {
        return faceSetGetAllUri;
    }

    public static String getFaceSetGetOneUri() {
        return faceSetGetOneUri;
    }

    public static String getFaceSetDeleteUri() {
        return faceSetDeleteUri;
    }
}
