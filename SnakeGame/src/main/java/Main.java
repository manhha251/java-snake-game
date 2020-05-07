package main.java;

import main.java.Controller.Controller;

import javax.swing.*;

/*
 * Main class for executing program
 * User use Controller for application usage
 * Version: 2.0
 *
 * @author Luu Pham Manh Ha - 1752001
 *         Nguyen Hoang Anh - 1652002
 *         Nguyen Thi Quynh Hoa - 1752017
 */
public class Main{

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            Controller controller = new Controller();
            controller.initScreen();
        });
    }
}