package com.cashonline.util;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component("util")
public class Util {
    
    public HttpHeaders getHeaders(String request) {
        HttpHeaders header = new HttpHeaders();
        header.add("request", request);
        return header;
    }
}
