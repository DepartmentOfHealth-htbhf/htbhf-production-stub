package uk.gov.dhsc.htbhf.smartstub.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import uk.gov.dhsc.htbhf.errorhandler.ErrorResponse;
import uk.gov.dhsc.htbhf.smartstub.model.BenefitDTO;
import uk.gov.dhsc.htbhf.smartstub.model.HMRCEligibilityRequest;
import uk.gov.dhsc.htbhf.smartstub.model.PersonDTO;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.OK;
import static uk.gov.dhsc.htbhf.assertions.IntegrationTestAssertions.assertValidationErrorInResponse;
import static uk.gov.dhsc.htbhf.eligibility.model.EligibilityStatus.NO_MATCH;
import static uk.gov.dhsc.htbhf.smartstub.helper.HMRCEligibilityRequestTestDataFactory.anHMRCEligibilityRequest;
import static uk.gov.dhsc.htbhf.smartstub.helper.HMRCEligibilityRequestTestDataFactory.anHMRCEligibilityRequestWithPerson;
import static uk.gov.dhsc.htbhf.smartstub.helper.PersonTestFactory.aPersonWithAnInvalidNino;
import static uk.gov.dhsc.htbhf.smartstub.helper.PersonTestFactory.aPersonWithNoAddress;
import static uk.gov.dhsc.htbhf.smartstub.helper.PersonTestFactory.aPersonWithNoDateOfBirth;
import static uk.gov.dhsc.htbhf.smartstub.helper.PersonTestFactory.aPersonWithNoNino;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HMRCBenefitControllerIntegrationTest {

    private static final URI ENDPOINT = URI.create("/v1/hmrc/benefits");

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldReturnNoMatch() {
        HMRCEligibilityRequest anEligibilityRequest = anHMRCEligibilityRequest();

        ResponseEntity<BenefitDTO> benefit = restTemplate.postForEntity(ENDPOINT, anEligibilityRequest, BenefitDTO.class);

        assertThat(benefit.getStatusCode()).isEqualTo(OK);
        assertThat(benefit.getBody().getEligibilityStatus()).isEqualTo(NO_MATCH);
    }

    @Test
    void shouldReturnBadRequestForMissingNino() {
        PersonDTO person = aPersonWithNoNino();
        HMRCEligibilityRequest request = anHMRCEligibilityRequestWithPerson(person);

        ResponseEntity<ErrorResponse> errorResponse = restTemplate.postForEntity(ENDPOINT, request, ErrorResponse.class);

        assertValidationErrorInResponse(errorResponse, "person.nino", "must not be null");
    }

    @Test
    void shouldReturnBadRequestForInvalidNino() {
        PersonDTO person = aPersonWithAnInvalidNino();
        HMRCEligibilityRequest request = anHMRCEligibilityRequestWithPerson(person);

        ResponseEntity<ErrorResponse> errorResponse = restTemplate.postForEntity(ENDPOINT, request, ErrorResponse.class);

        assertValidationErrorInResponse(errorResponse, "person.nino", "must match \"[a-zA-Z]{2}\\d{6}[a-dA-D]\"");
    }

    @Test
    void shouldReturnBadRequestForMissingDateOfBirth() {
        PersonDTO person = aPersonWithNoDateOfBirth();
        HMRCEligibilityRequest request = anHMRCEligibilityRequestWithPerson(person);

        ResponseEntity<ErrorResponse> errorResponse = restTemplate.postForEntity(ENDPOINT, request, ErrorResponse.class);

        assertValidationErrorInResponse(errorResponse, "person.dateOfBirth", "must not be null");
    }

    @Test
    void shouldReturnBadRequestForMissingAddress() {
        PersonDTO person = aPersonWithNoAddress();
        HMRCEligibilityRequest request = anHMRCEligibilityRequestWithPerson(person);

        ResponseEntity<ErrorResponse> errorResponse = restTemplate.postForEntity(ENDPOINT, request, ErrorResponse.class);

        assertValidationErrorInResponse(errorResponse, "person.address", "must not be null");
    }
}
