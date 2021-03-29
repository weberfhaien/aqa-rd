Meta: Verify API

Scenario: GET request
Given I want to execute getListUsers endpoint
When I submit the GET request and check that the status code is 200
Then I check that the response body is not empty after GET request