package Controller;

import Config.Config;
import Model.Model;
import Util.AppState;
import View.View;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.io.*;
import java.util.Properties;

/*
 * Controller component in MVC model
 * Handle event
 * Manipulate Model, notify View and receive request from View
 *
 * @author Luu Pham Manh Ha - 1752001
 *
 */

public class Controller {

    private final Model model;
    private final View view;

    private Timer timer;

    public Controller() {

        view = new View(this);
        model = new Model(view);
        Config.loadConfig();
    }

    public void initModel() {
        model.init();
    }

    public void initScreen() {

        loadData();
        view.updatePlayerName(model.getPlayerName());
        view.initScreen();
    }

    public void changeState(AppState state) {

        switch (state) {
            case MainMenu:
                saveData();
                view.display("MAINMENU");
                break;
            case InGame:
                prepareGame();
                view.display("GAMEBOARD");
                start();
                break;
            case Pause:
                pause();
                break;
            case GameOver:
                view.stopTimer();
                view.updateClock("00:00");
                stop();
                JOptionPane.showMessageDialog(view, "Game Over\nScore: " + model.getScore());
                view.display("MAINMENU");
                break;
            case Exit:
                quit();
                break;
            default:
                break;
        }
    }
    public void prepareGame() {

        String name = JOptionPane.showInputDialog("Enter player name\n (Press cancel to use default name or old name): ");
        if (name != null && name.length() > 0)
            model.setPlayerName(name);
    }

    public void start() {

        initModel();
        view.initTimer();

        timer = new Timer(250, e -> {
            run();
            view.repaint();
        });

        timer.setInitialDelay(0);
        timer.start();
    }

    public void run() {
        model.moveSnake();
    }

    private void pause() {
        timer.stop();
    }

    private void resume() {

        timer.start();
    }

    public void stop() {

        timer.stop();
    }

    public void quit() {
        int choice = JOptionPane.showConfirmDialog(view, "Do you want to quit game ?",
                "Quit game", JOptionPane.YES_NO_OPTION);
        // 0: YES, 1: NO
        if (choice == 0) {
            Config.saveConfig();
            saveData();
            System.exit(ImageObserver.ABORT);
        }

    }

    public void keyPressed(KeyEvent e) {

        model.keyPressed(e);
    }

    public void saveData() {

        try (OutputStream output = new FileOutputStream("./save/SnakeData.txt")) {

            Properties properties = new Properties();

            properties.setProperty("playerName", model.getPlayerName());
            properties.setProperty("highScore", Integer.toString(model.getHighScore()));

            properties.store(output, null);

            System.out.println(properties);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void loadData() {

        try (InputStream  input = new FileInputStream("./save/SnakeData.txt")) {

            Properties properties = new Properties();

            properties.load(input);

            model.setPlayerName(properties.getProperty("playerName"));
            model.setHighScore(Integer.parseInt(properties.getProperty("highScore")));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
