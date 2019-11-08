package uk.gov.dhsc.htbhf.productionstub.model.v2;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EligibilityOutcome {
    CONFIRMED,
    NOT_CONFIRMED,
    NOT_SET;

    @JsonValue
    public String getResponseValue() {
        return this.name().toLowerCase();
    }
}
