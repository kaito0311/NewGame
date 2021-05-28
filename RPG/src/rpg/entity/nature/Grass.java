package rpg.entity.nature;

import java.awt.Graphics;
import java.awt.Image;

import rpg.api.Texture;

public class Grass extends Tile {
    private static Image[] grass = { Texture.getTexture("grass_0") };

    public Grass() {
        super(grass, 0, 0);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g, int x, int y) {
        g.drawImage(grass[0], x * 32, y * 32, null);
    }

}
