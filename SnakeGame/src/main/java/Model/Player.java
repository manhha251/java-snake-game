package main.java.Model;

import main.java.Util.GameMode;

/*
 * Model for player
 * Contain game-related information: name, account-associated, score for each difficulty
 *
 * Author: Luu Pham Manh Ha - 1752001
 */

public class Player {

    private String username;
    private String name;

    private GameMode mode = GameMode.Easy;

    private int score;
    private int highScoreEasy;
    private int highScoreNormal;
    private int highScoreHard;

    public Player() {

        name = "";
        score = highScoreEasy = highScoreNormal = highScoreHard = 0;
    }

    public Player(String username, String playerName, int highScoreEasy, int highScoreNormal, int highScoreHard) {

        this.username = username;
        this.name = playerName;
        this.highScoreEasy = highScoreEasy;
        this.highScoreNormal = highScoreNormal;
        this.highScoreHard = highScoreHard;
        this.score = 0;
    }

    public Player(String username, String playerName) {

        this.username = username;
        this.name = playerName;
        this.score = this.highScoreEasy = this.highScoreHard = this.highScoreNormal = 0;
    }

    public String getUsername() {
        return username;
    }

    public int getHighScoreEasy() {
        return highScoreEasy;
    }

    public int getHighScoreNormal() {
        return highScoreNormal;
    }

    public int getHighScoreHard() {
        return highScoreHard;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public GameMode getGameMode() {

        return mode;
    }

    public void updateHighScore() {

        switch (mode) {
            case Easy:
                if (score > highScoreEasy)
                    highScoreEasy = score;
                break;
            case Normal:
                if (score > highScoreNormal)
                    highScoreNormal = score;
                break;
            case Hard:
                if (score > highScoreHard)
                    highScoreHard = score;
                break;
            default:
                break;
        }

        score = 0;
    }

    public void increaseScore() {

        switch (mode) {
            case Easy:
                score += 1;
                break;
            case Normal:
                score += 2;
                break;
            default:
                score += 4;
                break;
        }
    }

    public void setMode(GameMode mode) {
        this.mode = mode;
    }
}
