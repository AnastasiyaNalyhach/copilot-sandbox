package org.example.ui.steps_definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.ui.steps.HomePageSteps;
import org.example.ui.steps.SearchResultsPageSteps;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HomePageStepsDefinitions {

    private HomePageSteps homePageSteps;
    private SearchResultsPageSteps searchResultsPageSteps;

    public HomePageStepsDefinitions(HomePageSteps homePageSteps, SearchResultsPageSteps searchResultsPageSteps) {
        this.homePageSteps = homePageSteps;
        this.searchResultsPageSteps = searchResultsPageSteps;
    }

    @Given("user opens home page")
    public void userOpensHomePage() {
        homePageSteps.openHomePage();
    }

    @When("user searches for {string}")
    public void userSearchesForTest(String searchRequest) {
        homePageSteps.search(searchRequest);
    }

    @Then("at least {int} result is found")
    public void atLeastResultIsFound(int minResultsAmount) {
        assertThat(searchResultsPageSteps.getResultsAmount()).as("User should see at least %s result".formatted(minResultsAmount))
                .isGreaterThan(minResultsAmount);
    }

    @When("user opens links results")
    public void userOpensImagesResults() {
        searchResultsPageSteps.openImagesResults();
    }
}
