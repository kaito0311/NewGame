package rpg.entity.creature.npc;

//////////////Minh Sua //////////////////////
import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;

import rpg.api.Animation;
import rpg.api.Texture;
import rpg.entity.Fire;
import rpg.entity.creature.Player;
import rpg.game.Game;
import java.awt.*;

public class Boss extends NPC {

	private int picture_attack ;
	double alpha = 0;
	private Fire fire;

	public Boss(Game game, Player player, float x, float y, int width, int height) {
		super(game, player, x, y, width, height);
		move_up = new Animation(Texture.boss_up, 200);
		move_down = new Animation(Texture.boss_down, 200);
		move_left = new Animation(Texture.boss_left, 200);
		move_right = new Animation(Texture.boss_right, 200);

		center_X = 600;
		center_Y = 400;
		this.HP = 100;
		time_move = 0;
		picture_attack = 0;
		fire = new Fire(game, x, y, 192, 192, 0);
	}


	public void state_update() {
		move_down.update();
		move_left.update();
		move_right.update();
		move_up.update();
		move();


	}

	public void move() {
		moveX();
		// moveY();
		x += deltaX;
		y += deltaY;
	}

	public void moveX() {
		if (outOfRange(player.getX(), player.getY())) {
			// System.out.println("hmmm");
			allowAttack = true;

			if (Math.abs(player.getX() - x) >= 50f) {
				if (player.getX() > x + 3.0f) {
					deltaX = 3.0f;

				} else
					deltaX = -3.0f;
				deltaY = 0;
				return;
			} else
				moveY();
		} else {
			picture_attack = 0;
			allowAttack = false;
			if (System.currentTimeMillis() - time_move > 3000 || !outOfRange(this.x, this.y)) {
				time_move = System.currentTimeMillis();

				deltaX = 0;
				deltaY = 0;
				if (ThreadLocalRandom.current().nextInt(1, 100) < 50) {
					super.moveX();
				} else {
					super.moveY();
				}
			}
			return;
		}

	}

	public void moveY() {
		if (Math.abs(player.getY() - y) >= 50.0f) {

			if (player.getY() > y + 3.0f) {
				deltaY = 3.0f;
			} else
				deltaY = -3.0f;
			deltaX = 0;
			return;

		}
		deltaX = deltaY = 0;
		return;
	}

	private Graphics2D rotate(Graphics g, int up_down) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate((int) (x), (int) (y));

		// System.out.println(x + " " + y);
		float distance_x = player.getX() - this.x;
		float distance_y = this.y - player.getY();
		distance_y *= up_down;
		if (distance_y < 0.000000001) {
			distance_y = 0.00000001f;
		}
		try {
			alpha = Math.atan((double) (distance_x / distance_y)) * up_down;
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}

		g2d.rotate(alpha);
		g2d.translate(-width / 2, -height / 2);

		return g2d;
	}

	private void unrotate(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(0, 0);
		g2d.rotate(-alpha);
	}

	//----------------------------------------------------
	protected void updateFire()
	{

		if(picture_attack >= fire.getFire().getImageLength())
		{
			picture_attack =0 ; 
			fire.setIsBreak(false);
			fire.setPictureAttack(picture_attack);
		}
		if(picture_attack == 0)
		{
			if(player.getY() < y) 
			fire.setToado(x, y-2);
			else fire.setToado(x, y+10);
			// fire.setRoad(player.getX(), player.getY());

			fire.setRoad(player.getX(), player.getY());
		}

		fire.setPictureAttack(picture_attack);
		picture_attack += 1;

		attackOther();
	}
	//------------------------------------------------------

	@Override
	public void update() {

		state_update();
		fire.update();
		playerAttack();
	}

	@Override
	public void render(Graphics g) {
		if(allowAttack)
		{
			updateFire();
			fire.render(g);
		}
		g.setColor(Color.gray);
		g.fillRect((int) x - 45, (int) y - 40, 100, 4);
		g.setColor(Color.red);
		g.fillRect((int) x - 45, (int) y - 40, HP / 10, 4);

		if (deltaX == 0 && deltaY == 0) {
			// System.out.println(player.getY() + " " + this.y);/
			if ((int) player.getY() < (int) y) {
				// System.out.println("up");
				rotate(g, 1).drawImage(move_up.getCurrentImage(Texture.boss_up), (int) 0, (int) 0, width, height, null);
			} else {
				// System.out.println("down");
				rotate(g, -1).drawImage(move_down.getCurrentImage(Texture.boss_down), (int) 0, (int) 0, width, height,
						null);
			}
		}

		if (deltaX < 0) {
			g.drawImage(move_left.getCurrentImage(Texture.boss_left), (int) (x - width / 2), (int) (y - height / 2),
					width, height, null);
		}
		if (deltaX > 0) {

			g.drawImage(move_right.getCurrentImage(Texture.boss_right), (int) (x - width / 2), (int) (y - height / 2),
					width, height, null);

		}
		if (deltaY < 0) {
			g.drawImage(move_up.getCurrentImage(Texture.boss_up), (int) (x - width / 2), (int) (y - height / 2), width,
					height, null);

		}
		if (deltaY > 0) {
			g.drawImage(move_down.getCurrentImage(Texture.boss_down), (int) (x - width / 2), (int) (y - height / 2),
					width, height, null);

		}

		unrotate(g);

	}

	@Override
	public void attackOther() {
		if(allowAttack)
		{
			player.setRectForAttack((int)player.getX(), (int)player.getY(), (int)player.getWidth(), player.getHeight());
		    fire.setRectForAttack((int)(x - fire.getWidth()/2)+ 30, (int)(y - fire.getHeight()/2)+ 45, 110, 100);
			if(attackOther.attack(player, fire, 10))
			{
				// System.out.println("ok");
			}

		}
		
	}

	@Override
	public void playerAttack() {
		player.setRectForAttack(10);
        this.setRectForAttack(0);
		if(player.isAttack())
        	attackOther.attack(this, player, 10);
		
	}

}
