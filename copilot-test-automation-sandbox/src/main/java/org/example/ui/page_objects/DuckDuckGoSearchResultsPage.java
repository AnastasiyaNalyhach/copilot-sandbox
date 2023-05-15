package org.example.ui.page_objects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.*;

@Getter
public class DuckDuckGoSearchResultsPage {
    private final ElementsCollection resultsList = $$x("//article");
    private final SelenideElement firstResult = $$x("//article").first();
    private final ElementsCollection resultsListTitles =  $$x("//article/div/h2");
    private final SelenideElement resultsBar =  $("#duckbar");
    private final ElementsCollection resultsTypeList =  $$x("//ul[@id='duckbar_static']/li");
}
