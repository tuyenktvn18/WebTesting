package com.practice.api;

import com.practice.config.factory.ApiConfigFactory;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public final class BaseRequestSpec {

    private BaseRequestSpec() {
    }

    private static final String BASE_URL = ApiConfigFactory.getConfig().apiBaseUrl();

    public static RequestSpecification getDefaultRequestSpec() {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL);
    }

}
