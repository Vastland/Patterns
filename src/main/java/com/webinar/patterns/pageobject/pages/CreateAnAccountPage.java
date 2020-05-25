package com.webinar.patterns.pageobject.pages;

import com.webinar.patterns.pageobject.basetest.BaseTest;
import org.openqa.selenium.By;

import java.util.Map;

public class CreateAnAccountPage extends AbstractPage {

    /**
     * Constructor
     *
     * @param testClass
     */
    public CreateAnAccountPage(BaseTest testClass) {
        super(testClass);
        waitTillElementIsVisible("//div[@id='page']");
    }

    /**
     * Fill in personal information about user
     *
     * @param title
     * @param firstName
     * @param lastName
     * @param password
     * @param dateOfBirth
     */
    public void fillInPersonalInfo(String title, String firstName, String lastName,
                                   String password, Map<String, String> dateOfBirth) {
        waitTillElementIsVisible("//label[.='Title']");
        if (title.equalsIgnoreCase("mr")) {
            testClass.getDriver().findElement(By.xpath("//input[@id='id_gender1']")).click();
        } else {
            testClass.getDriver().findElement(By.xpath("//input[@id='id_gender2']")).click();
        }
        testClass.getDriver().findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys(firstName);
        testClass.getDriver().findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys(lastName);
        testClass.getDriver().findElement(By.xpath("//input[@id='passwd']")).sendKeys(password);
        clickDropDownAndSelect("//select[@id='days']/option[@value='%s']", dateOfBirth.get("day"));
        clickDropDownAndSelect("//select[@id='months']/option[@value='%s']", dateOfBirth.get("month"));
        clickDropDownAndSelect("//select[@id='years']/option[@value='%s']", dateOfBirth.get("year"));
    }

    /**
     * Fill in address information about user
     *
     * @param company
     * @param address
     * @param city
     * @param state
     * @param zip
     * @param country
     * @param mobilePhone
     * @param alias
     */
    public void fillInAddress(String company, String address, String city, String state, String zip, String country,
                              String mobilePhone, String alias) {
        waitTillElementIsVisible("//label[.='Title']");
        testClass.getDriver().findElement(By.xpath("//input[@id='company']")).sendKeys(company);
        testClass.getDriver().findElement(By.xpath("//input[@id='address1']")).sendKeys(address);
        testClass.getDriver().findElement(By.xpath("//input[@id='city']")).sendKeys(city);
        clickDropDownAndSelect("//select[@id='id_state']/option[.='%s']", state);
        testClass.getDriver().findElement(By.xpath("//input[@id='postcode']")).sendKeys(zip);
        clickDropDownAndSelect("//select[@id='id_country']/option[.='%s']", country);
        testClass.getDriver().findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys(mobilePhone);
        testClass.getDriver().findElement(By.xpath("//input[@id='alias']")).clear();
        testClass.getDriver().findElement(By.xpath("//input[@id='alias']")).sendKeys(alias);
    }

    /**
     * Click 'Register' button
     *
     * @return instance of MyAccountPage
     */
    public MyAccountPage clickRegisterButton() {
        waitTillElementIsVisible("//button[@id='submitAccount']");
        testClass.getDriver().findElement(By.xpath("//button[@id='submitAccount']")).click();
        return new MyAccountPage(testClass);
    }

    /**
     * Click dropdown and select exact option
     *
     * @param dropdownXpath
     * @param option
     */
    private void clickDropDownAndSelect(String dropdownXpath, String option) {
        waitTillElementIsVisible(String.format(dropdownXpath, option));
        testClass.getDriver().findElement(By.xpath(String.format(dropdownXpath, option))).click();
    }
}
