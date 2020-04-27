import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class Register extends JFrame {
    //JFrame
    static JFrame frame;
    //JButton
    static  JButton btLogin, btRegister, btExit;
    //label to display text
    static  JLabel lbNameGame, lbRegister, lbUsername, lbPass, lbPlayerName ;

    public static void main(String[] args)
    {
        //Creat a new frame to store text field and button
        frame = new JFrame("Register Page");
        //setting the width and height of frame
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create panel
        JPanel panel = new JPanel();
        //add panel to frame
        frame.add(panel);
        placeComponent(panel);
        frame.setVisible(true);

        //show
        //frame.isShowing();
    }

    private static void placeComponent(JPanel panel) {
        panel.setLayout(null);

        //Creat a label to display text
        lbNameGame = new JLabel("SNAKE GAME");
        lbNameGame.setBounds(95,10,180,45);
        panel.add(lbNameGame);

        lbRegister = new JLabel("Register");
        lbRegister.setBounds(10,40,80,25);
        panel.add(lbRegister);

        lbUsername = new JLabel("Username: ");
        lbUsername.setBounds(10,70,80,25);
        panel.add(lbUsername);
        JTextField tfUsername = new JTextField(20);
        tfUsername.setBounds(100, 70, 165, 25);
        panel.add(tfUsername);

        lbPass = new JLabel("Password: ");
        lbPass.setBounds(10,100,80,25);
        panel.add(lbPass);
        JTextField tfPass = new JTextField(20);
        tfPass.setBounds(100, 100, 165, 25);
        panel.add(tfPass);

        lbPlayerName = new JLabel("Player Name: ");
        lbPlayerName.setBounds(10,130,80,25);
        panel.add(lbPlayerName);
        JTextField tfPlayerName = new JTextField(20);
        tfPlayerName.setBounds(100, 130, 165, 25);
        panel.add(tfPlayerName);

        //Creat a new buttons
        btLogin = new JButton("Login");
        btLogin.setBounds(10, 170, 80, 25);
        panel.add(btLogin);

        btRegister = new JButton("Register");
        btRegister.setBounds(140, 170, 100, 25);
        panel.add(btRegister);

        btExit = new JButton("Exit Game");
        btExit.setBounds(75, 200, 110, 25);
        panel.add(btExit);


        //set backgroud of panel
        panel.setBackground(Color.pink);
    }
}
