package uk.gov.dhsc.htbhf.productionstub.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import uk.gov.dhsc.htbhf.productionstub.model.v1.BenefitDTO;
import uk.gov.dhsc.htbhf.productionstub.model.HMRCEligibilityRequest;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.OK;
import static uk.gov.dhsc.htbhf.eligibility.model.EligibilityStatus.NO_MATCH;
import static uk.gov.dhsc.htbhf.productionstub.helper.HMRCEligibilityRequestTestDataFactory.anHMRCEligibilityRequest;

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
}
