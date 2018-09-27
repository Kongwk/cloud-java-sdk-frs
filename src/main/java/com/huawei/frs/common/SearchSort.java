package com.huawei.frs.common;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class SearchSort {
    private JSONArray searchSort;

    public SearchSort() {
        searchSort = new JSONArray();
    }

    public void addSortField(String key, SortType sortType) {
        JSONObject sortField = new JSONObject();
        if (SortType.ASC == sortType) {
            sortField.put(key, "asc");
        } else {
            sortField.put(key, "desc");
        }
        searchSort.add(sortField);
    }

    public JSONArray getSearchSort() {
        return searchSort;
    }
}
