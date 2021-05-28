package rpg.entity.creature.npc;

import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;

import rpg.entity.creature.Creature;
import rpg.entity.creature.Player;
import rpg.game.Game;

public abstract class NPC extends Creature {

	protected Player player;
	protected float center_X, center_Y;
	protected double R;
	protected long time_move;

	public NPC(Game game, Player player, float x, float y, int width, int height) {
		super(game, x, y, width, height);
		this.player = player;
		allowAttack = false;
		time_move = 0;
		dead = false;
		center_X = 200f;
		center_Y = 200f;
		R = 200;

	}

	public boolean outOfRange(float x, float y) {
		double a = Math.sqrt((x - center_X) * (x - center_Y) + (y - center_Y) * (y - center_Y));
		if (a >= R) {
			return false;
		} else
			return true;
	}

	protected void setMoveX() {
		deltaX = 0;
		deltaY = 0;
		// if(this.x > 0 && this.x < GameStart.MAX_WIDTH-32) {
		if (outOfRange(this.x, this.y)) {
			if (ThreadLocalRandom.current().nextInt(1, 100) < 50) {
				deltaX = -2.0f;
			} else
				deltaX = 2.0f;
		} else {
			if (center_X > x) {
				deltaX = 2.0f;
			} else
				deltaX = -2.0f;
		}

	}

	protected void setMoveY() {
		deltaX = 0;
		deltaY = 0;

		if (outOfRange(this.x, this.y)) {

			if (ThreadLocalRandom.current().nextInt(1, 100) < 50)
				deltaY = -2.0f;
			else
				deltaY = 2.0f;
		} else {
			if (center_Y > y) {
				deltaY = 2.0f;
			} else
				deltaY = -2.0f;
		}
		// moveX = 0;

	}

	public boolean getDead() {
		return this.dead;
	}

	public float getCenter_X() {
		return center_X;
	}

	public void setCenter_X(float center_X) {
		this.center_X = center_X;
	}

	public float getCenter_Y() {
		return center_Y;
	}

	public void setCenter_Y(float center_Y) {
		this.center_Y = center_Y;
	}

	public double getR() {
		return R;
	}

	public void setR(double r) {
		R = r;
	}

	public long getTime_move() {
		return time_move;
	}

	public void setTime_move(long time_move) {
		this.time_move = time_move;
	}

	public abstract void update_move();

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub

	}

}
