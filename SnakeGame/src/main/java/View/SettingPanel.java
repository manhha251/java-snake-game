package main.java.View;

import main.java.Config.Config;
import main.java.Database.Database;
import main.java.Util.AppState;

import javax.swing.*;
import java.awt.*;

public class SettingPanel extends JPanel {
    private View view;

    private Font font = new Font("monospaced", Font.PLAIN, 20);

    private JTextField username;
    private JSlider volume;
    private JComboBox comboLevel,comboWindowSize;
    private JButton btnApply, btnReturn;
    private DefaultListCellRenderer listRenderer;

    public SettingPanel(View view, int width, int height) {
        this.view = view;

        listRenderer = new DefaultListCellRenderer();
        listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);

        setBackground(Color.black);
        setPreferredSize(new Dimension(width, height));
        setLayout(new BorderLayout());

        JLabel title = new JLabel("SNAKE GAME", SwingConstants.CENTER);
        title.setFont(font.deriveFont(Font.BOLD, 48));
        title.setForeground(Color.green);
        title.setAlignmentX(CENTER_ALIGNMENT);

        GridLayout grid = new GridLayout(0, 2);
        grid.setHgap(Config.SCALE / 2);
        grid.setVgap(Config.SCALE / 2);

        JPanel pnSetting = new JPanel(grid);
        pnSetting.setName("Setting");
        pnSetting.setBorder(BorderFactory.createTitledBorder("Setting Form"));

        username = new JTextField(20);
        username.setHorizontalAlignment(0);
        JLabel label_1 =new JLabel("Display Name: ");
        label_1.setFont( font.deriveFont(Font.BOLD, 16));
        pnSetting.add(label_1);
        pnSetting.add(username);

        JLabel label_2 =new JLabel("Window size: ");
        label_2.setFont( font.deriveFont(Font.BOLD, 16));
        pnSetting.add(label_2);
        String WindowSize[]={"Small","Normal","Large"};
        comboWindowSize = new JComboBox(WindowSize);
        comboWindowSize.setRenderer(listRenderer);
        pnSetting.add(comboWindowSize);

        JLabel label_4 =new JLabel("Volume: ");
        label_4.setFont( font.deriveFont(Font.BOLD, 16));
        System.out.println(label_4.getLocation().x);
        pnSetting.add(label_4);
        volume = new JSlider(JSlider.HORIZONTAL, 100,0);
        volume.setMajorTickSpacing(25);
        volume.setPaintLabels(true);
        volume.setPaintTicks(true);
        pnSetting.add(volume);

        JPanel btnPanel = new JPanel(new GridBagLayout());
        btnPanel.setPreferredSize(new Dimension(width, height/6));
        btnPanel.setBackground(Color.black);

        btnApply = new JButton("Apply");
        btnApply.addActionListener(e ->{
            System.out.println(username.getText().toString());
            System.out.println(comboWindowSize.getSelectedItem().toString());
            System.out.println(comboLevel.getSelectedItem().toString());
            System.out.println(volume.getValue());

            Config.setSize(comboWindowSize.getSelectedItem().toString());
            Config.setSOUND(volume.getValue());

            int width_1 = Config.BOARD_COLUMNS * Config.SCALE;
            int height_1 = Config.BOARD_ROWS * Config.SCALE;

            System.out.println(width_1);
            System.out.println(height_1);
        });
        pnSetting.add(btnApply);

        btnReturn = new JButton("Return");
        btnReturn.addActionListener(e -> view.changeState(AppState.MainMenu));
        pnSetting.add(btnReturn);

        JPanel paddingLeft = new JPanel();
        paddingLeft.setPreferredSize(new Dimension(width / 6, height));
        paddingLeft.setBackground(Color.black);

        JPanel paddingRight = new JPanel();
        paddingRight.setPreferredSize(new Dimension(width / 6, height));
        paddingRight.setBackground(Color.black);

        add(title, BorderLayout.PAGE_START);
        add(pnSetting, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.PAGE_END);
        add(paddingLeft, BorderLayout.LINE_START);
        add(paddingRight, BorderLayout.LINE_END);
    }
}
