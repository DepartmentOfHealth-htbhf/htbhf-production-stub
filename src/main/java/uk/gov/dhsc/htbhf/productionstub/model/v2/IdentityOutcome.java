package uk.gov.dhsc.htbhf.productionstub.model.v2;

import com.fasterxml.jackson.annotation.JsonValue;

public enum IdentityOutcome {
    MATCHED,
    NOT_MATCHED;

    @JsonValue
    public String getResponseValue() {
        return this.name().toLowerCase();
    }
}
