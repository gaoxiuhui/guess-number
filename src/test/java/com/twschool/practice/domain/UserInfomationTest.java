package com.twschool.practice.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class UserInfomationTest {
    private GuessNumberGame guessNumberGame;
    @Before
    public void setUp() throws Exception {
        GameAnswer gameAnswer = new GameAnswer("1 2 3 4");
        AnswerGenerator answerGenerator = Mockito.mock(AnswerGenerator.class);
        Mockito.when(answerGenerator.generateAnswer()).thenReturn(gameAnswer);
        guessNumberGame = new GuessNumberGame(answerGenerator);
    }
    //赢一次得3分
    @Test
    public void should_return_3_grade_when_success_one_times() {
        UserInformation userInformation = new UserInformation("luna", guessNumberGame, 0, 0);
        guessNumberGame.guess("1 2 3 4");
        int resultScore = userInformation.calculateUserScore();
        Assert.assertEquals(3, resultScore);
    }

}
