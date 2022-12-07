package com.klozevitz.sportwithme2_0.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OnLoadController {
    @GetMapping("/onLoad")
    public String onLoad() {
        return getJson(SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString());
    }

    private String getJson(Object resp) {
        GsonBuilder builder = new GsonBuilder();
        Gson response = builder.create();
        return response.toJson(resp);
    }
}