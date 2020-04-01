import javax.swing.*;

/*
 * Main display for the game window
 * Display all other Panel such as Menu, Game panel, Scoreboard,...
 *
 * @author Luu Pham Manh Ha - 1752001
 */

public class Game {

    private GamePanel gamePanel;

    public Game() {

        JFrame frame = new JFrame("Animation");
        gamePanel = new GamePanel(400, 400, 20);
        frame.add(gamePanel);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void start() {

        while (true) {
            gamePanel.move();
            gamePanel.repaint();
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
