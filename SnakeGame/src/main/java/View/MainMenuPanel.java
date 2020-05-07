package main.java.View;

import main.java.Config.Config;
import main.java.Util.AppState;

import javax.swing.*;
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

    public MainMenuPanel(View view, int width, int height) {

        setBackground(Color.black);
        setPreferredSize(new Dimension(width, height));

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setBackground(Color.black);
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel title = new JLabel("SNAKE GAME");
        title.setFont(new Font("monospaced", Font.BOLD, 48));
        title.setForeground(Color.green);
        title.setAlignmentX(CENTER_ALIGNMENT);

        int btnWidth = Config.BOARD_COLUMNS * Config.SCALE / 2;

        JButton btnGameStart = new JButton("Game Start");
        btnGameStart.setSize(new Dimension(btnWidth, 0));
        btnGameStart.setFont(new Font("monospaced", Font.PLAIN, 20));
        btnGameStart.addActionListener(e->view.changeState(AppState.GameStart));
        btnGameStart.setAlignmentX(CENTER_ALIGNMENT);

        JButton btnOptions = new JButton("Options");
        btnOptions.setSize(btnGameStart.getSize());
        btnOptions.setFont(new Font("monospaced", Font.PLAIN, 20));
        btnOptions.addActionListener(e->view.changeState(AppState.Options));
        btnOptions.setAlignmentX(CENTER_ALIGNMENT);

        JButton btnRanking = new JButton("Leaderboard");
        btnRanking.setSize(btnGameStart.getSize());
        btnRanking.setFont(new Font("monospaced", Font.PLAIN, 20));
        btnRanking.addActionListener(e->view.changeState(AppState.Ranking));
        btnRanking.setAlignmentX(CENTER_ALIGNMENT);

        JButton btnLogOut = new JButton("Log out");
        btnLogOut.setSize(btnGameStart.getSize());
        btnLogOut.setFont(new Font("monospaced", Font.PLAIN, 20));
        btnLogOut.addActionListener(e -> view.changeState(AppState.Login));
        btnLogOut.setAlignmentX(CENTER_ALIGNMENT);

        int padHor = width / 5;
        int padVer = height / 20;

        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(padVer, padHor , padVer, padHor);
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        buttonPanel.add(btnGameStart, gbc);


        gbc.gridx = 0;
        gbc.gridy = 4;
        buttonPanel.add(btnRanking, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        buttonPanel.add(btnOptions, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        buttonPanel.add(btnLogOut, gbc);

        add(title, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }
}
