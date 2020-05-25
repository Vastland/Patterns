package com.webinar.patterns.factory.pages;

import com.webinar.patterns.factory.basetest.BaseTest;
import com.webinar.patterns.factory.utils.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
     * Fill all information about user and click 'Register' button
     *
     * @param userData
     * @return instance of MyAccountPage
     */
    public MyAccountPage fillInAllInfoAndClickRegister(UserData userData) {
        fillInPersonalInfo(userData);
        fillInAddress(userData);
        return clickRegisterButton();
    }

    /**
     * Fill in personal information about user
     *
     * @param userData
     */
    public void fillInPersonalInfo(UserData userData) {
        waitTillElementIsVisible(titleLabel);
        if (userData.getTitle() != null) {
            if (userData.getTitle().equalsIgnoreCase("mr")) {
                mrMaleGenderRadioButton.click();
            } else {
                mrsFemaleGenderRadioButton.click();
            }
        }
        if (userData.getFirstName() != null) {
            firstNameInput.sendKeys(userData.getFirstName());
        }
        if (userData.getLastName() != null) {
            lastNameInput.sendKeys(userData.getLastName());
        }
        if (userData.getPassword() != null) {
            passwordInput.sendKeys(userData.getPassword());
        }
        if (userData.getDateOfBirth() != null) {
            clickDropDownAndSelect(DAYS_DROPDONW_XPATH, userData.getDateOfBirth().get("day"));
            clickDropDownAndSelect(MONTHS_DROPDONW_XPATH, userData.getDateOfBirth().get("month"));
            clickDropDownAndSelect(YEARS_DROPDONW_XPATH, userData.getDateOfBirth().get("year"));
        }
    }

    /**
     * Fill in address information about user
     *
     * @param userData
     */
    public void fillInAddress(UserData userData) {
        waitTillElementIsVisible(titleLabel);
        if (userData.getCompany() != null) {
            companyInput.sendKeys(userData.getCompany());
        }
        if (userData.getAddress() != null) {
            addressInput.sendKeys(userData.getAddress());
        }
        if (userData.getCity() != null) {
            cityInput.sendKeys(userData.getCity());
        }
        if (userData.getCountry() != null) {
            clickDropDownAndSelect(COUNTRIES_DROPDONW_XPATH, userData.getCountry());
        }
        if (userData.getState() != null) {
            clickDropDownAndSelect(STATES_DROPDONW_XPATH, userData.getState());
        }
        if (userData.getZip() != null) {
            postcodeInput.sendKeys(userData.getZip());
        }
        if (userData.getMobilePhone() != null) {
            mobilePhoneInput.sendKeys(userData.getMobilePhone());
        }
        if (userData.getAlias() != null) {
            aliasInput.clear();
            aliasInput.sendKeys(userData.getAlias());
        }
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
