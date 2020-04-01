import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * Listener to handle Key Event and actions
 *
 * @author Luu Pham Manh Ha - 1752001
 */

public class MyKeyListener implements KeyListener {

    private Snake snake;

    public MyKeyListener (Snake snake) {
        this.snake = snake;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        snake.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
