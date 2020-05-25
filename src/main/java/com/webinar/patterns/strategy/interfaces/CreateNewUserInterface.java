package com.webinar.patterns.strategy.interfaces;

import com.webinar.patterns.strategy.utils.UserData;

public interface CreateNewUserInterface {
    /**
     * Create new user method
     *
     * @param userData
     */
    void createNewUser(UserData userData);
}
