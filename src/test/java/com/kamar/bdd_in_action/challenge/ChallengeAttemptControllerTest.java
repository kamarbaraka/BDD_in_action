package com.kamar.bdd_in_action.challenge;

import com.kamar.bdd_in_action.user.User;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

/**
 * test for the {@link ChallengeAttemptController}.
 * @author kamar baraka.*/

@ExtendWith(SpringExtension.class)
@AutoConfigureJsonTesters
@WebMvcTest(ChallengeAttemptController.class)
class ChallengeAttemptControllerTest {

    @MockBean
    private ChallengeAttemptService challengeAttemptService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private JacksonTester<ChallengeAttemptDTO> attemptRequest;
    @Autowired
    private JacksonTester<ChallengeAttempt> attemptResponse;


    /**
     * tests the behavior when a valid request is passed and the attempt is correct. */
    @Test
    void postValidResult() throws Exception{

        /*define your preconditions (given)*/
        User user = new User();
        user.setId(1L);
        user.setAlias("kamar");

        /*construct the request*/
        ChallengeAttemptDTO request = new ChallengeAttemptDTO(35, 11, user.getAlias(), 385);
        /*construct a response*/
        ChallengeAttempt response = new ChallengeAttempt();
        response.setChallengeId(5L);
        response.setUserId(1L);
        response.setFactorA(35);
        response.setGetFactorB(2);
        response.setResultAttempt(70);
        response.setCorrect(true);

        /*the given*/
        BDDMockito.given(challengeAttemptService.verifyAttempt(request))
                .willReturn(response);

        /*define when the condition */
        MockHttpServletResponse theResponse = mockMvc.perform(
                MockMvcRequestBuilders.post("/attempts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(attemptRequest.write(request).getJson())
        ).andReturn().getResponse();

        /*define the result (then)*/
        BDDAssertions.then(theResponse.getStatus()).isEqualTo(HttpStatus.OK.value());
        BDDAssertions.then(theResponse.getContentAsString()).isEqualTo(attemptResponse.write(response)
                .getJson());

    }

    /**test for bad request*/
    @Test
    void postInvalidRequest() throws Exception{

        /*define preconditions (given).
        * construct the invalid request*/
        ChallengeAttemptDTO invalidRequest = new ChallengeAttemptDTO(120, -7, "john", 45);

        /*define when*/
        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders
                .post("/attempts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(attemptRequest.write(invalidRequest).getJson())
        ).andReturn().getResponse();

        /*define the result (then)*/
        BDDAssertions.then(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());

    }


}