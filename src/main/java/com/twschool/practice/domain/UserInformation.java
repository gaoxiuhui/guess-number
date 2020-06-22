package com.twschool.practice.domain;

public class UserInformation {
    private String userId;
    private GuessNumberGame guessNumberGame;
    private int userWinCount;
    private int userScore;

    public UserInformation(String userId, GuessNumberGame guessNumberGame, int userWinCount,int userScore) {
        this.userId = userId;
        this.guessNumberGame = guessNumberGame;
        this.userWinCount = userWinCount;
        this.userScore = userScore;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String id) {
        this.userId = userId;
    }

    public GuessNumberGame getGuessNumberGame() {
        return guessNumberGame;
    }

    public void setGuessNumberGame(GuessNumberGame guessNumberGame) {
        this.guessNumberGame = guessNumberGame;
    }

    public int getUserWinCount() {
        return userWinCount;
    }

    public void setUserWinCount(int winCount) {
        this.userWinCount = userWinCount;
    }

    public void addUserWinCount() {
        this.userWinCount++;
    }

    public void initUserWinCount() {
        this.userWinCount = 0;
    }

    public int getUserScore() {
        return userScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    public void addScore(int userScore) {
        this.userScore += userScore;
    }

    //计算用户的分数
    public int calculateUserScore() {
        if (guessNumberGame.getStatus() == GameStatus.FAILED) {
            addScore(-3);
        } else if (guessNumberGame.getStatus() == GameStatus.SUCCEED) {
            addScore(3);
            addUserWinCount();
            if(getUserWinCount()%5==0){
                addScore(3);
            }else if(getUserWinCount()%3==0){
                addScore(2);
            }
        }
        return getUserScore();
    }
}
