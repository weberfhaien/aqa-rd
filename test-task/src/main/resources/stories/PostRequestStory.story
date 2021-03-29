Meta: Verify API

Scenario: POST request
Given I want to execute createUser endpoint
When I create a user with name name and job job
When I submit the POST request and check that the status code is 201
Then I check that the response body is not empty after POST request