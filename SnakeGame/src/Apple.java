import java.awt.*;
import java.util.Random;

public class Apple {

    private int x;
    private int y;
    private int scale;

    private Random random = new Random();

    private GamePanel game;

    public Apple(GamePanel game, int scale) {

        this.scale = scale;
        this.game = game;
        generateApple();
    }

    public Point getApple() {

        return new Point(x, y);
    }

    public void generateApple() {

        do {
            x = Math.abs(random.nextInt()) % (game.getWidth() / scale);
            y = Math.abs(random.nextInt()) % (game.getHeight() / scale);
        } while (Snake.collision(x, y));
    }

    public void paint(Graphics2D g) {

        g.setColor(Color.red);
        g.fillOval(x * scale, y * scale, scale, scale);
    }
}
