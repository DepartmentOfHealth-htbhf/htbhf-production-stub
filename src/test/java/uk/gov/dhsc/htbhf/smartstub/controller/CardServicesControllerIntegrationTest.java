package uk.gov.dhsc.htbhf.smartstub.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import uk.gov.dhsc.htbhf.smartstub.model.CardBalanceResponse;
import uk.gov.dhsc.htbhf.smartstub.model.CardRequestDTO;
import uk.gov.dhsc.htbhf.smartstub.model.CreateCardResponse;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.OK;
import static uk.gov.dhsc.htbhf.smartstub.helper.CardRequestDTOTestDataFactory.aValidCardRequest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CardServicesControllerIntegrationTest {

    private static final URI ENDPOINT = URI.create("/v1/cards");

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldSuccessfullyCreateCard() {
        //Given
        CardRequestDTO request = aValidCardRequest();
        //When
        ResponseEntity<CreateCardResponse> response = restTemplate.postForEntity(ENDPOINT, request, CreateCardResponse.class);
        //Then
        assertThat(response.getStatusCode()).isEqualTo(OK);
        CreateCardResponse cardResponse = response.getBody();
        assertThat(cardResponse).isNotNull();
        assertThat(cardResponse.getCardAccountId()).startsWith("stub-");
    }

    @Test
    void shouldSuccessfullyGetBalance() {
        //Given
        String cardId = "myId";
        //When
        ResponseEntity<CardBalanceResponse> response = restTemplate.getForEntity(buildBalanceEndpoint(cardId), CardBalanceResponse.class);
        //Then
        assertThat(response.getStatusCode()).isEqualTo(OK);
        CardBalanceResponse balanceResponse = response.getBody();
        assertThat(balanceResponse).isNotNull();
        assertThat(balanceResponse.getAvailableBalanceInPence()).isEqualTo(0);
        assertThat(balanceResponse.getLedgerBalanceInPence()).isEqualTo(0);
        assertThat(balanceResponse.getLedgerBalanceInPence()).isEqualTo(balanceResponse.getAvailableBalanceInPence());
    }

    private String buildBalanceEndpoint(String cardId) {
        return ENDPOINT + "/" + cardId + "/balance";
    }

}
