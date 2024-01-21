Feature: End-to-End Testing of Spring Boot Java Project

    Scenario: Verify the application is up and running
        Given the Spring Boot application is started
        When I make a GET request to the "/api/health" endpoint
        Then the response status should be 200
        And the response body should contain "Application is healthy"

    Scenario: Verify the behavior of a specific API endpoint
        Given the Spring Boot application is started
        When I make a GET request to the "/api/sample" endpoint
        Then the response status should be 200
        And the response body should contain "Expected data from the /api/sample endpoint"

    Scenario: Verify error handling for an invalid API endpoint
        Given the Spring Boot application is started
        When I make a GET request to an invalid endpoint
        Then the response status should be 404
        And the response body should contain "Endpoint not found"