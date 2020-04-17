package Model;

import Config.Config;

import java.awt.*;

/*
 * Apple object
 * Can be generated at random position on board
 *
 * @Author Luu Pham Manh Ha - 1752001
 */

public class Apple implements RenderObject{

    private final int scale = Config.SCALE;

    private Point apple;

    public Apple() { }

    public Point getApple() {

        return apple;
    }

    public void setApple(Point point) {
        apple = point;
    }

    public void paint(Graphics2D g) {

        g.setColor(Color.red);

        int x = (int)apple.getX();
        int y = (int)apple.getY();

        g.fillOval(x * scale, y * scale, scale, scale);
    }
}
