import java.awt.event.*;
        import java.awt.*;
        import javax.swing.*;

public class MainMenu extends JFrame {
    //JFrame
    static JFrame frame;
    //JButton
    static  JButton btLogin, btRegister, btExit;
    //label to display text
    static  JLabel lbNameGame, lbRegister, lbUsername, lbPass, lbPlayerName ;

    public static void main(String[] args)
    {
        //Creat a new frame to store text field and button
        frame = new JFrame("Main Menu");
        //setting the width and height of frame
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create panel
        JPanel panel = new JPanel();
        //add panel to frame
        frame.add(panel);
        placeComponent(panel);
        frame.setVisible(true);
    }

    private static void placeComponent(JPanel panel) {
        panel.setLayout(null);

        //Creat a label to display text
        lbNameGame = new JLabel("SNAKE GAME");
        lbNameGame.setBounds(95,10,180,45);
        panel.add(lbNameGame);

        //Creat a new buttons
        btLogin = new JButton("New Game");
        btLogin.setBounds(90, 60, 100, 25);
        panel.add(btLogin);

        btRegister = new JButton("Load Game");
        btRegister.setBounds(90, 90, 100, 25);
        panel.add(btRegister);

        btExit = new JButton("High Score");
        btExit.setBounds(90, 120, 100, 25);
        panel.add(btExit);

        btLogin = new JButton("Settings");
        btLogin.setBounds(90, 150, 100, 25);
        panel.add(btLogin);

        btRegister = new JButton("Logout");
        btRegister.setBounds(90, 180, 100, 25);
        panel.add(btRegister);
        //set backgroud of panel
        panel.setBackground(Color.pink);
    }
}

