package com.navi.actions;

import com.navi.core.BrowserInit;
import com.navi.core.waits.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static com.navi.pages.BasePage.*;

public class BaseAction {

    WebDriver driver;
    Waits waits;

    public BaseAction() {
        this.driver = BrowserInit.getDriver();
        this.waits = new Waits();
    }

    public BaseAction navigateUrl() {
        //String url = System.getProperty("BASE_URL");
        String url = "https://makemytrip.com";
        driver.get(url);
        return this;
    }

    public BaseAction hasLoaded() {
        waits.waitForExpectedConditionsOr(
                ExpectedConditions.visibilityOfElementLocated(fromLabel),
                ExpectedConditions.visibilityOfElementLocated(toLabel)
        );
        return this;
    }

    public BaseAction enterFromCity(String cityName) {
        waits.presenceOfElementLocatedBy(fromLabel).click();
        waits.presenceOfElementLocatedBy(placeHolderField("From")).sendKeys(cityName);

        List<WebElement> cities = waits.presenceOfAllElementsLocatedBy(autoSuggestionList);

        cities.stream()
                .filter(city -> city.getText().contains(cityName))
                .findFirst()
                .orElseThrow(() ->  new RuntimeException("City not found"));

        return this;
    }

    public BaseAction enterToCity(String cityName) {
        waits.presenceOfElementLocatedBy(toLabel).sendKeys(cityName);
        List<WebElement> cities = waits.presenceOfAllElementsLocatedBy(autoSuggestionList);

        cities.stream()
                .filter(city -> city.getText().contains(cityName))
                .findFirst()
                .orElseThrow(() ->  new RuntimeException("City not found"));

        return this;
    }

    public BaseAction search() {
        waits.presenceOfElementLocatedBy(searchButton).click();
        return this;
    }
}
