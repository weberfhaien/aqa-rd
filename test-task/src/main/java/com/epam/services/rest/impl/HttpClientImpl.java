package com.epam.services.rest.impl;

import com.epam.services.rest.api.HttpClient;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HttpClientImpl implements HttpClient {

    @Override
    public String get(String url, int statusCode) {
        RequestSpecification request = given()
                .header("Content-Type", "application/json");

        Response response = request.log().all().get(url);

        assertEquals(statusCode, response.statusCode());

        return response.asString();
    }

    @Override
    public String post(String url, Object body, int statusCode) {
        RequestSpecification request = given()
                .header("Content-Type", "application/json")
                .body(body);

        Response response = request.log().all().post(url);

        assertEquals(statusCode, response.statusCode(), "Wrong status code for request!");

        return response.asString();
    }

    @Override
    public String put(String url, Object body, int statusCode) {
        RequestSpecification request = given()
                .header("Content-Type", "application/json")
                .body(body);

        Response response = request.log().all().put(url);

        assertEquals(statusCode, response.statusCode(), "Wrong status code for request!");

        return response.asString();
    }

    @Override
    public String patch(String url, Object body, int statusCode) {
        RequestSpecification request = given()
                .header("Content-Type", "application/json")
                .body(body);

        Response response = request.log().all().patch(url);

        assertEquals(statusCode, response.statusCode(), "Wrong status code for request!");

        return response.asString();
    }

    @Override
    public String delete(String url, int statusCode) {
        RequestSpecification request = given()
                .header("Content-Type", "application/json");

        Response response = request.log().all().delete(url);

        assertEquals(statusCode, response.statusCode(), "Wrong status code for request!");

        return response.asString();
    }
}
