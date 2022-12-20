package com.klozevitz.sportwithme2_0.utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class RestControllersUtilities {
    public static String getJson(Object resp) {
        GsonBuilder builder = new GsonBuilder();
        Gson response = builder.create();
        return response.toJson(resp);
    }
}
