package com.kamar.bdd_in_action.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BDD

import java.util.Random;

/**
 * the test class to test the {@link ChallengeGenerationService}.
 * @author kamar baraka.*/

@ExtendWith(MockitoExtension.class)
class ChallengeGenerationServiceTest {


    /**mock the {@link Random} object with the {@link Spy} annotation*/
    @Spy
    private  Random random;

    @BeforeEach
    public void setUp(){
        /*construct a challenge generation service*/
        ChallengeGenerationService challengeGenerationService = new ChallengeGenerationServiceImpl();
    }

    @Test
    public void randomTestGenerationTest(){

        /*define the "given" context*/

    }

}