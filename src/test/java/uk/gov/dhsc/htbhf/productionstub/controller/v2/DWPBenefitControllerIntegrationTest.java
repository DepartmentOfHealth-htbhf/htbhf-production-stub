package uk.gov.dhsc.htbhf.productionstub.controller.v2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import uk.gov.dhsc.htbhf.productionstub.model.v2.*;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.OK;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DWPBenefitControllerIntegrationTest {

    private static final URI ENDPOINT = URI.create("/v2/dwp/benefits");

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldReturnNotMatched() {
        ResponseEntity<IdentityAndEligibilityResponse> benefit = restTemplate.getForEntity(ENDPOINT, IdentityAndEligibilityResponse.class);

        assertThat(benefit.getStatusCode()).isEqualTo(OK);
        assertThat(benefit.getBody().getEligibilityStatus()).isEqualTo(EligibilityOutcome.NOT_CONFIRMED);
        assertThat(benefit.getBody().getAddressLine1Match()).isEqualTo(VerificationOutcome.NOT_MATCHED);
        assertThat(benefit.getBody().getEmailAddressMatch()).isEqualTo(VerificationOutcome.NOT_MATCHED);
        assertThat(benefit.getBody().getMobilePhoneMatch()).isEqualTo(VerificationOutcome.NOT_MATCHED);
        assertThat(benefit.getBody().getPostcodeMatch()).isEqualTo(VerificationOutcome.NOT_MATCHED);
        assertThat(benefit.getBody().getPregnantChildDOBMatch()).isEqualTo(VerificationOutcome.NOT_MATCHED);
        assertThat(benefit.getBody().getQualifyingBenefits()).isEqualTo(QualifyingBenefits.NOT_SET);
        assertThat(benefit.getBody().getDeathVerificationFlag()).isEqualTo(DeathVerificationFlag.N_A);
        assertThat(benefit.getBody().getIdentityStatus()).isEqualTo(IdentityOutcome.NOT_MATCHED);
    }

}
