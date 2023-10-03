/**
 * the api client for the multiplication REST service.
 * @author kamar baraka.*/

class ApiClient{

    static SERVER_URL: string = "http://localhost:8080";
    static CHALLENGE_URL: string = "/challenges/random";
    static POST_GUESS_URL: string = "/attempts";

    /**
     * get the random challenge.
     * @return {Promise<Response>} the challenge response.*/
    static challenge(): Promise<Response>{

        /*send a get request on the challenge url and return the response promise*/
        return fetch(this.SERVER_URL + this.CHALLENGE_URL);
    }

    /**
     * post the attempt to solve the challenge.
     * @return {Promise<Response>} the challenge attempt result*/
    static sendGuess(
        alias: string, factor_a:number, factor_b: number, guess: number
    ): Promise<Response>{

        /*send a post request with the attempt body and return the response*/
        return fetch(this.SERVER_URL + this.POST_GUESS_URL,
            {
                method: "POST",
                headers: {"Content-Type": "application/json"},
                body: JSON.stringify({
                    userAlias: alias,
                    factorA: factor_a,
                    factorB: factor_b,
                    guess: guess
                })
            });
    }
}

/*export all the class to be publicly available*/
export default ApiClient;