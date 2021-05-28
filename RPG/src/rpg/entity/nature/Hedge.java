package rpg.entity.nature;

import java.awt.Graphics;
import java.awt.Image;

import rpg.api.Texture;

public class Hedge extends Tile {
    private static Image[] hedges;
    private int id;

    // id from 1 to 15
    public Hedge() {
        super(hedges, 0, 0); // ke di Tile hoi phe vat
        init();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void init() {
        hedges = new Image[7];
        hedges[1] = Texture.getTexture("hedge_1");
        hedges[2] = Texture.getTexture("hedge_2");
        hedges[3] = Texture.getTexture("hedge_3");
        hedges[4] = Texture.getTexture("hedge_4");
        hedges[5] = Texture.getTexture("hedge_5");
        hedges[6] = Texture.getTexture("hedge_6");
    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(hedges[id], (int) (32 * x), (int) (32 * y), null);
    }

    @Override
    public void update() {

    }

}
