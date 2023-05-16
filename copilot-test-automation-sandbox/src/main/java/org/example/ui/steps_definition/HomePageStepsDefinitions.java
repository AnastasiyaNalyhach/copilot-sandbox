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

    @When("user clicks on {string} link")
    public void userClicksOnLink(String linkName) {
        switch (linkName) {
            case "Images":
                searchResultsPageSteps.openImagesResults();
                break;
            case "Videos":
                searchResultsPageSteps.openVideosResults();
                break;
            case "News":
                searchResultsPageSteps.openNewsResults();
                break;
            case "All":
                searchResultsPageSteps.openLinksResults();
                break;
            default:
                throw new IllegalArgumentException("Unknown link name: " + linkName);
        }
    }

    @Then("user sees {string} search results")
    public void userSeesSearchResults(String linkName) {
        switch (linkName) {
            case "Images":
                searchResultsPageSteps.verifyImagesSearchResultsAreOpen();
                break;
            case "Videos":
                searchResultsPageSteps.verifyVideosSearchResultsAreOpen();
                break;
            case "News":
                searchResultsPageSteps.verifyNewsSearchResultsAreOpen();
                break;
            case "All":
                searchResultsPageSteps.verifyLinksSearchResultsAreOpen();
                break;
            default:
                throw new IllegalArgumentException("Unknown link name: " + linkName);
        }
    }

    @When("user searches for {string} in {string}")
    public void userSearchesForTestInAll(String searchRequest, String linkName) {
        switch (linkName) {
            case "Images":
                searchResultsPageSteps.openImagesResults();
                break;
            case "Videos":
                searchResultsPageSteps.openVideosResults();
                break;
            case "News":
                searchResultsPageSteps.openNewsResults();
                break;
            case "All":
                searchResultsPageSteps.openLinksResults();
                break;
            default:
                throw new IllegalArgumentException("Unknown link name: " + linkName);
        }
        homePageSteps.search(searchRequest);
    }

    @When("user changes search language to {string}")
    public void userChangesSearchLanguageTo(String language) {
        homePageSteps.changeLanguage(language);
    }

    @Then("user sees search language is {string}")
    public void userSeesSearchLanguageIs(String language) {
        assertThat(homePageSteps.getSearchLanguage()).isEqualTo(language);
    }
}
