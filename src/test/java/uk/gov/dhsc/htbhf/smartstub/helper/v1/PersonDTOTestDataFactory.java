package uk.gov.dhsc.htbhf.smartstub.helper.v1;

import uk.gov.dhsc.htbhf.smartstub.model.v1.PersonDTO;

import static uk.gov.dhsc.htbhf.smartstub.helper.v1.AddressDTOTestDataFactory.aValidAddress;
import static uk.gov.dhsc.htbhf.smartstub.helper.TestConstants.DATE_OF_BIRTH;
import static uk.gov.dhsc.htbhf.smartstub.helper.TestConstants.FIRST_NAME;
import static uk.gov.dhsc.htbhf.smartstub.helper.TestConstants.NINO;
import static uk.gov.dhsc.htbhf.smartstub.helper.TestConstants.LAST_NAME;

/**
 * Test data factory for {@link PersonDTO} objects.
 */
public class PersonDTOTestDataFactory {

    public static PersonDTO aValidPerson() {
        return aValidPersonBuilder().build();
    }

    private static PersonDTO.PersonDTOBuilder aValidPersonBuilder() {
        return PersonDTO.builder()
                .dateOfBirth(DATE_OF_BIRTH)
                .nino(NINO)
                .address(aValidAddress())
                .forename(FIRST_NAME)
                .surname(LAST_NAME);
    }

}
