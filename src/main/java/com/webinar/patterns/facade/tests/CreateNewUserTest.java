package com.webinar.patterns.facade.tests;

import com.webinar.patterns.facade.basetest.BaseTest;
import com.webinar.patterns.facade.pages.*;
import com.webinar.patterns.facade.utils.UserData;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CreateNewUserTest extends BaseTest {

    // Instance of UserData
    private UserData userData;

    /**
     * Set up method
     * Prepare user data fore test
     */
    @Before
    public void setUp() {

        // Generate email
        String email = generateEmail();

        // Prepare user data
        Map<String, String> dateOfBirth = new HashMap<>();
        dateOfBirth.put("day", "29");
        dateOfBirth.put("month", "1");
        dateOfBirth.put("year", "1986");
        userData = new UserData.Builder().setEmail(email).setTitle("Mr").setFirstName("Alexey").setLastName("Test")
                .setPassword("Temp1234@").setDateOfBirth(dateOfBirth).setCompany("Company").setAddress("Some str. 76-12")
                .setCity("New York").setState("New York").setZip("10001").setCountry("United States").setMobilePhone("+10935674513")
                .setAlias("test_alias").build();
    }

    /**
     * Open site, click 'Sign in' button, fill in email,
     * click 'Create An Account' button, fill in information,
     * click 'Register' button, click 'My Addresses' button,
     * verify that data that's displayed are correct, close site
     */
    @Test
    public void testCreateNewUserTest() {

        // Open site
        HomePage homePage = openSite();

        // Click 'Sign in' link
        SignInPage signInPage = homePage.clickSignInLink();

        // Fill email and click 'Create An Account' button
        CreateAnAccountPage createAnAccountPage = signInPage.createAnAccount(userData.getEmail());

        // Create new user
        MyAccountPage myAccountPage = createAnAccountPage.fillInAllInfoAndClickRegister(userData);

        // Click 'My Addresses' button
        PersonalInformationPage personalInformationPage = myAccountPage.clickMyPersonalInformationButton();

        // Verify that data that's displayed are correct
        personalInformationPage.verifyPersonalInformation(userData);

        // Close site
        closeSite();
    }

    /**
     * Open site, click 'Sign in' button, fill in email,
     * click 'Create An Account' button, fill in information,
     * click 'Register' button, click 'My Addresses' button,
     * verify that data that's displayed are correct, close site
     */
    @Test
    public void testCreateNewUserShorterTest() {

        // Open site
        HomePage homePage = openSite();

        // Create new user. All implementation is hidden
        homePage.createNewUser(userData);

        // Close site
        closeSite();
    }

}
