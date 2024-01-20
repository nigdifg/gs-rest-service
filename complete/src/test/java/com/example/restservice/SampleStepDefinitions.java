package com.example.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

public class SampleFeatureSteps {

    private HttpStatus responseStatus;
    private RestTemplate restTemplate = new RestTemplate();

    @Given("the Spring Boot application is running")
    public void theSpringBootApplicationIsRunning() {
        // Code to ensure the application is running
        // This might be a simple health check request
    }

    @When("a GET request is made to {string}")
    public void aGETRequestIsMadeTo(String path) {
        try {
            // Code to make GET request
            responseStatus = restTemplate.getForEntity(path, String.class).getStatusCode();
        } catch (HttpClientErrorException e) {
            responseStatus = e.getStatusCode();
        }
    }

    @Then("the response status should be {int}")
    public void theResponseStatusShouldBe(int status) {
        assertEquals(status, responseStatus.value());
    }
}