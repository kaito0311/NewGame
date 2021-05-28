package rpg.entity.nature;

import java.awt.Graphics;
import java.awt.Image;

import rpg.api.Texture;

public class FlagBlack extends Tile {
    private static Image[] flagBlacks;
    private int id;

    // id from 1 to 15
    public FlagBlack() {
        super(flagBlacks, 0, 0);
        init();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void init() {
        flagBlacks = new Image[4];
        for (int i = 1; i <= 3; i++) {
            flagBlacks[i] = Texture.getTexture("flag_black_" + i);
        }
    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(flagBlacks[id], (int) (32 * x), (int) (32 * y), null);
    }

    @Override
    public void update() {

    }

}
