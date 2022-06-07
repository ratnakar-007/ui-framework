package com.navi.pages;

import org.openqa.selenium.By;

public class BasePage {

    public static By fromLabel = By.cssSelector("[for='fromCity']");
    public static By toLabel = By.cssSelector("[for='toCity']");

    public static By placeHolderField(String placeHolderText) {
        return By.cssSelector("[placeholder='" + placeHolderText + "']");
    }

    public static By autoSuggestionList = By.cssSelector(".react-autosuggest__suggestions-list > li");

    public static By searchButton = By.cssSelector(".primaryBtn");
}
