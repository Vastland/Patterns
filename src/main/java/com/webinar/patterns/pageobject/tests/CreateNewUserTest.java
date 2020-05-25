package com.webinar.patterns.pageobject.tests;

import com.webinar.patterns.pageobject.basetest.BaseTest;
import com.webinar.patterns.pageobject.pages.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CreateNewUserTest extends BaseTest {

    /**
     * Open site, click 'Sign in' button, fill in email,
     * click 'Create An Account' button, fill in information,
     * click 'Register' button, click 'My Addresses' button,
     * verify that data that's displayed are correct, close site
     */
    @Test
    public void testCreateNewUserTest() {

        // Generate email
        String email = generateEmail();

        // Open site
        HomePage homePage = openSite();

        // Click 'Sign in' link
        SignInPage signInPage = homePage.clickSignInLink();

        // Fill email and click 'Create An Account' button
        CreateAnAccountPage createAnAccountPage = signInPage.createAnAccount(email);

        // Fill in personal information
        Map<String, String> dateOfBirth = new HashMap<>();
        dateOfBirth.put("day", "29");
        dateOfBirth.put("month", "1");
        dateOfBirth.put("year", "1986");
        createAnAccountPage.fillInPersonalInfo("Mr", "Alexey", "Test", "Temp1234@", dateOfBirth);

        // Fill in address
        createAnAccountPage.fillInAddress("Company", "Some str. 76-12", "New York", "New York",
                "10001", "United States", "+10935674513", "test_alias");

        // Click 'Register' button
        MyAccountPage myAccountPage = createAnAccountPage.clickRegisterButton();

        // Click 'My Addresses' button
        PersonalInformationPage personalInformationPage = myAccountPage.clickMyPersonalInformationButton();

        // Verify that data that's displayed are correct
        personalInformationPage.verifyPersonalInformation("Alexey", "Test", email);

        // Close site
        closeSite();
    }

}
