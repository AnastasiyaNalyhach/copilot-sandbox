package org.example.ui.page_objects;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class DuckDuckGoHomePage {
    private final SelenideElement input = $(Selectors.byId("searchbox_input"));
}
