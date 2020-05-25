package com.webinar.patterns.singleton.basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;

public final class SingletonDriver {

    // Instance of the class
    private static SingletonDriver INSTANCE;

    // Instance of the WebDriver
    private WebDriver driver;

    /**
     * Private constructor that prevent creation of the object outside the class
     */
    private SingletonDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption(
                "excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        driver = new ChromeDriver(options);
    }

    /**
     * Getter that allow to get only one object of class
     *
     * @return instance of SingletonDriver
     */
    public static SingletonDriver getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonDriver();
        }
        return INSTANCE;
    }

    /**
     * Getter for WebDriver
     *
     * @return instance of WebDriver
     */
    public WebDriver getDriver() {
        return driver;
    }
}
