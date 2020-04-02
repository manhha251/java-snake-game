import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * Panel for main game board
 * Displayed the game while it's running
 * Draw the layout of the board as well as the snake, apple, obstacles,...
 *
 * @author Luu Pham Manh Ha - 1752001
 */

public class GamePanel extends JPanel {

    private int width;
    private int height;
    private int scale;

    //private Snake snake;

    //private Apple apple;

    private Model model;

    private MyKeyListener keyListener;

    public GamePanel(ScorePanel scorePanel, int width, int height, int scale) {

        this.width = width;
        this.height = height;
        this.scale = scale;
        setPreferredSize(new Dimension(width, height));

        model = new Model(this);

        int highScore = loadData();
        model.setHighScore(highScore);
        scorePanel.updateHighScore(highScore);
        model.start(scorePanel);

        keyListener = new MyKeyListener(model.getSnake());

        addKeyListener(keyListener);
        setFocusable(true);
        setBackground(Color.black);
    }


    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }


    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void move() {

        model.moveSnake();
    }

    public void gameOver() {
        saveData(model.getHighScore());
        JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }

    private void saveData(int highScore) {

        try (FileWriter output = new FileWriter("./SnakeData.txt")) {

            BufferedWriter writer = new BufferedWriter(output);
            writer.write(highScore);
            writer.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private int loadData() {
        int highScore = 0;

        try (FileReader input = new FileReader("./SnakeData.txt")) {

            BufferedReader reader = new BufferedReader(input);
            highScore = reader.read();
            reader.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return highScore;
    }

    /*
     * Paint all GI main components: layout, snake, apple, obstacles,...
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        paintBackGround(g2d);
        model.paint(g2d);
    }

    /*
     * paint white border between cells in background
     */
    private void paintBackGround(Graphics2D g2d) {

        g2d.setColor(Color.white);
        g2d.setStroke(new BasicStroke(0.25f));
        for (int i = 0; i < width; i += scale) {
            for (int j = 0; j < height; j += scale) {
                g2d.drawLine(i, j, i + scale - 1, j);
                g2d.drawLine(i, j, i, j + scale - 1);
            }
        }
    }
}
