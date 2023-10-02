package com.kamar.bdd_in_action.challenge;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * a class to hold {@link com.kamar.bdd_in_action.user.User} challenge attempt data.
 * @author kamar baraka.*/

@Getter
@Setter
@EqualsAndHashCode
public class ChallengeAttempt {

    private long challengeId;
    private long userId;
    private int factorA;
    private int getFactorB;
    private int resultAttempt;
    private boolean correct;
}
