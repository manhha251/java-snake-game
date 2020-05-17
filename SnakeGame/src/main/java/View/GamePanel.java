package main.java.View;

import main.java.Model.RenderObject;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/*
 * Panel for main game board
 * Displayed the game while it's running
 * Draw the layout of the board as well as the snake, apple, obstacles,...
 *
 * @author Luu Pham Manh Ha - 1752001
 *         Nguyen Hoang Anh - 1652002
 *         Nguyen Thi Quynh Hoa - 1752017
 */

public class GamePanel extends JPanel {

    private int width;
    private int height;
    private final int scale;

    private List<RenderObject> objectList = new LinkedList<>();

    public GamePanel(int width, int height, int scale) {

        this.width = width;
        this.height = height;
        this.scale = scale;
        setPreferredSize(new Dimension(width, height));

        setFocusable(true);
        setBackground(Color.black);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setObjectList(LinkedList<RenderObject> list) {

        objectList = list;
    }

    /*
     * Paint all game's main components: layout, snake, apple, obstacles,...
     */
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;

        for (RenderObject o: objectList) {

            o.paint(g2d);
        }
    }

}
