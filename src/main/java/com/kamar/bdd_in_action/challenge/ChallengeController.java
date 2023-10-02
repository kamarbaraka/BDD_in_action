package com.kamar.bdd_in_action.challenge;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import io.swagger.v3.oas.models.annotations.OpenAPI31;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * API to get random challenges.
 * @author kamar baraka.*/

@RestController
@RequestMapping(value = {"/challenges"})
@Log4j2
@RequiredArgsConstructor
@OpenAPI31
@OpenAPIDefinition
@Tag(name = "challenge", description = "the challenge API ")
public class ChallengeController {

    private final  ChallengeGenerationService challengeGenerationService;

    /**
     * gets a randomly generated challenge.
     * @return {@link Challenge}.*/
    @GetMapping(value = {"/random"})
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "get a random challenge", description = "gets a randomly generated challenge")
    public Challenge getRandomChallenge(){

        /*get a random challenge and return*/
        Challenge challenge = challengeGenerationService.randomChallenge();

        /*log the challenge and return*/
        log.info("generating random challenge: {}", challenge);

        return challenge;
    }
}
