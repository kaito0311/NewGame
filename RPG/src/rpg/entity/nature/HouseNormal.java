package rpg.entity.nature;

import java.awt.Graphics;
import java.awt.Image;

import rpg.api.Texture;

public class HouseNormal extends Tile {
    private static Image[] houseNormals;
    private int id;

    // id from 1 to 15
    public HouseNormal() {
        super(houseNormals, 0, 0);
        init();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void init() {
        houseNormals = new Image[19];
        for (int i = 1; i <= 18; i++) {
            houseNormals[i] = Texture.getTexture("house_normal_" + i);
        }
    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(houseNormals[id], (int) (32 * x), (int) (32 * y), null);
    }

    @Override
    public void update() {

    }

}
