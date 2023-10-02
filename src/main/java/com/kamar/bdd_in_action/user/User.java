package com.kamar.bdd_in_action.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * a class to hold the user data.
 * @author kamar baraka.*/

@Getter
@Setter
@EqualsAndHashCode
public class User {

    private long id;
    private String alias;
}
