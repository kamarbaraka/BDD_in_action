package com.kamar.bdd_in_action.challenge;

import org.springframework.stereotype.Service;

/**
 * implementation of the {@link ChallengeAttemptService}.
 * @author kamar baraka.*/

@Service
public class ChallengeAttemptServiceImpl implements ChallengeAttemptService {

    /**
     * verifies the challenge attempt.
     * @param attemptDTO the {@link ChallengeAttemptDTO}.
     * @return the {@link ChallengeAttempt}*/
    @Override
    public ChallengeAttempt verifyAttempt(ChallengeAttemptDTO attemptDTO) {

        /*check if the attempt is correct*/
        boolean isCorrect = attemptDTO.getGuess() == attemptDTO.getFactorA() * attemptDTO.getFactorB();

        /*construct the challenge attempt*/
        ChallengeAttempt challengeAttempt = new ChallengeAttempt();
        challengeAttempt.setFactorA(attemptDTO.getFactorA());
        challengeAttempt.setGetFactorB(attemptDTO.getFactorB());
        challengeAttempt.setResultAttempt(attemptDTO.getGuess());
        challengeAttempt.setCorrect(isCorrect);

        return challengeAttempt;
    }
}
