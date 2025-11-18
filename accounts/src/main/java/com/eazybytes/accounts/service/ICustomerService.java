package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDetailsDto;

public interface ICustomerService {

    /**
     * Fetches comprehensive customer details including accounts, cards, and loans
     * based on the provided mobile number.
     *
     * @param mobileNumber The mobile number of the customer.
     * @return A CustomerDetailsDto containing customer, accounts, cards, and loans details.
     */
    CustomerDetailsDto fetchCustomerDetails(String mobileNumber);
}
