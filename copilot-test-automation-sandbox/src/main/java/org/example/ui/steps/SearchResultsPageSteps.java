package org.example.ui.steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import io.cucumber.messages.internal.com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import org.example.ui.page_objects.DuckDuckGoHomePage;
import org.example.ui.page_objects.DuckDuckGoSearchResultsPage;

import static com.codeborne.selenide.Condition.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SearchResultsPageSteps {

    private DuckDuckGoSearchResultsPage page;

    public SearchResultsPageSteps() {
        this.page = new DuckDuckGoSearchResultsPage();
    }

    public void openImagesResults() {
        page.getResultsTypeList().findBy(attribute("data-zci-link", "images"))
                .shouldBe(visible, interactable)
                .click();
    }

    public void openLinksResults() {
        page.getResultsTypeList().findBy(attribute("data-zci-link", "images"))
                .shouldBe(visible, interactable)
                .click();
    }

    public void openVideosResults() {
        page.getResultsTypeList().findBy(attribute("data-zci-link", "videos"))
                .shouldBe(visible, interactable)
                .click();
    }

    public void openNewsResults() {
        page.getResultsTypeList().findBy(attribute("data-zci-link", "news"))
                .shouldBe(visible, interactable)
                .click();
    }

    public int getResultsAmount() {
        return page.getResultsList().size();
    }

    public void verifyLinksSearchResultsAreOpen() {
        page.getResultsTypeList().findBy(attribute("data-zci-link", "web"))
                .shouldHave(attributeMatching("class", "is-active"));
    }

    public void verifyImagesSearchResultsAreOpen() {
        page.getResultsTypeList().findBy(attribute("data-zci-link", "images"))
                .shouldHave(attributeMatching("class", "is-active"));
    }

    public void verifyVideosSearchResultsAreOpen() {
        page.getResultsTypeList().findBy(attribute("data-zci-link", "videos"))
                .shouldHave(attributeMatching("class", "is-active"));
    }

    public void verifyNewsSearchResultsAreOpen() {
        page.getResultsTypeList().findBy(attribute("data-zci-link", "news"))
                .shouldHave(attributeMatching("class", "is-active"));
    }

    public void verifySearchResultsAreOpen() {
        page.getResultsTypeList().findBy(attribute("data-zci-link", "web"))
                .shouldHave(attributeMatching("class", "is-active"));
    }

    public void verifyNoResultsAreFound() {
        var msg = page.getNoResultsMessage();
        assertThat(msg).as("No results message should be displayed").isNotNull();
    }

    public void verifyResultsAreFound() {
        page.getResultsList().shouldHave(CollectionCondition.sizeGreaterThan(0));
    }
}
