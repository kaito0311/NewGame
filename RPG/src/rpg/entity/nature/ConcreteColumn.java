package rpg.entity.nature;

import java.awt.Graphics;
import java.awt.Image;

import rpg.api.Texture;

public class ConcreteColumn extends Tile {
	private static Image image[];
	private int id;

	public ConcreteColumn() {
		super(image, 0, 0);
		init();
	}

	public void init() {
		image = new Image[3];
		for (int i = 0; i < 3; i++) {
			image[i] = Texture.getTexture("column_" + (i + 1));
		}
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
