package com.kamar.bdd_in_action.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.BDDMockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.assertj.core.api.BDDAssertions;
import org.mockito.stubbing.OngoingStubbing;

import java.util.Random;

/**
 * the test class to test the {@link ChallengeGenerationService}.
 * @author kamar baraka.*/

@ExtendWith(MockitoExtension.class)
class WhenGeneratingAChallengeTest {


    /**mock the {@link Random} object with the {@link Spy} annotation*/

    private ChallengeGenerationService challengeGenerationService;
    @Spy
    private  Random random;

    @BeforeEach
    public void setUp(){
        /*construct a challenge generation service*/
        challengeGenerationService = new ChallengeGenerationServiceImpl(random);
    }

    @Test
    public void shouldGenerateRandomChallenge(){

        /*define the "given" context*/
        BDDMockito.given(random.nextInt(11, 100)).willReturn(16, 32);

        /*define your "when" context*/
        Challenge challenge = challengeGenerationService.randomChallenge();
//        OngoingStubbing<Challenge> when = BDDMockito.when(challengeGenerationService.randomChallenge());

        /*define your then to verify it works as should*/
        BDDAssertions.then(challenge).isEqualTo(new Challenge(16, 32));

    }

}