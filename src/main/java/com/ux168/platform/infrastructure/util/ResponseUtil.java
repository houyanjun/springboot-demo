package com.ux168.platform.infrastructure.util;

import com.google.gson.Gson;

import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

public class ResponseUtil {

    public static void write(HttpServletResponse response,Object object) {
        try {
            response.getOutputStream().write(new Gson().toJson(object).getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
