package com.webinar.patterns.singleton.basetest;

import com.webinar.patterns.singleton.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class BaseTest {

    // Instance of WebDriver and WebDriverWait
    private WebDriverWait wait;
    private WebDriver driver;

    /**
     * Constructor
     */
    public BaseTest() {
        SingletonDriver singletonDriver = SingletonDriver.getInstance();
        driver = singletonDriver.getDriver();

        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    /**
     * Return instance of Driver
     *
     * @return WebDriver
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Return instance of WebDriverWait
     *
     * @return WebDriverWait
     */
    public WebDriverWait getWait() {
        return wait;
    }

    /**
     * Open site and return instance of HomePage
     *
     * @return HomePage
     */
    public HomePage openSite() {
        driver.get("http://automationpractice.com/");
        return new HomePage(this);
    }

    /**
     * Close site with driver.quit()
     */
    public void closeSite() {
        driver.quit();
    }

    /**
     * Generate new fake email for registration
     *
     * @return string that represents email
     */
    public String generateEmail() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString() + "@test.com";
    }
}
