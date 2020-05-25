package com.webinar.patterns.builder.utils;

import java.util.Map;

public class UserData {

    // Fields
    private String email;
    private String title;
    private String firstName;
    private String lastName;
    private String password;
    private Map<String, String> dateOfBirth;
    private String company;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String mobilePhone;
    private String alias;

    /**
     * Constructor
     *
     * @param email
     * @param title
     * @param firstName
     * @param lastName
     * @param password
     * @param dateOfBirth
     * @param company
     * @param address
     * @param city
     * @param state
     * @param zip
     * @param country
     * @param mobilePhone
     * @param alias
     */
    public UserData(String email, String title, String firstName, String lastName, String password,
                    Map<String, String> dateOfBirth, String company, String address,
                    String city, String state, String zip, String country,
                    String mobilePhone, String alias) {
        this.email = email;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.company = company;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.mobilePhone = mobilePhone;
        this.alias = alias;
    }

    /**
     * Getter for email
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Getter for title
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter for firstName
     *
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Getter for lastName
     *
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Getter for password
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Getter for dateOfBirth
     *
     * @return dateOfBirth
     */
    public Map<String, String> getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Getter for company
     *
     * @return company
     */
    public String getCompany() {
        return company;
    }

    /**
     * Getter for address
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Getter for city
     *
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Getter for state
     *
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * Getter for zip
     *
     * @return zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * Getter for country
     *
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Getter for mobilePhone
     *
     * @return mobilePhone
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * Getter for alias
     *
     * @return alias
     */
    public String getAlias() {
        return alias;
    }

    public static class Builder {

        // Inner fields
        private String email;
        private String title;
        private String firstName;
        private String lastName;
        private String password;
        private Map<String, String> dateOfBirth;
        private String company;
        private String address;
        private String city;
        private String state;
        private String zip;
        private String country;
        private String mobilePhone;
        private String alias;

        /**
         * Setter for email
         *
         * @param email
         * @return this
         */
        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        /**
         * Setter for title
         *
         * @param title
         * @return this
         */
        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        /**
         * Setter for firstName
         *
         * @param firstName
         * @return this
         */
        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        /**
         * Setter for lastName
         *
         * @param lastName
         * @return this
         */
        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        /**
         * Setter for password
         *
         * @param password
         * @return this
         */
        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        /**
         * Setter for dateOfBirth
         *
         * @param dateOfBirth
         * @return this
         */
        public Builder setDateOfBirth(Map<String, String> dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        /**
         * Setter for company
         *
         * @param company
         * @return this
         */
        public Builder setCompany(String company) {
            this.company = company;
            return this;
        }

        /**
         * Setter for address
         *
         * @param address
         * @return this
         */
        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        /**
         * Setter for city
         *
         * @param city
         * @return this
         */
        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        /**
         * Setter for state
         *
         * @param state
         * @return this
         */
        public Builder setState(String state) {
            this.state = state;
            return this;
        }

        /**
         * Setter for zip
         *
         * @param zip
         * @return this
         */
        public Builder setZip(String zip) {
            this.zip = zip;
            return this;
        }

        /**
         * Setter for country
         *
         * @param country
         * @return this
         */
        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        /**
         * Setter for mobilePhone
         *
         * @param mobilePhone
         * @return this
         */
        public Builder setMobilePhone(String mobilePhone) {
            this.mobilePhone = mobilePhone;
            return this;
        }

        /**
         * Setter for alias
         *
         * @param alias
         * @return this
         */
        public Builder setAlias(String alias) {
            this.alias = alias;
            return this;
        }

        /**
         * Method creates new object of UserData
         *
         * @return instance of UserData
         */
        public UserData build() {
            return new UserData(email, title, firstName, lastName, password,
                    dateOfBirth, company, address, city, state, zip,
                    country, mobilePhone, alias);
        }


    }
}
