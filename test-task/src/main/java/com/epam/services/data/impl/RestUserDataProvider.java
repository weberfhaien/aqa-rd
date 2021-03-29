package com.epam.services.data.impl;

import com.epam.enumeration.ControllerPath;
import com.epam.request.CreateUserRequest;
import com.epam.request.UpdateUserRequest;
import com.epam.response.CreateUserResponse;
import com.epam.response.ListUsersResponse;
import com.epam.response.UpdateUserResponse;
import com.epam.services.data.api.UserDataProvider;
import com.epam.services.rest.impl.HttpClientImpl;
import com.epam.utils.JsonUtils;
import com.fasterxml.jackson.databind.JsonNode;

public class RestUserDataProvider implements UserDataProvider {

    private HttpClientImpl httpClient = new HttpClientImpl();
    private JsonNode node;

    @Override
    public ListUsersResponse getUsers(int statusCode) {
        String url = ControllerPath.GET_BASE_URL.getPath().concat(ControllerPath.GET_LIST_USERS.getPath());
        String response = httpClient.get(url, statusCode);
        node = JsonUtils.parse(response);
        return JsonUtils.fromJson(node, ListUsersResponse.class);
    }

    @Override
    public CreateUserResponse createUser(CreateUserRequest user, int statusCode) {
        String url = ControllerPath.GET_BASE_URL.getPath().concat(ControllerPath.GET_LIST_USERS.getPath());
        String response = httpClient.post(url, user, statusCode);
        node = JsonUtils.parse(response);
        return JsonUtils.fromJson(node, CreateUserResponse.class);
    }

    @Override
    public UpdateUserResponse updateUser(UpdateUserRequest user, Integer userId, int statusCode) {
        String url = ControllerPath.GET_BASE_URL.getPath().concat(ControllerPath.GET_SINGLE_USER.getPath()
                .replace("{user_id}", String.valueOf(userId)));
        String response = httpClient.put(url, user, statusCode);
        node = JsonUtils.parse(response);
        return JsonUtils.fromJson(node, UpdateUserResponse.class);
    }

    @Override
    public UpdateUserResponse updateNameAndJob(UpdateUserRequest user, Integer userId, int statusCode) {
        String url = ControllerPath.GET_BASE_URL.getPath().concat(ControllerPath.GET_SINGLE_USER.getPath()
                .replace("{user_id}", String.valueOf(userId)));
        String response = httpClient.patch(url, user, statusCode);
        node = JsonUtils.parse(response);
        return JsonUtils.fromJson(node, UpdateUserResponse.class);
    }

    @Override
    public String deleteUser(Integer userId, int statusCode) {
        String url = ControllerPath.GET_BASE_URL.getPath().concat(ControllerPath.GET_SINGLE_USER.getPath()
                .replace("{user_id}", String.valueOf(userId)));
        return httpClient.delete(url, statusCode);
    }
}
