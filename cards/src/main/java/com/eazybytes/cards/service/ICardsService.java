package com.eazybytes.cards.service;

import com.eazybytes.cards.dto.CardsDto;

public interface ICardsService {
    /**
     * Service method to create a new card for a customer.
     *
     * @param mobileNumber The mobile number of the customer.
     */
    void createCard(String mobileNumber);

    /**
     * Service method to fetch card details for a customer.
     *
     * @param mobileNumber The mobile number of the customer.
     * @return CardsDto containing card details.
     */
    CardsDto fetchCard(String mobileNumber);

    /**
     * Service method to update card details for a customer.
     *
     * @param cardsDto The CardsDto containing updated card details.
     * @return boolean indicating success or failure of the update operation.
     */
    boolean updateCard(CardsDto cardsDto);

    /**
     * Service method to delete a card for a customer.
     *
     * @param mobileNumber The mobile number of the customer.
     * @return boolean indicating success or failure of the delete operation.
     */
    boolean deleteCard(String mobileNumber);
}
