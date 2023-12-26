package com.practice.api;

import com.practice.dataTest.api.models.UserCred;
import io.restassured.response.Response;

public final class UserRequest {

    private UserRequest() {
    }

    private static final String GET_ALL_USERS_ENDPOINT = "/api/users";
    private static final String GET_SPECIFIC_USER_ENDPOINT = "/api/users/{id}";
    private static final String POST_USERS_ENDPOINT = "/api/users";
    private static final String PUT_USERS_ENDPOINT = "/api/users/{id}";
    private static final String DELETE_USERS_ENDPOINT = "/api/users/{id}";

    public static Response getAllUsers() {
        return BaseRequestSpec
                .getDefaultRequestSpec()
                .queryParam("page", 2)
                .get(GET_ALL_USERS_ENDPOINT);
    }

    public static Response getSpecificUsers(String id) {
        return BaseRequestSpec
                .getDefaultRequestSpec()
                .pathParam("id", id)
                .get(GET_SPECIFIC_USER_ENDPOINT);
    }

    public static Response postUsers(UserCred userCred) {
        return BaseRequestSpec.getDefaultRequestSpec()
                .body(userCred)
                .post(POST_USERS_ENDPOINT);
    }
}
