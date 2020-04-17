package View;

import Controller.Controller;
import Util.AppState;

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

    public MainMenuPanel(Controller controller, int width, int height) {

        setBackground(Color.black);
        setPreferredSize(new Dimension(width, height));

        JLabel title = new JLabel("SNAKE GAME");
        title.setFont(new Font("monospaced", Font.BOLD, 60));
        title.setForeground(Color.red);

        JButton btnGameStart = new JButton("Game Start");
        btnGameStart.addActionListener(e->controller.changeState(AppState.InGame));

        JButton btnQuit = new JButton("Quit game");
        btnQuit.addActionListener(e->controller.changeState(AppState.Exit));

        add(title, BorderLayout.NORTH);
        add(btnGameStart, BorderLayout.CENTER);
        add(btnQuit, BorderLayout.SOUTH);
    }
}
