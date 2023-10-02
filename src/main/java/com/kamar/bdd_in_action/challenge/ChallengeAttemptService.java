package com.kamar.bdd_in_action.challenge;

/**
 * the service to verify a challenge attempt.
 * @author kamar baraka.*/

public interface ChallengeAttemptService {

    /**verifies a {@link ChallengeAttemptDTO} if correct.
     * @return the resultant {@link ChallengeAttemptDTO}*/
    ChallengeAttempt verifyAttempt(ChallengeAttemptDTO attemptDTO);
}
