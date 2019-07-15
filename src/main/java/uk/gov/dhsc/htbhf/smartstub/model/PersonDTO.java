package uk.gov.dhsc.htbhf.smartstub.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

@Data
@Builder
@AllArgsConstructor(onConstructor_ = {@JsonCreator})
public class PersonDTO {

    @NotNull
    @JsonProperty("forename")
    private final String forename;

    @NotNull
    @JsonProperty("surname")
    private final String surname;

    @NotNull
    @Pattern(regexp = "[a-zA-Z]{2}\\d{6}[a-dA-D]")
    @JsonProperty("nino")
    private final String nino;

    @NotNull
    @Past
    @JsonProperty("dateOfBirth")
    private final LocalDate dateOfBirth;

    @NotNull
    @JsonProperty("address")
    private final AddressDTO address;
}
