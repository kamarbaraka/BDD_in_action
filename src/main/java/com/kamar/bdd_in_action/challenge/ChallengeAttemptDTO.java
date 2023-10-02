package com.kamar.bdd_in_action.challenge;

/**
 * challenge attempt from the user.
 * @author kamar baraka.*/

public record ChallengeAttemptDTO(
        int factorA,
        int factorB,
        String userAlias,
        int guess
) {
}
