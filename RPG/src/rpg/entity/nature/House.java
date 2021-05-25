package rpg.entity.nature;

import java.awt.Graphics;
import java.awt.Image;

import rpg.api.Texture;

public class House extends Tile {
    private static Image[] houses;
    private int id;

    // id from 1 to 15
    public House() {
        super(houses, 0, 0);
        init();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void init() {
        houses = new Image[22];
        for (int i = 1; i <= 20; i++) {
            houses[i] = Texture.getTexture("house_" + i);
        }
    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(houses[id], (int) (32 * x), (int) (32 * y), null);
    }

    @Override
    public void update() {

    }

}
