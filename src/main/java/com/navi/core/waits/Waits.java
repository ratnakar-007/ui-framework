package com.navi.core.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

import static com.navi.core.BrowserInit.getDriver;

public class Waits {

    private static Waits INSTANCE;
    private static Wait<WebDriver> wait;

    public static Waits getInstance() {
        if (Objects.isNull(INSTANCE)) {
            INSTANCE = new Waits();
        }
        return INSTANCE;
    }

    public Waits() {
        wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
    }

    public WebElement presenceOfElementLocatedBy(By seleniumByElement) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(seleniumByElement));
    }

    public List<WebElement> presenceOfAllElementsLocatedBy(By seleniumByElement) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(seleniumByElement));
    }

    public Boolean waitForExpectedConditionsOr(ExpectedCondition<?>... conditions) {
        return wait.until(ExpectedConditions.or(conditions));
    }

}
