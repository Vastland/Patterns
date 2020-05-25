package com.webinar.patterns.pageobject.pages;

import com.webinar.patterns.pageobject.basetest.BaseTest;

public class HomePage extends AbstractPage {

    /**
     * Constructor
     *
     * @param testClass
     */
    public HomePage(BaseTest testClass) {
        super(testClass);
        waitTillElementIsVisible("//div[@id='page']");
    }
}