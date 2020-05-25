package com.webinar.patterns.builder.pages;

import com.webinar.patterns.builder.basetest.BaseTest;
import com.webinar.patterns.builder.utils.UserData;
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
     * @param userData
     */
    public void verifyPersonalInformation(UserData userData) {
        waitTillElementIsVisible(firstNameInput);
        Assert.assertEquals("Expected and actual first names are not the same",
                userData.getFirstName(), firstNameInput.getAttribute("value"));
        Assert.assertEquals("Expected and actual last names are not the same",
                userData.getLastName(), lastNameInput.getAttribute("value"));
        Assert.assertEquals("Expected and actual emails are not the same",
                userData.getEmail(), emailInput.getAttribute("value"));
    }
}
