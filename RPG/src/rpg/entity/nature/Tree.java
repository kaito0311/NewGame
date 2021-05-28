package rpg.entity.nature;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import rpg.api.Texture;

public class Tree extends Tile {
    // id = 18
    private boolean isBigTree;
    private static Image[] trees;
    private int id;

    public Tree() {
        super(trees, 0, 0);
        init();
    }

    @Override
    public void update() {

    }

    public void init() {
        trees = new Image[4];
        for (int i = 0; i < 4; i++) {
            trees[i] = Texture.getTexture("tree_" + (i + 1));
        }
    }

    @Override
    public void render(Graphics g, int x, int y) {
        g.drawImage(trees[y % 4], x * 32, y * 32, null);
    }

}
