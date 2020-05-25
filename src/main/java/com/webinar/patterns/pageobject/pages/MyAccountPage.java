package com.webinar.patterns.pageobject.pages;

import com.webinar.patterns.pageobject.basetest.BaseTest;
import org.openqa.selenium.By;

public class MyAccountPage extends AbstractPage {

    /**
     * Constructor
     *
     * @param testClass
     */
    public MyAccountPage(BaseTest testClass) {
        super(testClass);
        waitTillElementIsVisible("//div[@id='page']");
    }

    /**
     * Click 'My Addresses' button
     *
     * @return instance of AddressesPage
     */
    public PersonalInformationPage clickMyPersonalInformationButton() {
        waitTillElementIsVisible("//a[@title='Information']");
        testClass.getDriver().findElement(By.xpath("//a[@title='Information']")).click();
        return new PersonalInformationPage(testClass);
    }
}
