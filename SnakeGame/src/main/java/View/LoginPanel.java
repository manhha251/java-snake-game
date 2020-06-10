package main.java.View;

import main.java.Config.Config;
import main.java.Database.Database;
import main.java.Util.AppState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * Panel for login form
 *
 * @author Luu Pham Manh Ha - 1752001
 *         Nguyen Hoang Anh - 1652002
 *         Nguyen Thi Quynh Hoa - 1752017
 */

public class LoginPanel extends JPanel implements KeyListener {

    private JTextField username;
    private JPasswordField password;
    private View view;
    private JButton btnLogin, btnQuit;

    private final Font defaultFont = Config.DEFAULT_FONT;

    public LoginPanel(View view, int width, int height) {

        this.view = view;

        setPreferredSize(new Dimension(width, height));
        setLayout(new BorderLayout());

        setBackground(Color.black);
        JLabel title = new JLabel("SNAKE GAME");
        title.setFont(defaultFont.deriveFont(Font.BOLD, (float) (Config.SCALE * 2.5)));
        title.setForeground(Color.green);
        title.setHorizontalAlignment(JLabel.CENTER);

        GridLayout grid = new GridLayout(0, 2);
        grid.setHgap(Config.SCALE / 2);
        grid.setVgap(Config.SCALE / 2);

        JPanel pnLogin = new JPanel(grid);
        pnLogin.setName("Login");
        pnLogin.setBorder(BorderFactory.createTitledBorder("Login Form"));

        btnLogin = new JButton("Login");
        btnLogin.addActionListener(e -> {
            if (username.getText().length() == 0 || password.getPassword().length == 0) {

                JOptionPane.showMessageDialog(view, "Field must not empty");
            } else if (Database.authenticate(username.getText(), String.copyValueOf(password.getPassword()))) {

                view.updatePlayerInfo(Database.getPlayerInfo(username.getText()));
                view.changeState(AppState.MainMenu);
                reset();
            } else {

                JOptionPane.showMessageDialog(view, "Wrong username or password");
            }
        });

        JButton btnRegister = new JButton("Register");
        btnRegister.addActionListener(e-> {
            reset();
            view.changeState(AppState.Register);
        });

        btnQuit = new JButton("Quit Game");
        btnQuit.addActionListener(e-> quit());

        username = new JTextField(20);
        username.setHorizontalAlignment(0);
        username.addKeyListener(this);
        password = new JPasswordField(20);
        password.setHorizontalAlignment(0);
        password.addKeyListener(this);

        pnLogin.add(new JLabel("Username: "));
        pnLogin.add(username);
        pnLogin.add(new JLabel("Password: "));
        pnLogin.add(password);
        pnLogin.add(btnRegister);
        pnLogin.add(btnLogin);

        JPanel titlePanel = new JPanel(new GridBagLayout());
        titlePanel.setPreferredSize(new Dimension(width, height / 3));
        titlePanel.setBackground(Color.black);
        titlePanel.add(title);

        JPanel btnPanel = new JPanel(new GridBagLayout());
        btnPanel.setPreferredSize(new Dimension(width, height / 3));
        btnPanel.setBackground(Color.black);
        btnPanel.add(btnQuit);

        JPanel paddingLeft = new JPanel();
        paddingLeft.setPreferredSize(new Dimension(width / 3, height));
        paddingLeft.setBackground(Color.black);

        JPanel paddingRight = new JPanel();
        paddingRight.setPreferredSize(new Dimension(width / 3, height));
        paddingRight.setBackground(Color.black);

        add(titlePanel, BorderLayout.PAGE_START);
        add(paddingLeft, BorderLayout.LINE_START);
        add(pnLogin, BorderLayout.CENTER);
        add(paddingRight, BorderLayout.LINE_END);
        add(btnPanel, BorderLayout.PAGE_END);
        setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public void reset() {

        username.setText("");
        password.setText("");
    }

    public void quit() {
        int choice = JOptionPane.showConfirmDialog(view, "Do you want to quit game ?",
                "Quit game", JOptionPane.YES_NO_OPTION);
        // 0: YES, 1: NO
        if (choice == 0) {
            Database.close();
            System.exit(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {

            btnLogin.doClick();
        } else if (keyCode == KeyEvent.VK_ESCAPE) {

            btnQuit.doClick();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
