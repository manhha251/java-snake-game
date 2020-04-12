package Model;

public class Player {

    private String name;

    private int score;
    private int highScore;

    public Player() {

        name = "ABC";
        score = highScore = 0;
    }

    public Player(String name, int score, int highScore) {

        this.name = name;
        this.score = score;
        this.highScore = highScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }
    
    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public void increaseScore() {

        score += 1;
        if (score > highScore)
            setHighScore(score);
    }
}
