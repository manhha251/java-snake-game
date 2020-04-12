package View;

import Config.Config;
import Controller.Controller;
import Controller.MyKeyListener;
import Model.Apple;
import Model.Player;
import Model.RenderObject;
import Model.Snake;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

/*
 * Main display for the game window
 * Display all other Panel such as Menu, View.Game panel, Scoreboard,...
 *
 * @author Luu Pham Manh Ha - 1752001
 */

public class View extends JFrame{

    private GamePanel gamePanel;

    private ScorePanel scorePanel;

    private Controller controller;

    public View(Controller controller) {

        this.controller = controller;

        MyKeyListener keyListener = new MyKeyListener(controller);

        setTitle("Snake");

        scorePanel = new ScorePanel(Config.BOARD_COLUMNS * Config.SCALE / 2,
                Config.BOARD_COLUMNS * Config.SCALE);
        gamePanel = new GamePanel(Config.BOARD_COLUMNS * Config.SCALE,
                Config.BOARD_ROWS * Config.SCALE, Config.SCALE);

        add(scorePanel, BorderLayout.EAST);
        add(gamePanel, BorderLayout.CENTER);
        addKeyListener(keyListener);
        pack();
        setResizable(false);
        setFocusable(true);
        //setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public void initScreen() {

       //add(gamePanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void start() {

        controller.initModel();
        scorePanel.initTimer();

        Timer timer = new Timer(250, e -> {
            controller.run();
            gamePanel.repaint();
        });

        timer.setInitialDelay(0);
        timer.start();
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        gamePanel.repaint();
    }

    public void update(Snake snake, Apple apple, Player player) {
        LinkedList<RenderObject> list = new LinkedList<>();
        list.add(snake);
        list.add(apple);

        gamePanel.setObjectList(list);
        scorePanel.updateHighScore(player.getHighScore());
        scorePanel.updateScore(player.getScore());
    }

    public void gameOver() {

        controller.saveData();
        JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }

    public void updatePlayerName(String name) {

        scorePanel.updatePlayerName(name);
    }

    public void initTimer() {

        scorePanel.initTimer();
    }
}
