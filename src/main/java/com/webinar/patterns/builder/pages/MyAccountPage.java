package com.webinar.patterns.builder.pages;

import com.webinar.patterns.builder.basetest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends AbstractPage {

    //
    // WebElements
    //
    @FindBy(xpath = "//a[@title='Information']")
    private WebElement informationLink;

    /**
     * Constructor
     *
     * @param testClass
     */
    public MyAccountPage(BaseTest testClass) {
        super(testClass);
        waitTillElementIsVisible(pageDiv);
    }

    /**
     * Click 'My Addresses' button
     *
     * @return instance of AddressesPage
     */
    public PersonalInformationPage clickMyPersonalInformationButton() {
        waitTillElementIsVisible(informationLink);
        informationLink.click();
        return new PersonalInformationPage(testClass);
    }
}
