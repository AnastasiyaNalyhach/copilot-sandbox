package org.example.ui.page_objects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class DuckDuckGoHomePage {
    private final SelenideElement input = $(Selectors.byId("searchbox_input"));
    private ElementsCollection languageList;

    public SelenideElement getLanguageButton() {
        return null;
    }

    public ElementsCollection getLanguageList() {
        return languageList;
    }

    public void setLanguageList(ElementsCollection languageList) {
        this.languageList = languageList;
    }
}
