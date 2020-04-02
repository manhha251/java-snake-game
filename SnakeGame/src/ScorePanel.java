import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScorePanel extends JPanel {

    private int width;

    private int height;

    private JLabel score;
    private JLabel highScore;
    private JLabel timer;

    public ScorePanel(int width, int height) {

        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(width, height));

        score = new JLabel("Score: 0");
        highScore = new JLabel();
        timer = new JLabel("Timer: 00:00");

        highScore.setFont(new Font("Monospaced", Font.BOLD, 20));
        score.setFont(new Font("Monospaced", Font.BOLD, 20));
        score.setHorizontalAlignment(JLabel.CENTER);
        add(score);
        add(highScore);
        add(timer);
        initTimer();
    }

    private void initTimer() {
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
