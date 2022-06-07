package com.navi.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

public class WebDriverThread {
    
    private WebDriver driver;
    
    public WebDriver getDriver() {
        if (Objects.isNull(driver)) {
            String browserType = getEffectiveBrowser();

            switch (browserType) {
                case "CHROME":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "FIREFOX":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                default:
                    throw new RuntimeException("This framework does not support given browserType.");
            }
        }
        return driver;
    }

    private static String getEffectiveBrowser() {
        if (Objects.nonNull(System.getProperty("BROWSER"))) {
            return System.getProperty("BROWSER").toUpperCase();
        }
        return "CHROME";
    }
    
    public void quitDriver() {
        if (Objects.nonNull(driver)) {
            driver.quit();
        }
    }
}
