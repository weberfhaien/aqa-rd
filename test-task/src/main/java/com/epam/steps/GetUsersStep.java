package com.epam.steps;

import com.epam.enumeration.ControllerPath;
import com.epam.response.ListUsersResponse;
import com.epam.services.rest.impl.HttpClientImpl;
import com.epam.utils.JsonUtils;
import com.fasterxml.jackson.databind.JsonNode;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

import static org.junit.Assert.assertFalse;

public class GetUsersStep extends Steps {

    private HttpClientImpl httpClient = new HttpClientImpl();
    private JsonNode node;
    private String url;
    private String response;

    @Given("I want to execute getListUsers endpoint")
    public void createEndpoint() {
        url = ControllerPath.GET_BASE_URL.getPath().concat(ControllerPath.GET_LIST_USERS.getPath());
    }

    @When("I submit the GET request and check that the status code is ${statusCode}")
    public void submitGetRequest(int statusCode) {
        response = httpClient.get(url, statusCode);
    }

    @Then("I check that the response body is not empty after GET request")
    public void checkResponseBody() {
        node = JsonUtils.parse(response);
        ListUsersResponse usersResponse = JsonUtils.fromJson(node, ListUsersResponse.class);
        assertFalse(usersResponse.getData().isEmpty());
    }
}
