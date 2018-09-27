package com.huawei.frs.common;

import com.alibaba.fastjson.JSONObject;

public class AddExternalFields {
    private JSONObject externalFields;

    public AddExternalFields() {
        externalFields = new JSONObject();
    }

    public void addField(String key, Object value) {
        externalFields.put(key, value);
    }

    public JSONObject getExternalFields() {
        return externalFields;
    }
}
