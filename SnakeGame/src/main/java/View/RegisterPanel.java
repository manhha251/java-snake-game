package main.java.View;

import main.java.Config.Config;
import main.java.Database.Database;
import main.java.Util.AppState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

/*
 * Panel for account Registration form
 * Each account with be associated with 1 player
 *
 * Author: Luu Pham Manh Ha - 1752001
 *         Nguyen Hoang Anh - 1652002
 *         Nguuyen Thi Quynh Hoa - 1752017
 */

public class RegisterPanel extends JPanel implements KeyListener {

    private View view;
    private JTextField username, playerName;
    private JPasswordField password, confirmPwd;
    private JButton btnRegister, btnQuit;

    public RegisterPanel(View view, int width, int height) {

        this.view = view;
        setPreferredSize(new Dimension(width, height));
        setLayout(new BorderLayout());
        setBackground(Color.black);

        JLabel title = new JLabel("SNAKE GAME");
        title.setFont(new Font("Monospaced", Font.BOLD, 48));
        title.setForeground(Color.green);
        title.setHorizontalAlignment(JLabel.CENTER);

        GridLayout grid = new GridLayout(0, 2);
        grid.setHgap(Config.SCALE / 2);
        grid.setVgap(Config.SCALE / 2);

        JPanel pnRegister = new JPanel(grid);
        pnRegister.setName("Register");
        pnRegister.setBorder(BorderFactory.createTitledBorder("Register Form"));

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(e -> {
            reset();
            view.changeState(AppState.Login);
        });

        btnRegister = new JButton("Register");
        btnRegister.addActionListener(e -> authenticate());

        btnQuit = new JButton("Quit game");
        btnQuit.addActionListener(e -> quit());

        username = new JTextField(20);
        username.setHorizontalAlignment(0);
        password = new JPasswordField(20);
        password.setHorizontalAlignment(0);
        playerName = new JTextField();
        playerName.setHorizontalAlignment(0);

        confirmPwd = new JPasswordField(20);
        confirmPwd.setHorizontalAlignment(0);

        pnRegister.add(new JLabel("Username*: "));
        pnRegister.add(username);
        pnRegister.add(new JLabel("Player Name*: "));
        pnRegister.add(playerName);
        pnRegister.add(new JLabel("Password*: "));
        pnRegister.add(password);
        pnRegister.add(new JLabel("Confirm Password*: "));
        pnRegister.add(confirmPwd);
        pnRegister.add(btnLogin);
        pnRegister.add(btnRegister);

        JPanel titlePanel = new JPanel(new GridBagLayout());
        titlePanel.setPreferredSize(new Dimension(width, height / 3));
        titlePanel.setBackground(Color.black);
        titlePanel.add(title);

        JPanel btnPanel = new JPanel(new GridBagLayout());
        btnPanel.setPreferredSize(new Dimension(width, height / 5));
        btnPanel.setBackground(Color.black);
        btnPanel.add(btnQuit);

        JPanel paddingLeft = new JPanel();
        paddingLeft.setPreferredSize(new Dimension(width / 4, height));
        paddingLeft.setBackground(Color.black);

        JPanel paddingRight = new JPanel();
        paddingRight.setPreferredSize(new Dimension(width / 4, height));
        paddingRight.setBackground(Color.black);

        add(titlePanel, BorderLayout.PAGE_START);
        add(paddingLeft, BorderLayout.LINE_START);
        add(pnRegister, BorderLayout.CENTER);
        add(paddingRight, BorderLayout.LINE_END);
        add(btnPanel, BorderLayout.PAGE_END);
    }

    private void quit() {
        int choice = JOptionPane.showConfirmDialog(view, "Do you want to quit game ?",
                "Quit game", JOptionPane.YES_NO_OPTION);
        // 0: YES, 1: NO
        if (choice == 0) {
            Database.close();
            System.exit(ABORT);
        }
    }

    private void authenticate() {

        String usn = username.getText();
        String pn = playerName.getText();
        char[] pwd = password.getPassword();
        char[] cfpwd = confirmPwd.getPassword();

        String message = "";
        boolean error = false;

        if (usn.length() * pn.length() * pwd.length == 0) {

            error = true;
            if (usn.length() == 0)
                message = "Username";
            else if (pn.length() == 0)
                message = "Player name";
            else if (pwd.length == 0)
                message = "Password";

            message += " cannot be empty";
        } else {
            if (usn.length() < 6) {
                error = true;
                message = "Username";
            }
            else if (pwd.length < 6) {
                error = true;
                message = "Password";
            }

            message += " must have at least 6 characters";
        }

        /* SYNTAX ERROR */
        if (error) {
            JOptionPane.showMessageDialog(view, message, "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (Arrays.equals(pwd, cfpwd)) {
            view.register(usn, String.copyValueOf(pwd), pn);
            JOptionPane.showMessageDialog(view, "Account created successfully", "Welcome", JOptionPane.INFORMATION_MESSAGE);
            view.changeState(AppState.Login);
            reset();
        } else {

            /* LOGIC ERROR */
            JOptionPane.showMessageDialog(view, "Password confirm not match", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void reset() {

        username.setText("");
        password.setText("");
        confirmPwd.setText("");
        playerName.setText("");
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {

            btnRegister.doClick();
        } else if (keyCode == KeyEvent.VK_ESCAPE) {

            btnQuit.doClick();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
