package rpg.entity.nature;

import java.awt.Graphics;
import java.awt.Image;

import rpg.api.Texture;

public class Land extends Tile {
    private static Image[] lands;
    private int id;

    // id from 1 to 15
    public Land() {
        super(lands, 0, 0);
        init();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void init() {
        lands = new Image[15];
        for (int i = 0; i < 15; i++) {
            lands[i] = Texture.getTexture("land_" + (i + 1));
        }
    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(lands[id - 1], (int) (32 * x), (int) (32 * y), null);
    }

    @Override
    public void update() {

    }

}
