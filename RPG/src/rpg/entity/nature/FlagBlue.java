package rpg.entity.nature;

import java.awt.Graphics;
import java.awt.Image;

import rpg.api.Texture;

public class FlagBlue extends Tile {
    private static Image[] flagBlues;
    private int id;

    // id from 1 to 15
    public FlagBlue() {
        super(flagBlues, 0, 0);
        init();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void init() {
        flagBlues = new Image[4];
        for (int i = 1; i <= 3; i++) {
            flagBlues[i] = Texture.getTexture("flag_blue_" + i);
        }
    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(flagBlues[id], (int) (32 * x), (int) (32 * y), null);
    }

    @Override
    public void update() {

    }

}
