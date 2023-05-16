package org.example.ui.steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.messages.internal.com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import org.example.ui.page_objects.DuckDuckGoHomePage;
import org.example.ui.page_objects.DuckDuckGoSearchResultsPage;

import static com.codeborne.selenide.Condition.*;

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

    public int getResultsAmount() {
        return page.getResultsList().size();
    }

    public void verifyImagesSearchResultsAreOpen() {
        page.getResultsTypeList().findBy(attribute("data-zci-link", "images"))
                .shouldHave(attributeMatching("class", "is-active"));
    }

}
