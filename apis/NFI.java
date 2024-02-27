package com.example.ec530;

import java.util.Objects;

public class NFI {
    // News Feed Ingester
    static String fetchNews(String URL, boolean newsFlag) {
        if (Objects.equals(URL, "url") && newsFlag) {
            return "100 Fetch succeed" + "news content";
        } else if (Objects.equals(URL, "url") && !newsFlag) {
            return "403 Desired news not found";
        }
        return "401 Invalid URL";
    }
    static String filter(String keyword, boolean newsFlag) {
        if (Objects.equals(keyword, "key") && newsFlag) {
            return "100 Fetch succeed" + "news content";
        } else if (Objects.equals(keyword, "key") && !newsFlag) {
            return "403 Desired news not found";
        }
        return "401 Invalid keyword";
    }
}
