package com.webinar.patterns.singleton.pages;

import com.webinar.patterns.singleton.basetest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends AbstractPage {

    //
    // WebElements
    //
    @FindBy(xpath = "//input[@id='email_create']")
    private WebElement emailInput;

    @FindBy(xpath = "//button[@id='SubmitCreate']")
    private WebElement createAnAccountButton;

    /**
     * Constructor
     *
     * @param testClass
     */
    public SignInPage(BaseTest testClass) {
        super(testClass);
        waitTillElementIsVisible(pageDiv);
    }

    /**
     * Fill email address and click 'Create an account link'
     *
     * @return instance of CreateAnAccountPage
     */
    public CreateAnAccountPage createAnAccount(String email) {
        waitTillElementIsVisible(emailInput);
        emailInput.sendKeys(email);
        createAnAccountButton.click();
        return new CreateAnAccountPage(testClass);
    }
}
