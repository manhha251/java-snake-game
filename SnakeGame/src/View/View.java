package View;

import Config.Config;
import Controller.Controller;
import Controller.MyKeyListener;
import Model.Apple;
import Model.Player;
import Model.RenderObject;
import Model.Snake;
import Util.AppState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;

/*
 * Main display for the game window
 * Display all other Panel such as Menu, Game panel, Score panel,...
 * Receive user input and send to Controller for handling
 *
 * @author Luu Pham Manh Ha - 1752001
 *         Nguyen Hoang Anh - 1652002
 *         Nguyen Thi Quynh Hoa - 1752017
 */

public class View extends JFrame{

    private final GamePanel gamePanel;
    private final ScorePanel scorePanel;
    private final MainMenuPanel mainMenuPanel;

    private final Controller controller;

    private CardLayout card;
    private JPanel cardPanel;

    public View(Controller controller) {

        this.controller = controller;

        MyKeyListener keyListener = new MyKeyListener(controller);

        card = new CardLayout();
        cardPanel = new JPanel(card);

        setTitle("Snake");

        scorePanel = new ScorePanel(Config.BOARD_COLUMNS * Config.SCALE / 2,
                Config.BOARD_COLUMNS * Config.SCALE);
        gamePanel = new GamePanel(Config.BOARD_COLUMNS * Config.SCALE,
                Config.BOARD_ROWS * Config.SCALE, Config.SCALE);
        mainMenuPanel = new MainMenuPanel(controller,Config.BOARD_COLUMNS * Config.SCALE / 2,
                Config.BOARD_COLUMNS * Config.SCALE);

        cardPanel.add(mainMenuPanel, "MAINMENU");
        cardPanel.add(gamePanel, "GAMEBOARD");

        add(cardPanel, BorderLayout.CENTER);
        add(scorePanel, BorderLayout.EAST);
        addKeyListener(keyListener);

        pack();
        setResizable(false);
        setFocusable(true);
        setVisible(false);
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                controller.saveData();
                Config.saveConfig();
                System.exit(0);
            }
        });

    }

    public void initScreen() {

        display("MAINMENU");
        setVisible(true);
    }

    public void display(String panel) {

        card.show(cardPanel, panel);
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

    public void updatePlayerName(String name) {

        scorePanel.updatePlayerName(name);
    }

    public void updateClock(String time) {

        scorePanel.updateTimer(time);
    }

    public void initTimer() {

        scorePanel.initTimer();
    }

    public void stopTimer() {

        scorePanel.stopTimer();
    }

    public void gameOver() {

        controller.changeState(AppState.GameOver);
    }
}
