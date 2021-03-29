package com.epam.services.data.api;

import com.epam.request.CreateUserRequest;
import com.epam.request.UpdateUserRequest;
import com.epam.response.CreateUserResponse;
import com.epam.response.ListUsersResponse;
import com.epam.response.UpdateUserResponse;

public interface UserDataProvider {

    ListUsersResponse getUsers(int statusCode);

    CreateUserResponse createUser(CreateUserRequest user, int statusCode);

    UpdateUserResponse updateUser(UpdateUserRequest user, Integer userId, int statusCode);

    UpdateUserResponse updateNameAndJob(UpdateUserRequest user, Integer userId, int statusCode);

    String deleteUser(Integer userId, int statusCode);
}
