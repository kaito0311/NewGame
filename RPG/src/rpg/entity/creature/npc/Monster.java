package rpg.entity.creature.npc;

import java.awt.image.BufferedImage;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.Graphics;
import java.awt.Color;
import rpg.api.Animation;
import rpg.entity.creature.Player;
import rpg.game.Game;
import rpg.game.GameStart;

public class Monster extends NPC {

    private Animation monsterMove;
    private BufferedImage[] Image;

    public Monster(Game game, Player player, float x, float y, int width, int height) {
        super(game, player, x, y, width, height);
        this.HP = 100;
        this.damage = 2;
        this.armor = 1;
        this.R = 50.0;
        time_move = 0;

    }

    public void setRandomCenter() {
        center_X = ThreadLocalRandom.current().nextInt(1, 300);
        center_Y = ThreadLocalRandom.current().nextInt(1, 300);
    }

    public void setAnimationImage(BufferedImage[] Image) {
        this.Image = Image;
        monsterMove = new Animation(Image, 200);
    }

    public Animation getAnimationImage() {
        return monsterMove;
    }

    public BufferedImage[] getImage() {
        return Image;
    }

    public void update() {
        die();
        monsterMove.update();
        attackOther();
        playerAttack();
        move();

    }

    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect((int) x + 10, (int) y - 4, 20, 4); //
        g.setColor(Color.red);
        g.fillRect((int) x + 10, (int) y - 4, HP / 4, 4);
        // g.setColor(Color.green);
        // g.fillRect((int) x, (int) y, bounds.width, bounds.height);
        g.drawImage(getAnimationImage().getCurrentImage(getImage()), (int) x, (int) y, 32, 32, null);
    }

    
    @Override
	public void move()
	{
        super.move();
		if(System.currentTimeMillis() - time_move > 1000 || !outOfRange(x, y))
		{ 
			time_move = System.currentTimeMillis();
				// rand = Math.random();
				if (ThreadLocalRandom.current().nextInt(1, 100) < 50) {
					moveX();
				} else {
					moveY();
				}
		}
		// x+= deltaX;
		// y+= deltaY;

	}


    @Override
    public void attackOther() {
        player.setRectForAttack(0);
        this.setRectForAttack(0);
        attackOther.attack(player, this, 10);  
    }

    @Override
    public void playerAttack() {
        player.setRectForAttack(10);
        this.setRectForAttack(0);
        if(player.isAttack())
        attackOther.attack(this, player, 10);        
    }

    //  if(x < 32 || x > GameStart.MAX_WIDTH-32 || y < 32 || y > GameStart.MAX_HEIGHT - 32)
    // {
    //     deltaX = 0;
    //     deltaY = 0;
    // }

    }
