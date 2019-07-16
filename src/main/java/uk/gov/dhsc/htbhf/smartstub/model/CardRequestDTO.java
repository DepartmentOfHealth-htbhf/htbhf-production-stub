package uk.gov.dhsc.htbhf.smartstub.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor(onConstructor_ = {@JsonCreator})
public class CardRequestDTO {

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("address")
    private AddressDTO address;

    @JsonProperty("dateOfBirth")
    private final LocalDate dateOfBirth;

    @JsonProperty("email")
    private String email;

    @JsonProperty("mobile")
    private String mobile;

    @JsonProperty("claimId")
    private String claimId;
}

