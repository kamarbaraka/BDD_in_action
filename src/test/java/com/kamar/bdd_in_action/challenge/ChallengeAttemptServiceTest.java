package com.kamar.bdd_in_action.challenge;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * the {@link ChallengeAttemptService} test.
 * @author kamar baraka.*/

@ExtendWith(MockitoExtension.class)
class ChallengeAttemptServiceTest {

    private ChallengeAttemptService challengeAttemptService;


    /**
     * initializes the test.*/
    @BeforeEach
    void setup(){

        /*construct the challenge attempt */
        this.challengeAttemptService = new ChallengeAttemptServiceImpl();

    }

    /**
     * tests the behavior when the attempt is correct.*/
    @Test
    void checkCorrectAttempt(){

        /*define your preconditions (given) */
        ChallengeAttemptDTO attempt = new ChallengeAttemptDTO(20, 100, "kamar", 2000);

        /*the condition (when) */
        ChallengeAttempt challengeAttempt = this.challengeAttemptService.verifyAttempt(attempt);

        /*the result (then) */
        BDDAssertions.then(challengeAttempt.isCorrect()).isTrue();
    }

    /**
     * tests the behavior when the attempt is wrong*/
    @Test
    void checkWrongAttempt(){

        /*define your preconditions (given) */
        ChallengeAttemptDTO attempt = new ChallengeAttemptDTO(30, 100, "kamar", 2000);

        /*the condition (when) */
        ChallengeAttempt challengeAttempt = this.challengeAttemptService.verifyAttempt(attempt);

        /*the result (then) */
        BDDAssertions.then(challengeAttempt.isCorrect()).isFalse();
    }

}