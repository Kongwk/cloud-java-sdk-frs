package com.huawei.frs.common;

import com.alibaba.fastjson.JSONObject;

public class CreateExternalFields {
    private JSONObject externalFields;

    public CreateExternalFields() {
        externalFields = new JSONObject();
    }

    public void addField(String key, FieldType type) {
        JSONObject fieldType = new JSONObject();

        if (type == FieldType.STRING) {
            fieldType.put("type", "string");
        } else if (type == FieldType.INTEGER) {
            fieldType.put("type", "integer");
        } else if (type == FieldType.FLOAT) {
            fieldType.put("type", "float");
        } else if (type == FieldType.DOUBLE) {
            fieldType.put("type", "double");
        } else if (type == FieldType.BOOLEAN) {
            fieldType.put("type", "boolean");
        } else if (type == FieldType.LONG) {
            fieldType.put("type", "long");
        }

        externalFields.put(key, fieldType);
    }

    public JSONObject getExternalFields() {
        return externalFields;
    }
}
