package main.java.Model;

import main.java.Config.Config;
import main.java.Util.Direction;
import main.java.Util.GameMode;
import main.java.View.View;

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

    private Player player;

    private final View view;

    private boolean iskeyPressed;

    public Model(View view) {

        this.view = view;
        snake = new Snake();
        apple = new Apple();
        player = new Player();

    }

    public void init() {

        iskeyPressed = false;
        generateSnake();
        generateApple();
    }

    public void updateHighScore() {

        player.updateHighScore();
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

    public void setPlayer(Player player) {

        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public int getScore() {

        return player.getScore();
    }

    public boolean collision(Point head) {

        /* self collision */
        if (snake.collision(head)) {
            System.out.println("Self collision at " + head.x + " " + head.y);
            return true;
        }

        int x = (int) head.getX();
        int y = (int) head.getY();

        /* vertical border collision */
        if (x < 0 || x >= COLUMNS) {
            System.out.println("Columns collision at " + head.x + " " + head.y);
            return true;
        }

        /* horizontal border collision */
        if (y < 0 || y >= ROWS ) {
            System.out.println("Rows collision at " + head.x + " " + head.y);
            return true;
        }

        return false;
    }

    /*
     * Handling key event for game
     */
    public void keyPressed(int keyCode) {

        if(iskeyPressed)
            return;

        Direction currentDirection = snake.getDirection();
        switch (keyCode) {

            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                if (currentDirection != Direction.DOWN) {
                    snake.setDirection(Direction.UP);
                    iskeyPressed = true;
                }
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                if (currentDirection != Direction.UP) {
                    snake.setDirection(Direction.DOWN);
                    iskeyPressed = true;
                }
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                if (currentDirection != Direction.RIGHT) {
                    snake.setDirection(Direction.LEFT);
                    iskeyPressed = true;
                }
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                if (currentDirection != Direction.LEFT) {
                    snake.setDirection(Direction.RIGHT);
                    iskeyPressed = true;
                }
                break;
            default:
                break;
        }
    }

    public void keyReleased(KeyEvent e) {

        iskeyPressed = false;
    }

    public void setMode(GameMode mode) {

        player.setMode(mode);
    }
}
