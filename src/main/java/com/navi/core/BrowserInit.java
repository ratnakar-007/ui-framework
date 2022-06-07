package com.navi.core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.xml.XmlTest;

public class BrowserInit {

    private static ThreadLocal<WebDriverThread> threadLocalDriver;

    @BeforeSuite(alwaysRun = true)
    public static void init(XmlTest test) {
        threadLocalDriver = ThreadLocal.withInitial(() -> {
            WebDriverThread driverThread = new WebDriverThread();
            return driverThread;
        });
    }

    public static WebDriver getDriver() {
        return threadLocalDriver.get().getDriver();
    }

    @AfterSuite(alwaysRun = true)
    public static void tearDown() {
        threadLocalDriver.get().quitDriver();
    }
}
