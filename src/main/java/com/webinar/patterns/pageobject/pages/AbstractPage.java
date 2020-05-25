package com.webinar.patterns.pageobject.pages;

import com.webinar.patterns.pageobject.basetest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AbstractPage {

    // Instance of BaseTest
    protected BaseTest testClass;

    /**
     * Constructor
     */
    public AbstractPage(BaseTest testClass) {
        this.testClass = testClass;
        waitTillElementIsVisible("//div[@id='page']");
    }

    /**
     * Click on 'Sign in' link
     *
     * @return instance of SignInPage
     */
    public SignInPage clickSignInLink() {
        waitTillElementIsVisible("//a[@class='login']");
        testClass.getDriver().findElement(By.xpath("//a[@class='login']")).click();
        return new SignInPage(testClass);
    }

    /**
     * Wait till xpath is visible
     *
     * @param xpath
     */
    protected void waitTillElementIsVisible(String xpath) {
        testClass.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

}
