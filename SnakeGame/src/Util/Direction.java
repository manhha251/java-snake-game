package Util;

/*
 * Enum for Snake direction
 *
 * @Author Luu Pham Manh Ha - 1752001
 */
public enum Direction {
    UP(0, -1),
    DOWN(0, 1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    public final int x, y;
    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
