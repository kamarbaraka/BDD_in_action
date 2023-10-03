import * as React from "react";
import ApiClient from "../services/ApiClient.ts";
import {PropsWithChildren} from "react";

/**
 * the challenge component to render the challenge and post attempts to solve the challenge.
 * @author kamar baraka*/

interface State{
    factor_a: number,
    factor_b: number,
    alias: string,
    guess: number,
    message: string
}

class ChallengeComponent extends React.Component<PropsWithChildren, State>{

    /*instantiate the component*/
    constructor(props: PropsWithChildren) {
        super(props);

        /*set the state*/
        this.state = {
            factor_a: 0,
            factor_b: 0,
            alias: "",
            guess: 0,
            message: ""
        };

        /*bind the event handler methods*/
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmitResult = this.handleSubmitResult.bind(this);

    }

    componentDidMount(): void {

        /*get the random challenge*/
        ApiClient.challenge().then(response => {

            if (response.ok){
                /*serialize the response to json*/
                response.json().then(json => {

                    /*set the state with the response*/
                    this.setState({
                        factor_a: json.factorA,
                        factor_b: json.factorB
                    })
                })
            }
            else
                this.updateMessage("sorry, server could not be reached!")
        })
    }

    handleSubmitResult(event: React.FormEvent<HTMLFormElement>): void{

        /*disable the defaults*/
        event.preventDefault();
        /*post the state to the api*/
        ApiClient.sendGuess(
            this.state.alias,
            this.state.factor_a,
            this.state.factor_b,
            this.state.guess
        ).then(response => {
            if (response.ok){
                /*serialize the response to json*/
                response.json().then(json => {
                    /*check if guess is correct*/
                    if (json.correct)
                        this.updateMessage("Congratulations "+this.state.alias +" !! you are correct");
                    else
                        this.updateMessage("Sorry, "+ this.state.alias+ " your guess "+ this.state.guess+ " is wrong!, play again");
                })
            }
            else
                this.updateMessage("Server can't be reached!")
        })
    }

    handleChange(event: React.ChangeEvent<HTMLInputElement>):void {

        /*hold the name of the event target and change the state*/
        const name: string = event.target.name;
        this.setState({
            ...this.state,
            [name] : event.target.value
        });
    }

    updateMessage(message: string):void {

        /*change the state of the message*/
        this.setState(
            {message: message}
        );
    }

    render() {
        return (
            <div>
                <div>
                    <h3>Your new Challenge is </h3>
                    <h1>{this.state.factor_a} x {this.state.factor_b}</h1>
                </div>
                <br/>
                <form onSubmit={this.handleSubmitResult}>
                    <label>
                        your alias:
                        <input type="text" maxLength={12} name="alias" value={this.state.alias}
                               onChange={this.handleChange}/>
                    </label>
                    <br/>
                    <label>
                        your guess:
                        <input type={"number"} min={0} name={"guess"} value={this.state.guess}
                               onChange={this.handleChange} />
                    </label>
                    <br/>
                    <input type={"submit"} value={"submit"} />
                </form>
                <h4>{this.state.message}</h4>
            </div>
        )
    }
}

/*export the component*/
export default ChallengeComponent;