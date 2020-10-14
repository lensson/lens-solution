package com.lens.wx.gzh.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Desc:
 *
 * @author Lens Chen
 * @created 2020-10-13 2:24 PM
 */
public class JsonUtils {
    public static String toJson(Object obj) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(obj);
    }
}
