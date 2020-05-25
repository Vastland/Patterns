package com.webinar.patterns.builder.pages;

import com.webinar.patterns.builder.basetest.BaseTest;

public class HomePage extends AbstractPage {

    /**
     * Constructor
     *
     * @param testClass
     */
    public HomePage(BaseTest testClass) {
        super(testClass);
        waitTillElementIsVisible(pageDiv);
    }
}