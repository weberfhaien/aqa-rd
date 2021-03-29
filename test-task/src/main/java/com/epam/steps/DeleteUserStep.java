package com.epam.steps;

import com.epam.enumeration.ControllerPath;
import com.epam.services.rest.impl.HttpClientImpl;
import com.fasterxml.jackson.databind.JsonNode;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.assertTrue;

public class DeleteUserStep {

    private HttpClientImpl httpClient = new HttpClientImpl();
    private JsonNode node;
    private String url;
    private String response;

    @Given("I want to execute deleteUser endpoint with user id ${userId}")
    public void createEndpoint(Integer userId) {
        url = ControllerPath.GET_BASE_URL.getPath().concat(ControllerPath.GET_SINGLE_USER.getPath()
                .replace("{user_id}", String.valueOf(userId)));
    }

    @When("I submit the DELETE request and check that the status code is ${statusCode}")
    public void submitGetRequest(int statusCode) {
        response = httpClient.delete(url, statusCode);
    }

    @Then("I check that the response body is empty after DELETE request")
    public void checkResponseBody() {
        assertTrue(response.isEmpty());
    }
}
