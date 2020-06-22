package com.twschool.practice.api;

import com.twschool.practice.domain.AnswerGenerator;
import com.twschool.practice.domain.GuessNumberGame;
import com.twschool.practice.service.GameService;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GameController {
    private GameService gameService;
    public GameController(GameService gameService){
        this.gameService=gameService;
    }

    @PostMapping("/game/guess_numbers")
    public Map<String,String> guess(@RequestBody Map<String,String> requestBody){
        String number=requestBody.get("number");
        String result=gameService.guess(number);
        Map<String,String> responseBody =new HashMap<>();
        responseBody.put("input",number);
        responseBody.put("result",result);
        return responseBody;
    }
}
