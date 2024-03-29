package com.example.demo.common.util;

import com.example.demo.common.constants.HttpConstants;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

public class HttpApiInvokerHandler {

    public static boolean isGetRequest(HttpServletRequest request) {
        String method = request.getMethod();
        return Objects.equals(HttpConstants.HTTP_GET,method);
    }

    public static boolean isPostRequest(HttpServletRequest request) {
        String method = request.getMethod();
        return Objects.equals(HttpConstants.HTTP_POST,method);
    }
}
