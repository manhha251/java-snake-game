package main.java.Controller;

import main.java.Config.Config;
import main.java.Database.Database;
import main.java.Model.Model;
import main.java.Model.Player;
import main.java.Util.AppState;
import main.java.Util.GameMode;
import main.java.View.View;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.List;

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

    private GameMode mode;

    private String dbConnectionString = "mongodb+srv://admin:admin@snakegamedb-0i6e1.mongodb.net/test?retryWrites=true&w=majority";
    private String dbName = "SnakeGameDB";


    public Controller() {

        view = new View(this);
        model = new Model(view);

        Database.connect(dbConnectionString, dbName);
        Config.loadConfig();
    }

    public void initModel() {
        model.init();
    }

    public void initScreen() {

        //loadData();
        //view.updatePlayerName(model.getPlayerName());
        view.initScreen();
    }

    public void setPlayer(Player player) {

        model.setPlayer(player);
    }

    public void changeState(AppState state) {

        switch (state) {
            case Login:
                view.hideScorePanel();
                view.display("LOGIN");
                break;
            case Register:
                //view.hideScorePanel();
                view.display("REGISTER");
                break;
            case MainMenu:
                view.showScorePanel();
                view.updateRankingBoard();
                view.display("MAINMENU");
                break;
            case Options:
                break;
            case Ranking:
                view.display("RANKING");
                break;
            case GameStart:

                mode = chooseMode();
                if (mode != null) {
                    model.setMode(mode);
                    view.displayClock();
                    view.display("GAMEBOARD");
                    start();
                }
                break;
            case Pause:
                pause();
                break;
            case GameOver:

                int finalScore = model.getScore();

                stop();
                view.stopTimer();
                view.hideClock();
                model.updateHighScore();
                saveData();
                JOptionPane.showMessageDialog(view, "Game Over\nScore: " + finalScore);
                changeState(AppState.MainMenu);
                break;
            default:
                break;
        }
    }

    private GameMode chooseMode() {

        String[] options = {"Easy", "Normal", "Hard"};

        int choice = JOptionPane.showOptionDialog(view, "Choose your difficulty !"
                , "Select difficulty", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);

        switch (choice) {
            case 0:
                return GameMode.Easy;
            case 1:
                return GameMode.Normal;
            case 2:
                return GameMode.Hard;
            default:
                return null;
        }
    }

    public void start() {

        initModel();
        view.initTimer();

        int speed = 500;

        switch (mode) {
            case Easy:
                break;
            case Normal:
                speed /= 2;
                break;
            default:
                speed /= 4;
                break;
        }

        timer = new Timer(speed, e -> {
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

    public void keyPressed(KeyEvent e) {

        model.keyPressed(e);
    }


    public void keyReleased(KeyEvent e) {

        model.keyReleased(e);
    }

    public void saveData() {

        Database.update(model.getPlayer());
    }

    public void addNewPlayer(String username, String playerName) {

        Player player = new Player(username, playerName);
        Database.update(player);
    }

    public List<Document> getRankingBoard() {
        return Database.getRankingBoard();
    }
}
