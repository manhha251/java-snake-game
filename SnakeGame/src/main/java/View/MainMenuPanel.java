package main.java.View;

import main.java.Util.AppState;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

/*
 * Main menu panel
 * Use to navigate to other panels or quit application
 *
 * @author Luu Pham Manh Ha - 1752001
 *         Nguyen Hoang Anh - 1652002
 *         Nguyen Thi Quynh Hoa - 1752017
 */

public class MainMenuPanel extends JPanel {

    private View view;

    private Font font = new Font("monospaced", Font.PLAIN, 20);
    private JTextPane help;
    private JFrame helpFrame;

    public MainMenuPanel(View view, int width, int height) {

        this.view = view;

        createHelpPane();

        setBackground(Color.black);
        setPreferredSize(new Dimension(width, height));
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setBackground(Color.black);
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel title = new JLabel("SNAKE GAME", SwingConstants.CENTER);
        title.setFont(font.deriveFont(Font.BOLD, 48));
        title.setForeground(Color.green);
        title.setAlignmentX(CENTER_ALIGNMENT);

        JButton btnGameStart = new JButton("Game Start");
        btnGameStart.setFont(font);
        btnGameStart.addActionListener(e->view.changeState(AppState.GameStart));

        JButton btnHelp = new JButton("How to play");
        btnHelp.setFont(font);
        btnHelp.addActionListener(e -> showHelp());

        JButton btnOptions = new JButton("Options");
        btnOptions.setFont(font);
        btnOptions.addActionListener(e->view.changeState(AppState.Options));

        JButton btnRanking = new JButton("Leaderboard");
        btnRanking.setFont(font);
        btnRanking.addActionListener(e->view.changeState(AppState.Ranking));

        JButton btnLogOut = new JButton("Log out");
        btnLogOut.setFont(font);
        btnLogOut.addActionListener(e -> view.changeState(AppState.Login));

        int padHor = width / 5;
        int padVer = height / 5 / 10;

        int startRows = 0;

        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(padVer, padHor , padVer, padHor);
        gbc.gridwidth = 1;
        gbc.weightx = 1;

        gbc.gridx = 0;
        gbc.gridy = startRows;
        buttonPanel.add(btnHelp, gbc);

        gbc.gridx = 0;
        gbc.gridy = startRows + 2;
        buttonPanel.add(btnGameStart, gbc);

        gbc.gridx = 0;
        gbc.gridy = startRows + 4;
        buttonPanel.add(btnRanking, gbc);

        gbc.gridx = 0;
        gbc.gridy = startRows + 6;
        buttonPanel.add(btnOptions, gbc);

        gbc.gridx = 0;
        gbc.gridy = startRows + 8;
        buttonPanel.add(btnLogOut, gbc);

        add(title, BorderLayout.PAGE_START);
        add(buttonPanel, BorderLayout.CENTER);
    }

    private void createHelpPane() {

        helpFrame = new JFrame();
        helpFrame.setTitle("How to play");
        helpFrame.setResizable(false);

        help = new JTextPane();
        help.setFont(font);
        help.setEditable(false);

        StyledDocument doc = help.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);

        try {
            doc.insertString(0, "How to move snake\n" +
                    "UP: W / Up arrow key\n" +
                    "DOWN: S / Down arrow key\n" +
                    "LEFT: A / Left arrow key\n" +
                    "RIGHT: D / Right arrow key" +
                    "Pause/Continue: P", center);
        } catch (Exception e) {
            e.printStackTrace();
        }
        doc.setParagraphAttributes(0, doc.getLength() - 1, center, false);

        JButton btnClose = new JButton("OK");
        btnClose.setFont(font);
        btnClose.addActionListener(e -> helpFrame.setVisible(false));

        helpFrame.add(help, BorderLayout.CENTER);
        helpFrame.add(btnClose, BorderLayout.PAGE_END);
        helpFrame.pack();
        helpFrame.setVisible(false);
        helpFrame.setLocationRelativeTo(null);
        helpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void showHelp() {

        helpFrame.setVisible(true);
    }
}
