package Model;

import Config.Config;

import java.awt.*;

public class Apple implements RenderObject{

    private int scale = Config.SCALE;

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
