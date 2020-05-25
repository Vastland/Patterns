package com.webinar.patterns.singleton.pages;

import com.webinar.patterns.singleton.basetest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AbstractPage {

    // Instance of BaseTest
    protected BaseTest testClass;

    //
    // WebElements
    //
    @FindBy(xpath = "//div[@id='page']")
    protected WebElement pageDiv;

    @FindBy(xpath = "//a[@class='login']")
    private WebElement signInLink;

    /**
     * Constructor
     */
    public AbstractPage(BaseTest testClass) {
        this.testClass = testClass;
        PageFactory.initElements(testClass.getDriver(), this);
        waitTillElementIsVisible(pageDiv);
    }

    /**
     * Click on 'Sign in' link
     *
     * @return instance of SignInPage
     */
    public SignInPage clickSignInLink() {
        waitTillElementIsVisible(signInLink);
        signInLink.click();
        return new SignInPage(testClass);
    }

    /**
     * Wait till xpath is visible
     *
     * @param element
     */
    protected void waitTillElementIsVisible(WebElement element) {
        testClass.getWait().until(ExpectedConditions.visibilityOf(element));
    }

}
