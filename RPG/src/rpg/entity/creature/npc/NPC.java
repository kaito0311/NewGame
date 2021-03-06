package rpg.entity.creature.npc;

import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;

import rpg.entity.creature.Creature;
import rpg.entity.creature.Player;
import rpg.game.Game;
import rpg.game.GameStart;

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


	public void moveX() {
		// super.moveX();
		deltaX = 0;
		deltaY = 0;
		// if(this.x > 0 && this.x < GameStart.MAX_WIDTH-32) {
		if (outOfRange(x, y)) {
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


	public void moveY() {
		// super.moveY();
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
		// if( y < 5 ) deltaY = 0;
		
		// moveX = 0;

	}


	// public void update_move()
	// {
	// 	if(System.currentTimeMillis() - time_move > 3000 || !outOfRange(x, y))
	// 	{ 
	// 		time_move = System.currentTimeMillis();
	// 			// rand = Math.random();
	// 			if (ThreadLocalRandom.current().nextInt(1, 100) < 50) {
	// 				moveX();
	// 			} else {
	// 				moveY();
	// 			}
	// 	}
	// 	x+= deltaX;
	// 	y+= deltaY;

	// }

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
	// public abstract void update_move();
	public abstract void attackOther();
	public abstract void playerAttack();
	


}
