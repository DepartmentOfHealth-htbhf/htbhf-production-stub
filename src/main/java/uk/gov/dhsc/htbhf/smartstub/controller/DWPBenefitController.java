package uk.gov.dhsc.htbhf.smartstub.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.gov.dhsc.htbhf.eligibility.model.EligibilityStatus;
import uk.gov.dhsc.htbhf.smartstub.model.BenefitDTO;
import uk.gov.dhsc.htbhf.smartstub.model.DWPEligibilityRequest;

@RestController
@RequestMapping("/v1/dwp/benefits")
@Slf4j
@AllArgsConstructor
public class DWPBenefitController {

    @PostMapping
    public BenefitDTO getBenefits(@RequestBody DWPEligibilityRequest eligibilityRequest) {
        log.debug("Received DWP eligibility request {}", eligibilityRequest);
        BenefitDTO benefits = BenefitDTO.builder().eligibilityStatus(EligibilityStatus.NO_MATCH).build();
        log.debug("Sending DWP response {}", benefits);
        return benefits;
    }
}
