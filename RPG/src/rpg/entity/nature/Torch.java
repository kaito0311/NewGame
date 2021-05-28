package rpg.entity.nature;

import java.awt.Graphics;
import java.awt.Image;

import rpg.api.Texture;

public class Torch extends Tile {
    private int id;
    private static Image[] image = { Texture.getTexture("torch_1"), Texture.getTexture("torch_2") };

    public Torch() {
        super(image, 0, 0);
    }

    public void setID(int id) {
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
