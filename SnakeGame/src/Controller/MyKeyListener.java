package Controller;

import Model.Snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * Listener to handle Key Event and actions
 *
 * @author Luu Pham Manh Ha - 1752001
 */

public class MyKeyListener implements KeyListener {

    private Controller controller;

    public MyKeyListener (Controller controller) {
        this.controller = controller;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        controller.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
