package com.eazybytes.message.dto;

/**
 * DTO to represent account information in messages.
 *
 * @param accountNumber the unique identifier for the account
 * @param name          the name of the account holder
 * @param email         the email address associated with the account
 * @param mobileNumber  the mobile number associated with the account
 */
public record AccountsMessageDto(
        Long accountNumber,

        String name,

        String email,

        String mobileNumber
) {
}
