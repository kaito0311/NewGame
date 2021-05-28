package rpg.entity.nature;

import java.awt.Graphics;
import java.awt.Image;

public class Statue extends Tile {
    private int id;
    private static Image[] image;

    public Statue() {
        super(image, 0, 0);
    }

    public void setID(int id) {
        this.id = id;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g, int x, int y) {
        g.drawImage(image[id], x * 32, y * 32, null);
    }

}
