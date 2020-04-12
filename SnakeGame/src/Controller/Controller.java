package Controller;

import Model.Model;
import View.View;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.Properties;

public class Controller {

    private Model model;
    private View view;

    //private MyKeyListener keyListener;

    public Controller() {

        //keyListener = new MyKeyListener(this);
        view = new View(this);
        model = new Model(view);

    }

    public void initScreen() {

        loadData();
        String name = JOptionPane.showInputDialog("Enter player name (>0): ");
        if (name != null && name.length() > 0)
            model.setPlayerName(name);

        view.initScreen();
        model.setHighScore(model.getHighScore());
    }

    public void start() {

        initModel();
        view.initTimer();

        Timer timer = new Timer(250, e -> {
            run();
            view.repaint();
        });

        timer.setInitialDelay(0);
        timer.start();
    }

    public void saveData() {

        try (OutputStream output = new FileOutputStream("./SnakeData.txt")) {

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

        try (InputStream  input = new FileInputStream("./SnakeData.txt")) {

            Properties properties = new Properties();

            properties.load(input);

            model.setPlayerName(properties.getProperty("playerName"));
            model.setHighScore(Integer.parseInt(properties.getProperty("highScore")));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void keyPressed(KeyEvent e) {

        model.keyPressed(e);
    }

    public void run() {
        model.moveSnake();
    }

    public void initModel() {
        model.start();
    }
}
