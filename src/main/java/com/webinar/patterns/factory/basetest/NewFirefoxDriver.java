package com.webinar.patterns.factory.basetest;

import com.webinar.patterns.factory.interfaces.DriverInterface;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewFirefoxDriver implements DriverInterface {

    /**
     * Get driver
     *
     * @return instance of new Firefox driver
     */
    @Override
    public WebDriver driver() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        return new FirefoxDriver();
    }
}
