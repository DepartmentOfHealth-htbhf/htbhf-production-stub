package uk.gov.dhsc.htbhf.productionstub.controller.v2;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.gov.dhsc.htbhf.productionstub.model.v2.*;

import static uk.gov.dhsc.htbhf.productionstub.model.v2.QualifyingBenefits.NOT_SET;

@RestController
@RequestMapping("/v2/dwp/benefits")
@Slf4j
@AllArgsConstructor
public class DWPBenefitControllerV2 {

    @GetMapping
    public IdentityAndEligibilityResponse determineEligibility() {
        IdentityAndEligibilityResponse response = IdentityAndEligibilityResponse.builder()
                .addressLine1Match(VerificationOutcome.NOT_MATCHED)
                .deathVerificationFlag(DeathVerificationFlag.N_A)
                .eligibilityStatus(EligibilityOutcome.NOT_CONFIRMED)
                .emailAddressMatch(VerificationOutcome.NOT_MATCHED)
                .mobilePhoneMatch(VerificationOutcome.NOT_MATCHED)
                .postcodeMatch(VerificationOutcome.NOT_MATCHED)
                .pregnantChildDOBMatch(VerificationOutcome.NOT_MATCHED)
                .qualifyingBenefits(NOT_SET)
                .identityStatus(IdentityOutcome.NOT_MATCHED)
                .build();
        log.debug("Sending DWP response {}", response);
        return response;
    }

}
