package uk.gov.dhsc.htbhf.smartstub.helper;

import uk.gov.dhsc.htbhf.smartstub.model.PersonDTO;

import static uk.gov.dhsc.htbhf.smartstub.helper.AddressDTOTestDataFactory.aValidAddress;
import static uk.gov.dhsc.htbhf.smartstub.helper.TestConstants.HOMER_DATE_OF_BIRTH;
import static uk.gov.dhsc.htbhf.smartstub.helper.TestConstants.HOMER_FIRST_NAME;
import static uk.gov.dhsc.htbhf.smartstub.helper.TestConstants.SIMPSON_LAST_NAME;

/**
 * Test data factory for {@link PersonDTO} objects.
 */
public class PersonTestFactory {

    private static final String NINO = "EB123456C";

    public static PersonDTO aValidPerson() {
        final String nino = "EA000000C";
        return buildDefaultPerson().nino(nino).build();
    }

    public static PersonDTO.PersonDTOBuilder buildDefaultPerson() {
        return PersonDTO.builder()
                .dateOfBirth(HOMER_DATE_OF_BIRTH)
                .nino(NINO)
                .address(aValidAddress())
                .forename(HOMER_FIRST_NAME)
                .surname(SIMPSON_LAST_NAME);
    }

}
