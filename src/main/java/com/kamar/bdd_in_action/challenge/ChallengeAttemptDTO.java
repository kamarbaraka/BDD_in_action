package com.kamar.bdd_in_action.challenge;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.EqualsAndHashCode;
import lombok.Value;

/**
 * challenge attempt from the user.
 * @author kamar baraka.*/

@Value
public class ChallengeAttemptDTO {

        @Min(value = 11, message = "number too small") @Max(value = 99, message = "number too large")
        int factorA;
        @Min(value = 11, message = "number too small") @Max(value = 99, message = "number too large")
        int factorB;
        @NotBlank(message = "user alias can't be empty")
        String userAlias;
        @Positive(message = "number can't be negative")
        int guess;
}
