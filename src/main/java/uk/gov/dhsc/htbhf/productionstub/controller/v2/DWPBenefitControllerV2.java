package uk.gov.dhsc.htbhf.productionstub.controller.v2;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.gov.dhsc.htbhf.dwp.model.*;

import static java.util.Collections.emptyList;

@RestController
@RequestMapping("/v2/dwp/benefits")
@Slf4j
@AllArgsConstructor
public class DWPBenefitControllerV2 {

    private static final String NO_HOUSEHOLD_IDENTIFIER_PROVIDED = "";

    @GetMapping
    public IdentityAndEligibilityResponse determineEligibility() {
        IdentityAndEligibilityResponse response = IdentityAndEligibilityResponse.builder()
                .identityStatus(IdentityOutcome.NOT_MATCHED)
                .eligibilityStatus(EligibilityOutcome.NOT_SET)
                .qualifyingBenefits(QualifyingBenefits.NOT_SET)
                .mobilePhoneMatch(VerificationOutcome.NOT_SET)
                .emailAddressMatch(VerificationOutcome.NOT_SET)
                .addressLine1Match(VerificationOutcome.NOT_SET)
                .postcodeMatch(VerificationOutcome.NOT_SET)
                .pregnantChildDOBMatch(VerificationOutcome.NOT_SET)
                .householdIdentifier(NO_HOUSEHOLD_IDENTIFIER_PROVIDED)
                .dobOfChildrenUnder4(emptyList())
                .deathVerificationFlag(DeathVerificationFlag.N_A)
                .build();

        log.debug("Sending DWP response {}", response);
        return response;
    }

}
