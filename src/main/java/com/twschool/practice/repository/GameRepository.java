package com.twschool.practice.repository;

import com.twschool.practice.domain.AnswerGenerator;
import com.twschool.practice.domain.GuessNumberGame;
import org.springframework.stereotype.Repository;

@Repository
public class GameRepository {

    private GuessNumberGame guessNumberGame=new GuessNumberGame(new AnswerGenerator());

    public GuessNumberGame create() {
        guessNumberGame =new GuessNumberGame(new AnswerGenerator());
        return guessNumberGame;
    }

    public GuessNumberGame find() {
        return guessNumberGame;
    }
}
