package com.webinar.patterns.pagefactory.pages;

import com.webinar.patterns.pagefactory.basetest.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalInformationPage extends AbstractPage {

    //
    // WebElements
    //
    @FindBy(xpath = "//a[@title='Information']")
    private WebElement informationLink;

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailInput;

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
        waitTillElementIsVisible(firstNameInput);
        Assert.assertEquals("Expected and actual first names are not the same",
                expectedFirstName, firstNameInput.getAttribute("value"));
        Assert.assertEquals("Expected and actual last names are not the same",
                expectedLastName, lastNameInput.getAttribute("value"));
        Assert.assertEquals("Expected and actual emails are not the same",
                expectedEmail, emailInput.getAttribute("value"));
    }
}
