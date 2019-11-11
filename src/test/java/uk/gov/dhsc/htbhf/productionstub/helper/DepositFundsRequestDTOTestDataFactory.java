package uk.gov.dhsc.htbhf.productionstub.helper;

import uk.gov.dhsc.htbhf.productionstub.model.DepositFundsRequestDTO;

import static uk.gov.dhsc.htbhf.productionstub.helper.TestConstants.AMOUNT_IN_PENCE;
import static uk.gov.dhsc.htbhf.productionstub.helper.TestConstants.DEPOSIT_REFERENCE;

public class DepositFundsRequestDTOTestDataFactory {

    public static DepositFundsRequestDTO aValidDepositFundsRequest() {
        return aValidDepositFundsRequestBuilder().build();
    }

    private static DepositFundsRequestDTO.DepositFundsRequestDTOBuilder aValidDepositFundsRequestBuilder() {
        return DepositFundsRequestDTO.builder()
                .amountInPence(AMOUNT_IN_PENCE)
                .reference(DEPOSIT_REFERENCE);
    }
}
