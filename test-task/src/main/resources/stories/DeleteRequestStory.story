Meta: Verify API

Scenario: DELETE request
Given I want to execute deleteUser endpoint with user id 2
When I submit the DELETE request and check that the status code is 204
Then I check that the response body is empty after DELETE request