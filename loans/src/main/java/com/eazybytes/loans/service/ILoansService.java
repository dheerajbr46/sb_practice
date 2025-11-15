package com.eazybytes.loans.service;

import com.eazybytes.loans.dto.LoansDto;

public interface ILoansService {

    /**
     * Create a new loan record for the given mobile number.
     * @param mobileNumber the mobile number associated with the loan
     */
    void createLoan(String mobileNumber);

    /**
     * Fetch loan details for the given mobile number.
     * @param mobileNumber the mobile number associated with the loan
     * @return the loan details as LoansDto
     */
    LoansDto fetchLoan(String mobileNumber);

    /**
     * Update loan details based on the provided LoansDto.
     * @param loansDto the loan details to be updated
     * @return true if the update was successful, false otherwise
     */
    boolean updateLoan(LoansDto loansDto);

    /**
     * Delete the loan record associated with the given mobile number.
     * @param mobileNumber the mobile number associated with the loan
     * @return true if the deletion was successful, false otherwise
     */
    boolean deleteLoan(String mobileNumber);
}
