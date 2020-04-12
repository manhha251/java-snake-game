package View;

import Model.RenderObject;

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
 */

public class GamePanel extends JPanel {

    private int width;
    private int height;
    private int scale;

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

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void addRenderObject(RenderObject o) {

        objectList.add(o);
    }

    public void setObjectList(LinkedList<RenderObject> list) {

        objectList = list;
    }

    public void removeRenderObject(RenderObject o) {

        if (objectList.contains(o))
            objectList.remove(o);
    }

    public void removeAllObject() {

        objectList.clear();
    }

    public void gameOver() {
        //saveData(model.getHighScore());
        JOptionPane.showMessageDialog(this, "View.Game Over", "View.Game Over", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }

    /*
     * Paint all GI main components: layout, snake, apple, obstacles,...
     */
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;

        paintBackGround(g2d);

        for (RenderObject o: objectList) {

            o.paint(g2d);
        }
    }

    /*
     * paint white border between cells in background
     */
    private void paintBackGround(Graphics2D g2d) {

        g2d.setColor(Color.white.darker());
        g2d.setStroke(new BasicStroke(0.2f));
        for (int i = 0; i < width; i += scale) {
            for (int j = 0; j < height; j += scale) {
                g2d.drawLine(i, j, i + scale - 1, j);
                g2d.drawLine(i, j, i, j + scale - 1);
            }
        }
    }
}
