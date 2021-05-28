package rpg.entity.nature;

import java.awt.Graphics;
import java.awt.Image;

import rpg.api.Texture;

public class Chest extends Tile {
    private int id;
    private static Image image[] = { Texture.getTexture("chest_close_1"), Texture.getTexture("chest_close_2"),
            Texture.getTexture("chest_close_3"), Texture.getTexture("chest_close_4"),
            Texture.getTexture("chest_open_1"), Texture.getTexture("chest_open_2"), Texture.getTexture("chest_open_3"),
            Texture.getTexture("chest_open_4") };

    public Chest() {
        super(image, 0, 0);
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g, int x, int y) {
        g.drawImage(image[id], x * 32, y * 32, null);
    }

}