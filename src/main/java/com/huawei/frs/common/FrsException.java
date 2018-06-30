package com.huawei.frs.common;

public class FrsException extends Exception {
    public FrsException() {
    }

    public FrsException(int httpStatusCode, String msg) {
        super(String.format("Face Recognition Service returns wrong response. HttpStatusCode: %d, Details: %s", httpStatusCode, msg));
    }
}
