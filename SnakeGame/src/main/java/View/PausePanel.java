package main.java.View;

import main.java.Config.Config;
import main.java.Util.AppState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PausePanel extends JPanel implements KeyListener {

    private JButton btnResume, btnForfeit;

    private final Font defaultFont = Config.DEFAULT_FONT;

    public PausePanel(View view) {

        JLabel pausedLabel = new JLabel("PAUSED");
        pausedLabel.setForeground(Color.ORANGE);

        JPanel pausedPanel = new JPanel();
        pausedPanel.setOpaque(false);
        pausedPanel.add(pausedLabel);
        pausedPanel.setFocusable(false);

        setBackground(new Color(123, 63, 0));
        int eb = 15;
        setBorder(BorderFactory.createEmptyBorder(eb, eb, eb, eb));
        setLayout(new GridLayout(0, 1, 10, 10));
        add(pausedPanel);

        btnResume = new JButton("RESUME");
        btnResume.addActionListener(e -> {
            Component comp = (Component) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
            view.changeState(AppState.Continue);
        });
        btnResume.setFocusable(false);

        btnForfeit = new JButton("FORFEIT");
        btnForfeit.addActionListener(e -> {
            Component comp = (Component) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
            int choice = JOptionPane.showConfirmDialog(view,
                    "Do you want to forfeit this game ?" + "\n" +
                    "Your score will not be saved!",
                    "Forfeit game", JOptionPane.YES_NO_OPTION);
            // 0: YES, 1: NO
            if (choice == 0) {
                view.changeState(AppState.Quit);
            } else {
                view.changeState(AppState.Continue);
            }
        });
        btnForfeit.setFocusable(false);

        add(btnResume);
        add(btnForfeit);
        setFocusable(false);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_P || keyCode == KeyEvent.VK_ESCAPE)
            btnResume.doClick();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
