package com.webinar.patterns.decorator.interfaces;

import com.webinar.patterns.decorator.utils.UserData;

public interface CreateNewUserInterface {
    /**
     * Create new user method
     *
     * @param userData
     */
    void createNewUser(UserData userData);
}
