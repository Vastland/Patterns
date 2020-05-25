package com.webinar.patterns.decorator.tests;

import com.webinar.patterns.decorator.basetest.BaseTest;
import com.webinar.patterns.decorator.pages.HomePage;
import com.webinar.patterns.decorator.utils.UserData;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CreateNewUserTest extends BaseTest {

    // Instance of UserData
    private UserData userData;

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
    public void testCreateNewUserShorterTest() {

        // Open site
        HomePage homePage = openSite();

        // Create new user. All implementation is hidden
        homePage.createNewUser(userData);

        // Close site
        closeSite();
    }

}
