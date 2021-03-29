Meta: Verify API

Scenario: PATCH request
Given I want to execute updateNameAndJob endpoint with user id 2
When I set a new name name and a new job job
When I submit the PATCH request and check that the status code is 200
Then I check that the response body is not empty after PATCH request