package Model;

import Config.Config;
import Util.Direction;
import View.View;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

/*
 * Model contains all game objects and game actions
 *
 * Author: Luu Pham Manh Ha - 1752001
 */
public class Model {

    private final int ROWS = Config.BOARD_ROWS;
    private final int COLUMNS = Config.BOARD_COLUMNS;

    private final Snake snake;

    private final Apple apple;

    private final Player player;

    private final View view;

    public Model(View view) {

        this.view = view;
        snake = new Snake();
        apple = new Apple();
        player = new Player();
    }

    public void init() {

        generateSnake();
        generateApple();
        view.updatePlayerName(player.getName());
    }

    public int getHighScore() {

        return player.getHighScore();
    }

    public void setHighScore(int highScore) {

        player.setHighScore(highScore);
    }

    public void setPlayerName(String name) {

        player.setName(name);
    }

    public String getPlayerName() {

        return player.getName();
    }

    public void generateSnake() {

        snake.generate();
    }

    /*
     * Randomly generate a position on board for apple object
     */
    private void generateApple() {

        Random random = new Random();

        int x, y;
        do {
            x = Math.abs(random.nextInt()) % COLUMNS;
            y = Math.abs(random.nextInt()) % ROWS;
        } while (snake.collision(new Point(x, y)));

        apple.setApple(new Point(x, y));
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

        Point newHead = snake.newHead();

        if (collision(newHead)) {
            view.gameOver();
            return;
        }

        Point applePoint = apple.getApple();
        boolean appleEaten = false;
        if (newHead.equals(applePoint)) {
            appleEaten = true;
            generateApple();
            player.increaseScore();
        }

        snake.update(newHead, appleEaten);
        view.update(snake, apple, player);
    }

    public boolean collision(Point head) {

        /* self collision */
        if (snake.collision(head))
            return true;

        int x = (int) head.getX();
        int y = (int) head.getY();

        /* vertical border collision */
        if (x < 0 || x >= COLUMNS)
            return true;

        /* horizontal border collision */
        return y < 0 || y >= ROWS;
    }

    public void paint(Graphics2D g2d) {
        snake.paint(g2d);
        apple.paint(g2d);
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        Direction currentDirection = snake.getDirection();

        switch (keyCode) {

            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                if (currentDirection != Direction.DOWN)
                snake.setDirection(Direction.UP);
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                if (currentDirection != Direction.UP)
                snake.setDirection(Direction.DOWN);
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                if (currentDirection != Direction.RIGHT)
                snake.setDirection(Direction.LEFT);
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                if (currentDirection != Direction.LEFT)
                snake.setDirection(Direction.RIGHT);
                break;
            default:
                break;
        }
    }

    public int getScore() {

        return player.getScore();
    }
}
