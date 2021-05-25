package rpg.entity.nature;

import java.awt.Graphics;
import java.awt.Image;

import rpg.api.Texture;

public class Pumpkin extends Tile {
    private static Image[] pumpkins = { Texture.getTexture("pumpkin") };
    private int id;

    public Pumpkin() {
        super(pumpkins, 0, 0);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g, int x, int y) {
        g.drawImage(pumpkins[0], x * 32, y * 32, null);
    }

}
