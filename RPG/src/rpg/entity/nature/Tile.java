package rpg.entity.nature;

import java.awt.Graphics;
import java.awt.Image;

public abstract class Tile {
    protected static final int width = 32, height = 32;
    protected int x, y;
    protected Image[] image;

    public Tile(Image[] image, int x, int y) {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public abstract void update();

    public abstract void render(Graphics g, int x, int y);
}
