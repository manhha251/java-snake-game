package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Score panel
 * Use to display player info: name, score, high score, time
 *
 * @author Luu Pham Manh Ha - 1752001
 *         Nguyen Hoang Anh - 1652002
 *         Nguyen Thi Quynh Hoa - 1752017
 */

public class ScorePanel extends JPanel {

    private final JLabel playerName;
    private final JLabel playerNamePlaceHolder;
    private final JLabel score;
    private final JLabel highScore;
    private final JLabel timer;

    private Timer Ttimer;

    public ScorePanel(int width, int height) {

        setPreferredSize(new Dimension(width, height));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


        playerName = new JLabel("Player Name: ");
        playerNamePlaceHolder = new JLabel();
        score = new JLabel("Score: 0");
        highScore = new JLabel();
        timer = new JLabel("Timer: 00:00");

        playerName.setFont(new Font("Monospaced", Font.BOLD, 20));
        playerName.setAlignmentX(Component.CENTER_ALIGNMENT);
        playerNamePlaceHolder.setFont(new Font("Monospaced", Font.PLAIN, 16));
        playerNamePlaceHolder.setAlignmentX(Component.CENTER_ALIGNMENT);
        highScore.setFont(new Font("Monospaced", Font.BOLD, 20));
        highScore.setAlignmentX(Component.CENTER_ALIGNMENT);
        score.setFont(new Font("Monospaced", Font.BOLD, 20));
        score.setAlignmentX(Component.CENTER_ALIGNMENT);
        timer.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(playerName);
        add(playerNamePlaceHolder);
        add(score);
        add(highScore);
        add(timer);

    }

    /*
     * Initialize a clock timer for the game
     */
    public void initTimer() {
        Ttimer = new Timer(1000, new ActionListener() {
            int count;
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                int minutes = count / 60;
                int seconds = count % 60;
                updateTimer(String.format("%02d", minutes) + ":" + String.format("%02d", seconds));
            }
        });

        Ttimer.setInitialDelay(0);
        Ttimer.start();
    }

    public void stopTimer() {
        Ttimer.stop();
    }

    public void updatePlayerName(String string) { playerNamePlaceHolder.setText(string); }

    public void updateTimer(String string) {
        timer.setText("Timer: " + string);
    }

    public void updateScore(int score) {
        this.score.setText("Score: " + score);
    }

    public void updateHighScore(int highScore) {

        this.highScore.setText("High Score: " + highScore);
    }
}
