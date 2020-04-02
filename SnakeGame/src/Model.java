import java.awt.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * Model contains all other game objects and game logic
 *
 * Author: Luu Pham Manh Ha - 1752001
 */
public class Model {

    private final int ROWS = 20;
    private final int COLUMNS = 20;
    private final int scale = 20;

    private Snake snake;

    private Apple apple;

    private int score;
    private int highScore;

    public int getHighScore() {
        return highScore;
    }

    private ScorePanel scorePanel;

    public Snake getSnake() {
        return snake;
    }

    private GamePanel view;

    public Model(GamePanel view) {

        score = 0;
        highScore = 0;
        this.view = view;
    }

    public void start(ScorePanel scorePanel) {

        this.scorePanel = scorePanel;
        snake = new Snake(view, scale);
        apple = new Apple(view, scale);
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    /*
     * Method for moving snakes
     * Snake moves by moving its tail one grid ahead its head - new virtual head
     * If this new virtual head collided with snake body or the board's edge: GAME OVER
     * Add new head to snake
     * If new head collided with an apple, increase snake size by not remove its current tail
     * If not remove its current tail
     */
    public void moveSnake() {

        Point newHead = snake.tryMove();
        int x = (int)newHead.getX();
        int y = (int)newHead.getY();

        if (Snake.collision(x, y)) {
            view.gameOver();
            return;
        }

        snake.getLast().setLocation(x, y);
        snake.addFirst(newHead);
        if (snake.ate(apple)) {
            score++;
            scorePanel.updateScore(score);
            if (score > highScore) {
                highScore = score;
                scorePanel.updateHighScore(highScore);
            }
            apple.generateApple();
        } else {
            snake.removeLast();
        }

        snake.setX(x);
        snake.setY(y);
    }

    public void paint(Graphics2D g2d) {
        snake.paint(g2d);
        apple.paint(g2d);
    }
}
