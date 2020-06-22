package com.twschool.practice.service;

import com.twschool.practice.domain.AnswerGenerator;
import com.twschool.practice.domain.GameAnswer;
import com.twschool.practice.domain.GuessNumberGame;
import com.twschool.practice.domain.UserInformation;
import com.twschool.practice.repository.GameRepository;
import com.twschool.practice.service.GameService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

public class GameServiceTest {

    @Test
    public void should_return_result_when_guess_number(){
        GameRepository  gameRepository=Mockito.mock(GameRepository.class);
        GuessNumberGame guessNumberGame=Mockito.mock(GuessNumberGame.class);
        Mockito.when(gameRepository.find()).thenReturn(guessNumberGame);
        GameService gameService=new GameService(gameRepository);
        gameService.guess("1 2 3 4");
        Mockito.verify(guessNumberGame,
                Mockito.times(1))
                .guess(Mockito.eq("1 2 3 4"));
    }

}
