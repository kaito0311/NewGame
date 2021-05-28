package rpg.entity.nature;

import java.awt.Graphics;
import java.awt.Image;
import rpg.api.Texture;

public class BigTree extends Tile {
    private static Image[] bigTrees;
    private int id;

    // id from 1 to 15
    public BigTree() {
        super(bigTrees, 0, 0);
        init();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void init() {
        bigTrees = new Image[17];
        for (int i = 0; i < 16; i++) {
            bigTrees[i] = Texture.getTexture("big_tree_" + (i + 1));
        }
    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(bigTrees[id - 1], (int) (32 * x), (int) (32 * y), null);
    }

    @Override
    public void update() {

    }

}
