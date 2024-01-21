package com.example.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SampleFeatureSteps {

    private ResponseEntity<String> response;
    private RestTemplate restTemplate = new RestTemplate();

    @Given("the Spring Boot application is started")
    public void theSpringBootApplicationIsRunning() {
        // Code to ensure the application is running
        // This might be a simple health check request
        // For example:
        // response = restTemplate.getForEntity("http://localhost:8080/api/health", String.class);
    }

    @When("I make a GET request to the {string} endpoint")
    public void aGETRequestIsMadeTo(String path) {
        try {
            // Code to make GET request
            // For example:
            // response = restTemplate.getForEntity("http://localhost:8080" + path, String.class);
            response = restTemplate.getForEntity(path, String.class);
        } catch (HttpClientErrorException e) {
            response = new ResponseEntity<>(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Then("the response status should be {int}")
    public void theResponseStatusShouldBe(int status) {
        assertEquals(status, response.getStatusCodeValue());
    }

    @Then("the response body should contain {string}")
    public void theResponseBodyShouldContain(String expectedBodyContent) {
        assertTrue(response.getBody().contains(expectedBodyContent));
    }

    @When("I make a GET request to an invalid endpoint")
    public void iMakeAGETRequestToAnInvalidEndpoint() {
        try {
            // Code to make GET request to an invalid endpoint
            // For example:
            // response = restTemplate.getForEntity("http://localhost:8080/invalid/endpoint", String.class);
            response = restTemplate.getForEntity("invalid/endpoint", String.class);
        } catch (HttpClientErrorException e) {
            response = new ResponseEntity<>(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }
}