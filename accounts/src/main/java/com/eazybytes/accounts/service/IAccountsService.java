package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDto;

public interface IAccountsService {
    /**
     * Create a new account for the given customer.
     * @param customerDto the customer details
     */
    void createAccount(CustomerDto customerDto);

    /**
     * Retrieve customer details based on mobile number.
     * @param mobileNumber the mobile number of the customer
     * @return CustomerDto containing customer details
     */
    CustomerDto getCustomer(String mobileNumber);

    /**
     * Update account details for the given customer.
     * @param customerDto the customer details to be updated
     * @return true if the update was successful, false otherwise
     */
    boolean updateAccount(CustomerDto customerDto);

    /**
     * Delete account based on mobile number.
     * @param mobileNumber the mobile number of the customer
     * @return true if the deletion was successful, false otherwise
     */
    boolean deleteAccount(String mobileNumber);
}
