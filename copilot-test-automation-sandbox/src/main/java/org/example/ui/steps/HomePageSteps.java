package org.example.ui.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.example.ui.page_objects.DuckDuckGoHomePage;

import static com.codeborne.selenide.Condition.visible;

public class HomePageSteps {

    private DuckDuckGoHomePage homePage;

    public HomePageSteps() {
        this.homePage = new DuckDuckGoHomePage();
    }

    public void search(String searchRequest) {
        homePage.getInput()
                .shouldBe(visible)
                .val(searchRequest)
                .pressEnter();
    }

    public void openHomePage() {
        Selenide.open();
    }
}
