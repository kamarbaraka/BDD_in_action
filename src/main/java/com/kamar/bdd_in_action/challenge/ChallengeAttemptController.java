package com.kamar.bdd_in_action.challenge;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * provides the API to submit attempts to solve {@link Challenge}s.
 * @author kamar baraka.*/

@RestController
@Log4j2
@RequestMapping(value = {"/attempts"})
@RequiredArgsConstructor
@Tag(name = "Challenge Attempt API", description = "API to submit attempts to solve challenges")
public class ChallengeAttemptController {

    private final ChallengeAttemptService challengeAttemptService;

    /**
     * endpoint to post a challenge attempt*/
    @PostMapping
    @Operation(summary = "post challenge endpoint", description = "an endpoint to post a challenge attempt")
    public ResponseEntity<ChallengeAttempt> postAttempt( @RequestBody @Valid ChallengeAttemptDTO attemptDTO){

        /*verify the attempt*/
        ChallengeAttempt challengeAttempt = challengeAttemptService.verifyAttempt(attemptDTO);
        /*return the result*/
        return ResponseEntity.ok(challengeAttempt);
    }
}
