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

    //失败一次得-3分
    @Test
    public void should_return_negative_3_grade_when_failed_one_times() {
        UserInformation userInformation = new UserInformation("luna", guessNumberGame, 0, 0);
        guessNumberGame.guess("1 2 5 6");
        guessNumberGame.guess("1 2 5 6");
        guessNumberGame.guess("1 2 5 6");
        guessNumberGame.guess("1 2 5 6");
        guessNumberGame.guess("1 2 5 6");
        guessNumberGame.guess("1 2 5 6");
        int resultScore = userInformation.calculateUserScore();
        Assert.assertEquals(-3, resultScore);
    }

    //连赢三次额外加2分
    @Test
    public void should_return_11_grade_when_continuous_success_3_times() {
        int resultScore=0;
        UserInformation userInformation = new UserInformation("luna", guessNumberGame, 0, 0);
        userInformation.initUserWinCount();
        for(int playTimes=0;playTimes<3;playTimes++){
            guessNumberGame.guess("1 2 3 4");
             resultScore = userInformation.calculateUserScore();
        }

        Assert.assertEquals(11, resultScore);
    }

    //连赢五次额外加3分
    @Test
    public void should_return_20_grade_when_continuous_success_5_times() {
        int resultScore=0;
        UserInformation userInformation = new UserInformation("luna", guessNumberGame, 0, 0);
        userInformation.initUserWinCount();
        for(int playTimes=0;playTimes<5;playTimes++){
            guessNumberGame.guess("1 2 3 4");
            resultScore = userInformation.calculateUserScore();
        }

        Assert.assertEquals(20, resultScore);
    }


}
