package main.java.View;

import main.java.Config.Config;
import main.java.Database.Database;
import main.java.Model.Player;
import main.java.Util.AppState;
import main.java.Util.GameMode;
import org.bson.Document;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/*
 * Panel to display top 5 player with highest score for each difficulty
 *
 * Author: Luu Pham Manh Ha - 1752001
 */

public class RankingPanel extends JPanel {

    private JTabbedPane rankingPanel;
    private JLabel easy, normal, hard;
    private JList easyTable, normalTable, hardTable;
    private JPanel easyPanel, normalPanel, hardPanel;
    private View view;
    private final Font font = new Font("monospaced", Font.PLAIN, 15);
    private final GridBagConstraints gbc = new GridBagConstraints();

    private final Comparator<Map.Entry<String, Integer>> comp =
            Map.Entry.comparingByValue();

    public RankingPanel(View view, int width, int height) {

        this.view = view;

        setLayout(new BorderLayout());

        setPreferredSize(new Dimension(width, height));
        setBackground(Color.black);

        JLabel title = new JLabel("SNAKE GAME");
        title.setFont(new Font("Monospaced", Font.BOLD, 48));
        title.setForeground(Color.green);
        title.setHorizontalAlignment(JLabel.CENTER);

        easy = new JLabel();
        easy.setFont(new Font("Monospaced", Font.PLAIN, 20));
        normal = new JLabel();
        normal.setFont(new Font("Monospaced", Font.PLAIN, 20));
        hard = new JLabel();
        hard.setFont(new Font("Monospaced", Font.PLAIN, 20));

        easyTable = new JList();
        easyTable.setFont(new Font("Monospaced", Font.PLAIN, 20));

        normalTable = new JList();
        normalTable.setFont(new Font("Monospaced", Font.PLAIN, 20));

        hardTable = new JList();
        hardTable.setFont(new Font("Monospaced", Font.PLAIN, 20));

        createRankingPanel(width, height);

        JButton btnBack = new JButton("Return");
        btnBack.addActionListener(e -> view.changeState(AppState.MainMenu));

        JPanel btnPanel = new JPanel(new GridBagLayout());
        btnPanel.setBackground(Color.black);
        btnPanel.setPreferredSize(new Dimension(width, height / 4));
        btnPanel.add(btnBack);

        add(title, BorderLayout.PAGE_START);
        add(rankingPanel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.PAGE_END);
        //setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    private void createRankingPanel(int width, int height) {

        rankingPanel = new JTabbedPane();

        easyPanel = new JPanel();
        easyPanel.setLayout(new GridBagLayout());

        normalPanel = new JPanel();
        normalPanel.setLayout(new GridBagLayout());

        hardPanel = new JPanel();
        hardPanel.setLayout(new GridBagLayout());


        JLabel easyLabel = new JLabel("Easy");
        easyLabel.setPreferredSize(new Dimension(width / 4, Config.SCALE));
        easyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel normalLabel = new JLabel("Normal");
        normalLabel.setPreferredSize(new Dimension(width / 4, Config.SCALE));
        normalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel hardLabel = new JLabel("Hard");
        hardLabel.setPreferredSize(new Dimension(width / 4, Config.SCALE));
        hardLabel.setAlignmentX(Component.CENTER_ALIGNMENT);


        rankingPanel.addTab("Easy", easyPanel);
        rankingPanel.addTab("Normal", normalPanel);
        rankingPanel.addTab("Hard", hardPanel);

        rankingPanel.setTabComponentAt(0, easyLabel);
        rankingPanel.setTabComponentAt(1, normalLabel);
        rankingPanel.setTabComponentAt(2, hardLabel);
    }

    public void updateRankingBoard() {

        List<Document> playerList = view.getRankingBoard();

        List<Map.Entry<String, Integer>> easyBoard = new ArrayList<>();
        List<Map.Entry<String, Integer>> normalBoard = new ArrayList<>();
        List<Map.Entry<String, Integer>> hardBoard = new ArrayList<>();

        for (Document player: playerList) {

            addToList(easyBoard, player, GameMode.Easy);
            addToList(normalBoard, player, GameMode.Normal);
            addToList(hardBoard, player, GameMode.Hard);
        }

        easyBoard.sort(comp.reversed());
        normalBoard.sort(comp.reversed());
        hardBoard.sort(comp.reversed());


        resetPanel(easyPanel);
        resetPanel(normalPanel);
        resetPanel(hardPanel);

        String currentUsername = Database.getCurrentUsername();

        for (int i = 0; i < Math.min(5, playerList.size()); i++) {

            Map.Entry<String, Integer> easyEntry = easyBoard.get(i);
            Map.Entry<String, Integer> normalEntry = normalBoard.get(i);
            Map.Entry<String, Integer> hardEntry = hardBoard.get(i);

            addPlayerToTable(i, easyEntry, easyPanel, currentUsername);
            addPlayerToTable(i, normalEntry, normalPanel, currentUsername);
            addPlayerToTable(i, hardEntry, hardPanel, currentUsername);
        }

    }

    private void resetPanel(JPanel panel) {

        panel.removeAll();
        panel.validate();
        panel.repaint();

        JLabel rank = new JLabel("RANK", SwingConstants.CENTER);
        rank.setFont(font.deriveFont(Font.BOLD, 20));

        JLabel playerName = new JLabel("PLAYER NAME", SwingConstants.CENTER);
        playerName.setFont(font.deriveFont(Font.BOLD, 20));

        JLabel highScore = new JLabel("SCORE", SwingConstants.CENTER);
        highScore.setFont(font.deriveFont(Font.BOLD, 20));


        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;

        gbc.gridx = 0;
        panel.add(rank, gbc);

        gbc.gridx = 1;
        panel.add(playerName, gbc);

        gbc.gridx = 2;
        panel.add(highScore, gbc);
    }

    private void addPlayerToTable(int index,
                                  Map.Entry<String, Integer> entry,
                                  JPanel panel,
                                  String currentUsername) {

        String[] name = entry.getKey().split("#", 2);
        String username = name[0];
        String playerName = name[1];

        JLabel lbRank = new JLabel(Integer.toString(index + 1), SwingConstants.CENTER);
        JLabel lbPlayerName = new JLabel(playerName, SwingConstants.CENTER);
        JLabel lbHighScore = new JLabel(entry.getValue().toString(), SwingConstants.CENTER);

        lbRank.setFont(font);
        lbPlayerName.setFont(font);
        lbHighScore.setFont(font);

//        if (currentUsername.compareTo(username) == 0)
        lbRank.setBackground(Color.YELLOW);

        // column index
        gbc.gridy = index + 1;

        gbc.gridx = 0;
        panel.add(lbRank, gbc);

        gbc.gridx = 1;
        panel.add(lbPlayerName, gbc);

        gbc.gridx = 2;
        panel.add(lbHighScore, gbc);
    }

    private void addToList(List<Map.Entry<String, Integer>> list, Document doc, GameMode mode) {

        Map.Entry<String, Integer> entry = new Map.Entry<>() {
            @Override
            public String getKey() {
                return doc.get("username").toString() + "#" + doc.get("playerName").toString();
            }

            @Override
            public Integer getValue() {
                switch (mode) {
                    case Easy:
                        return doc.getInteger("highScoreEasy");
                    case Normal:
                        return doc.getInteger("highScoreNormal");
                    default:
                        return doc.getInteger("highScoreHard");
                }
            }

            @Override
            public Integer setValue(Integer value) {
                return null;
            }
        };

        list.add(entry);
    }
}
