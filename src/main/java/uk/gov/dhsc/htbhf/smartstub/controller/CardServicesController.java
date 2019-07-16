package uk.gov.dhsc.htbhf.smartstub.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import uk.gov.dhsc.htbhf.smartstub.model.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/cards")
@Slf4j
public class CardServicesController {

    @PostMapping
    public CreateCardResponse createCard(@RequestBody CardRequestDTO cardRequestDTO) {
        CreateCardResponse createCardResponse = CreateCardResponse.builder()
                .cardAccountId(UUID.randomUUID().toString())
                .build();
        log.debug("Returning create card response: {}", createCardResponse);
        return createCardResponse;
    }

    @GetMapping(path = "/{cardId}/balance")
    public CardBalanceResponse getCardBalance(@PathVariable("cardId") String cardId) {
        CardBalanceResponse cardBalanceResponse = CardBalanceResponse.builder()
                .ledgerBalanceInPence(0)
                .availableBalanceInPence(0)
                .build();
        log.debug("Returning card balance: {}", cardBalanceResponse);
        return cardBalanceResponse;
    }
}
