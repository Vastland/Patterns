package com.webinar.patterns.pageobject.pages;

import com.webinar.patterns.pageobject.basetest.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;

public class PersonalInformationPage extends AbstractPage {

    /**
     * Constructor
     *
     * @param testClass
     */
    public PersonalInformationPage(BaseTest testClass) {
        super(testClass);
    }

    /**
     * Verify whether or not information about user is correct
     *
     * @param expectedFirstName
     * @param expectedLastName
     * @param expectedEmail
     */
    public void verifyPersonalInformation(String expectedFirstName, String expectedLastName, String expectedEmail) {
        waitTillElementIsVisible("//input[@id='firstname']");
        String actualFirstName = testClass.getDriver().findElement(By.xpath("//input[@id='firstname']")).getAttribute("value");
        String actualLastName = testClass.getDriver().findElement(By.xpath("//input[@id='lastname']")).getAttribute("value");
        String actualEmail = testClass.getDriver().findElement(By.xpath("//input[@id='email']")).getAttribute("value");
        Assert.assertEquals("Expected and actual first names are not the same",
                expectedFirstName, actualFirstName);
        Assert.assertEquals("Expected and actual last names are not the same",
                expectedLastName, actualLastName);
        Assert.assertEquals("Expected and actual emails are not the same",
                expectedEmail, actualEmail);
    }
}
