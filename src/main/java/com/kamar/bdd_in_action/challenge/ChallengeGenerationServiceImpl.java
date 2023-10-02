package com.kamar.bdd_in_action.challenge;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * implementation of the {@link ChallengeGenerationService} service.
 * @author kamar baraka.*/

@Service
@Getter
@Setter
@AllArgsConstructor
public class ChallengeGenerationServiceImpl implements ChallengeGenerationService {

    private static final int MAX_FACTOR = 100, MIN_FACTOR = 11;
    private Random random;

    public ChallengeGenerationServiceImpl() {

        /*assign random*/
        this.random = new Random();
    }

    private int next(){

        /*generate a random integer between max and min*/
        return random.nextInt(MIN_FACTOR, MAX_FACTOR);
    }

    @Override
    public Challenge randomChallenge() {

        /*generate a random challenge and return*/
        return new Challenge(this.next(), this.next());
    }
}
