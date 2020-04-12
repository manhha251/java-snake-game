package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScorePanel extends JPanel {

    private JLabel playerName;
    private JLabel playerNamePlaceHolder;
    private JLabel score;
    private JLabel highScore;
    private JLabel timer;

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

    public void initTimer() {
        Timer timer = new Timer(1000, new ActionListener() {
            int count;
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                int minutes = count / 60;
                int seconds = count % 60;
                updateTimer(String.format("%02d", minutes) + ":" + String.format("%02d", seconds));
            }
        });

        timer.setInitialDelay(0);
        timer.start();
    }

    public void updatePlayerName(String string) { playerNamePlaceHolder.setText(string); }

    private void updateTimer(String string) {
        timer.setText("Timer: " + string);
    }

    public void updateScore(int score) {
        this.score.setText("Score: " + score);
    }

    public void updateHighScore(int highScore) {

        this.highScore.setText("High Score: " + highScore);
    }
}
