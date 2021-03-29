package com.epam.steps;

import com.epam.enumeration.ControllerPath;
import com.epam.request.CreateUserRequest;
import com.epam.response.CreateUserResponse;
import com.epam.services.rest.impl.HttpClientImpl;
import com.epam.utils.JsonUtils;
import com.fasterxml.jackson.databind.JsonNode;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

import static org.junit.Assert.assertEquals;

public class CreateUserStep extends Steps {

    private HttpClientImpl httpClient = new HttpClientImpl();
    private CreateUserRequest userRequest;
    private JsonNode node;
    private String url;
    private String response;

    @Given("I want to execute createUser endpoint")
    public void createEndpoint() {
        url = ControllerPath.GET_BASE_URL.getPath().concat(ControllerPath.GET_LIST_USERS.getPath());
    }

    @When("I create a user with name ${name} and job ${job}")
    public void createUser(String name, String job) {
        userRequest = new CreateUserRequest(name, job);
    }

    @When("I submit the POST request and check that the status code is ${statusCode}")
    public void submitGetRequest(int statusCode) {
        response = httpClient.post(url, userRequest, statusCode);
    }

    @Then("I check that the response body is not empty after POST request")
    public void checkResponseBody() {
        node = JsonUtils.parse(response);
        CreateUserResponse usersResponse = JsonUtils.fromJson(node, CreateUserResponse.class);
        assertEquals(userRequest.getJob(), usersResponse.getJob());
        assertEquals(userRequest.getName(), usersResponse.getName());
    }
}
