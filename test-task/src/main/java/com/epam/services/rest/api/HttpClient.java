package com.epam.services.rest.api;

public interface HttpClient {

    String get(String url, int statusCode);

    String post(String url, Object body, int statusCode);

    String put(String url, Object body, int statusCode);

    String patch(String url, Object body, int statusCode);

    String delete(String url, int statusCode);
}
