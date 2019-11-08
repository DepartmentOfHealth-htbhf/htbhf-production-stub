package uk.gov.dhsc.htbhf.productionstub.helper;

import uk.gov.dhsc.htbhf.productionstub.model.CardRequestDTO;

import java.util.UUID;

import static uk.gov.dhsc.htbhf.productionstub.helper.v1.AddressDTOTestDataFactory.aValidAddress;
import static uk.gov.dhsc.htbhf.productionstub.helper.TestConstants.*;

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
                .mobileNumber(MOBILE_NUMBER)
                .address(aValidAddress());
    }
}
