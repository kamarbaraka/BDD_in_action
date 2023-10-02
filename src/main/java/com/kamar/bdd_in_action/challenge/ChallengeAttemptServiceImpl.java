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
        boolean isCorrect = attemptDTO.guess() == attemptDTO.factorA() * attemptDTO.factorB();

        /*construct the challenge attempt*/
        ChallengeAttempt challengeAttempt = new ChallengeAttempt();
        challengeAttempt.setFactorA(attemptDTO.factorA());
        challengeAttempt.setGetFactorB(attemptDTO.factorB());
        challengeAttempt.setResultAttempt(attemptDTO.guess());
        challengeAttempt.setCorrect(isCorrect);

        return challengeAttempt;
    }
}
