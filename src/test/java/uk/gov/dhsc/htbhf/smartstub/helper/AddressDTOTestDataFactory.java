package uk.gov.dhsc.htbhf.smartstub.helper;


import uk.gov.dhsc.htbhf.smartstub.model.AddressDTO;

import static uk.gov.dhsc.htbhf.smartstub.helper.TestConstants.ADDRESS_LINE_1;
import static uk.gov.dhsc.htbhf.smartstub.helper.TestConstants.ADDRESS_LINE_2;
import static uk.gov.dhsc.htbhf.smartstub.helper.TestConstants.POSTCODE;
import static uk.gov.dhsc.htbhf.smartstub.helper.TestConstants.TOWN;

public class AddressDTOTestDataFactory {

    public static AddressDTO aValidAddress() {
        return aValidAddressBuilder().build();
    }

    private static AddressDTO.AddressDTOBuilder aValidAddressBuilder() {
        return AddressDTO.builder()
                .addressLine1(ADDRESS_LINE_1)
                .addressLine2(ADDRESS_LINE_2)
                .townOrCity(TOWN)
                .postcode(POSTCODE);
    }
}
