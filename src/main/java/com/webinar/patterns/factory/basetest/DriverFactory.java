package com.webinar.patterns.factory.basetest;

public class DriverFactory {

    /**
     * Get driver
     *
     * @param driverType
     * @return instance of exact WebDriver
     */
    public Object getDriver(String driverType) {
        if (driverType.equalsIgnoreCase("Chrome")) {
            return new NewChromeDriver().driver();
        } else if (driverType.equalsIgnoreCase("Firefox")) {
            return new NewFirefoxDriver().driver();
        }
        return null;
    }
}
