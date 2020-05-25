package com.webinar.patterns.factory.basetest;

import com.webinar.patterns.factory.interfaces.DriverInterface;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;

public class NewChromeDriver implements DriverInterface {

    /**
     * Get driver
     *
     * @return instance of new Chrome driver
     */
    @Override
    public WebDriver driver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption(
                "excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);

        return new ChromeDriver(options);
    }
}
