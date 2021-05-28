package rpg.entity.nature;

import java.awt.Graphics;
import java.awt.Image;

import rpg.api.Texture;

public class Grave extends Tile {
    private static Image[] graves;
    private int id;

    // id from 1 to 15
    public Grave() {
        super(graves, 0, 0); // ke di Tile hoi phe vat
        init();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void init() {
        graves = new Image[2];
        graves[0] = Texture.getTexture("grave_0");
        graves[1] = Texture.getTexture("grave_1");
    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(graves[id], (int) (32 * x), (int) (32 * y), null);
    }

    @Override
    public void update() {

    }

}
