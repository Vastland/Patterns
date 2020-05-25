package com.webinar.patterns.pageobject.pages;

import com.webinar.patterns.pageobject.basetest.BaseTest;
import org.openqa.selenium.By;

public class SignInPage extends AbstractPage {

    /**
     * Constructor
     *
     * @param testClass
     */
    public SignInPage(BaseTest testClass) {
        super(testClass);
        waitTillElementIsVisible("//div[@id='page']");
    }

    /**
     * Fill email address and click 'Create an account link'
     *
     * @return instance of CreateAnAccountPage
     */
    public CreateAnAccountPage createAnAccount(String email) {
        waitTillElementIsVisible("//input[@id='email_create']");
        testClass.getDriver().findElement(By.xpath("//input[@id='email_create']")).sendKeys(email);
        testClass.getDriver().findElement(By.xpath("//button[@id='SubmitCreate']")).click();
        return new CreateAnAccountPage(testClass);
    }
}
