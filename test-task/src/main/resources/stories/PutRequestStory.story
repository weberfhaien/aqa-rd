Meta: Verify API

Scenario: PUT request
Given I want to execute updateUser endpoint with user id 2
When I set a new name name or a new job job
When I submit the PUT request and check that the status code is 200
Then I check that the response body is not empty after PUT request