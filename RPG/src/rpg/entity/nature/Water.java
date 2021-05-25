package rpg.entity.nature;

import java.awt.Graphics;
import java.awt.Image;

import rpg.api.Texture;

public class Water extends Tile {
    private int id;
    private static Image water[];
    // id from 21 to 35

    public Water() {
        super(water, 0, 0);
        init();
    }

    public void init() {
        water = new Image[15];
        for (int i = 0; i < 15; i++) {
            water[i] = Texture.getTexture("water_" + (i + 1));
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g, int x, int y) {
        g.drawImage(water[id - 1], x * 32, y * 32, null);
    }

}