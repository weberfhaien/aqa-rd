package com.epam.steps;

import com.epam.enumeration.ControllerPath;
import com.epam.request.UpdateUserRequest;
import com.epam.response.UpdateUserResponse;
import com.epam.services.rest.impl.HttpClientImpl;
import com.epam.utils.JsonUtils;
import com.fasterxml.jackson.databind.JsonNode;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.assertEquals;

public class UpdateUserStep {

    private HttpClientImpl httpClient = new HttpClientImpl();
    private UpdateUserRequest userRequest;
    private JsonNode node;
    private String url;
    private String response;

    @Given("I want to execute updateUser endpoint with user id ${userId}")
    public void createEndpoint(Integer userId) {
        url = ControllerPath.GET_BASE_URL.getPath().concat(ControllerPath.GET_SINGLE_USER.getPath()
                .replace("{user_id}", String.valueOf(userId)));
    }

    @When("I set a new name ${name} or a new job ${job}")
    public void createUser(String name, String job) {
        userRequest = new UpdateUserRequest(name, job);
    }

    @When("I submit the PUT request and check that the status code is ${statusCode}")
    public void submitGetRequest(int statusCode) {
        response = httpClient.put(url, userRequest, statusCode);
    }

    @Then("I check that the response body is not empty after PUT request")
    public void checkResponseBody() {
        node = JsonUtils.parse(response);
        UpdateUserResponse usersResponse = JsonUtils.fromJson(node, UpdateUserResponse.class);
        assertEquals(userRequest.getJob(), usersResponse.getJob());
        assertEquals(userRequest.getName(), usersResponse.getName());
    }
}
