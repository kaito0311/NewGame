package rpg.entity.nature;

import java.awt.Graphics;
import java.awt.Image;

import rpg.api.Texture;

public class FlagRed extends Tile {
    private static Image[] flagReds;
    private int id;

    // id from 1 to 15
    public FlagRed() {
        super(flagReds, 0, 0);
        init();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void init() {
        flagReds = new Image[4];
        for (int i = 1; i <= 3; i++) {
            flagReds[i] = Texture.getTexture("flag_red_" + i);
        }
    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(flagReds[id], (int) (32 * x), (int) (32 * y), null);
    }

    @Override
    public void update() {

    }

}
