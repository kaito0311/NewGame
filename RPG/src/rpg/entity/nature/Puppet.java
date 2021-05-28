package rpg.entity.nature;

import java.awt.Graphics;
import java.awt.Image;

import rpg.api.Texture;

public class Puppet extends Tile {
    private static Image[] puppets;
    private int id;

    // id from 1 to 15
    public Puppet() {
        super(puppets, 0, 0); // ke di Tile hoi phe vat
        init();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void init() {
        puppets = new Image[3];
        puppets[1] = Texture.getTexture("puppet_1");
        puppets[2] = Texture.getTexture("puppet_2");
    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(puppets[id], (int) (32 * x), (int) (32 * y), null);
    }

    @Override
    public void update() {

    }

}
