package com.webinar.patterns.factory.interfaces;

import com.webinar.patterns.factory.utils.UserData;

public interface CreateNewUserInterface {
    /**
     * Create new user method
     *
     * @param userData
     */
    void createNewUser(UserData userData);
}
