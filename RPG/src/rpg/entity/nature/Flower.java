package rpg.entity.nature;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import rpg.api.Texture;

public class Flower extends Tile {
    // id l� 16
    int index;
    private static Image[] flower = { Texture.getTexture("flower_1"), Texture.getTexture("flower_2"),
            Texture.getTexture("flower_3"), Texture.getTexture("flower_4"), Texture.getTexture("flower_5"),
            Texture.getTexture("flower_6"), Texture.getTexture("flower_7"), Texture.getTexture("flower_8") };

    public Flower() {
        super(flower, 0, 0);
    }

    @Override
    public void render(Graphics g, int x, int y) {
        index = y % 8;
        g.drawImage(flower[index], (int) (32 * x), (int) (32 * y), null);
    }

    @Override
    public void update() {

    }

}
