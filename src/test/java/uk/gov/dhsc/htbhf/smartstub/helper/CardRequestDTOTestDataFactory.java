package uk.gov.dhsc.htbhf.smartstub.helper;

import uk.gov.dhsc.htbhf.smartstub.model.CardRequestDTO;

import java.util.UUID;

import static uk.gov.dhsc.htbhf.smartstub.helper.AddressDTOTestDataFactory.aValidAddress;
import static uk.gov.dhsc.htbhf.smartstub.helper.TestConstants.*;

public class CardRequestDTOTestDataFactory {

    public static CardRequestDTO aValidCardRequest() {
        return aValidCardRequestBuilder().build();
    }

    private static CardRequestDTO.CardRequestDTOBuilder aValidCardRequestBuilder() {
        return CardRequestDTO.builder()
                .claimId(UUID.randomUUID().toString())
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .dateOfBirth(DATE_OF_BIRTH)
                .email(EMAIL)
                .mobile(MOBILE)
                .address(aValidAddress());
    }
}
