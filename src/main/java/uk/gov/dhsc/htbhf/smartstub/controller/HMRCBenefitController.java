package uk.gov.dhsc.htbhf.smartstub.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.gov.dhsc.htbhf.eligibility.model.EligibilityStatus;
import uk.gov.dhsc.htbhf.smartstub.model.v1.BenefitDTO;
import uk.gov.dhsc.htbhf.smartstub.model.HMRCEligibilityRequest;

@RestController
@RequestMapping("/v1/hmrc/benefits")
@Slf4j
public class HMRCBenefitController {

    @PostMapping
    public BenefitDTO getBenefits(@RequestBody HMRCEligibilityRequest eligibilityRequest) {
        BenefitDTO benefits = BenefitDTO.builder().eligibilityStatus(EligibilityStatus.NO_MATCH).build();
        log.debug("Sending HRMC response {}", benefits);
        return benefits;
    }
}
