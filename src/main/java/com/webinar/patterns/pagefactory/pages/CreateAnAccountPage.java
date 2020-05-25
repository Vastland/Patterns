package com.webinar.patterns.pagefactory.pages;

import com.webinar.patterns.pagefactory.basetest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class CreateAnAccountPage extends AbstractPage {

    //
    // WebElements
    //
    @FindBy(xpath = "//label[.='Title']")
    private WebElement titleLabel;

    @FindBy(xpath = "//input[@id='id_gender1']")
    private WebElement mrMaleGenderRadioButton;

    @FindBy(xpath = "//input[@id='id_gender2']")
    private WebElement mrsFemaleGenderRadioButton;

    @FindBy(xpath = "//input[@id='customer_firstname']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='customer_lastname']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='company']")
    private WebElement companyInput;

    @FindBy(xpath = "//input[@id='address1']")
    private WebElement addressInput;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement cityInput;

    @FindBy(xpath = "//input[@id='postcode']")
    private WebElement postcodeInput;

    @FindBy(xpath = "//input[@id='phone_mobile']")
    private WebElement mobilePhoneInput;

    @FindBy(xpath = "//input[@id='alias']")
    private WebElement aliasInput;

    @FindBy(xpath = "//button[@id='submitAccount']")
    private WebElement registerButton;

    //
    // String that represent xpath for elements
    //
    private static final String DAYS_DROPDONW_XPATH = "//select[@id='days']/option[@value='%s']";
    private static final String MONTHS_DROPDONW_XPATH = "//select[@id='months']/option[@value='%s']";
    private static final String YEARS_DROPDONW_XPATH = "//select[@id='years']/option[@value='%s']";
    private static final String STATES_DROPDONW_XPATH = "//select[@id='id_state']/option[.='%s']";
    private static final String COUNTRIES_DROPDONW_XPATH = "//select[@id='id_country']/option[.='%s']";

    /**
     * Constructor
     *
     * @param testClass
     */
    public CreateAnAccountPage(BaseTest testClass) {
        super(testClass);
        waitTillElementIsVisible(pageDiv);
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
        waitTillElementIsVisible(titleLabel);
        if (title.equalsIgnoreCase("mr")) {
            mrMaleGenderRadioButton.click();
        } else {
            mrsFemaleGenderRadioButton.click();
        }
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        passwordInput.sendKeys(password);
        clickDropDownAndSelect(DAYS_DROPDONW_XPATH, dateOfBirth.get("day"));
        clickDropDownAndSelect(MONTHS_DROPDONW_XPATH, dateOfBirth.get("month"));
        clickDropDownAndSelect(YEARS_DROPDONW_XPATH, dateOfBirth.get("year"));
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
        waitTillElementIsVisible(titleLabel);
        companyInput.sendKeys(company);
        addressInput.sendKeys(address);
        cityInput.sendKeys(city);
        clickDropDownAndSelect(STATES_DROPDONW_XPATH, state);
        postcodeInput.sendKeys(zip);
        clickDropDownAndSelect(COUNTRIES_DROPDONW_XPATH , country);
        mobilePhoneInput.sendKeys(mobilePhone);
        aliasInput.clear();
        aliasInput.sendKeys(alias);
    }

    /**
     * Click 'Register' button
     *
     * @return instance of MyAccountPage
     */
    public MyAccountPage clickRegisterButton() {
        waitTillElementIsVisible(registerButton);
        registerButton.click();
        return new MyAccountPage(testClass);
    }

    /**
     * Click dropdown and select exact option
     *
     * @param dropdownXpath
     * @param option
     */
    private void clickDropDownAndSelect(String dropdownXpath, String option) {
        waitTillElementIsVisible(testClass.getDriver().findElement(By.xpath(String.format(dropdownXpath, option))));
        testClass.getDriver().findElement(By.xpath(String.format(dropdownXpath, option))).click();
    }
}
