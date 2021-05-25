package rpg.entity.creature;
//////////////////////////////////
// Minh sua , luot xuong cuoi 
//////////////////////////////////
import java.awt.Rectangle;

import rpg.game.Game;
import rpg.game.GameStart;
import rpg.api.Animation;
import rpg.entity.Entity;
import rpg.entity.creature.npc.Attack;

public abstract class Creature extends Entity {
    protected int MAXHP;
    protected int HP;
    protected int damage, armor;
    protected float Speed;
    protected float deltaX, deltaY;
    protected Rectangle bounds;
    protected boolean allowAttack, dead;
    protected Attack attackOther;
    // protected Attack attack;
    protected Animation move_up, move_down, move_left, move_right;

    public Creature(Game game, float x, float y, int width, int height) {
        super(game, x, y, width, height);
        this.deltaX = 0;
        this.deltaY = 0;
        dead = false;
        bounds = new Rectangle(0, 0, width, height);
        attackOther = new Attack();
    }

    public void init() {

    }

    public boolean allowedAttack() {
        return this.allowAttack;
    }

    public void state_update() {

    }

    public void attackOther(Creature Other) {

    }

    public Rectangle getCollisionBounds(int range) {
        return new Rectangle((int) (x + bounds.x - range), (int) (y + bounds.y - range), bounds.width + range * 2,
                bounds.height + range * 2);
    }

    public void moveX() {
        if (x + width + deltaX >= GameStart.MAX_WIDTH || x + deltaX <= 0)
            return;
        if (y + deltaY <= 0 || y + height + deltaY >= GameStart.MAX_HEIGHT)
            return;

        if (deltaX > 0) {
            int tx = (int) (x + deltaX + bounds.x + bounds.width) / 32;
            int ty = (int) (y + bounds.y) / 32;
            int tyY = (int) (y + bounds.y + bounds.height) / 32;
            if (!collisionWithTile(tx, ty) && !collisionWithTile(tx, tyY)) {
                x += deltaX;
            } else {
                x = tx * 32 + -bounds.width - 1 - bounds.x;
            }
        } else if (deltaX < 0) {
            int tx = (int) (x + deltaX + bounds.x) / 32;
            int ty = (int) (y + bounds.y) / 32;
            int tyY = (int) (y + bounds.y + bounds.height) / 32;
            if (!collisionWithTile(tx, ty) && !collisionWithTile(tx, tyY)) {
                x += deltaX;
            } else {
                x = tx * 32 + 32 - bounds.x;
            }
        }

    }

    //
    public void moveY() {
        if (x + width + deltaX >= GameStart.MAX_WIDTH || x + deltaX <= 0)
            return;
        if (y + deltaY <= 0 || y + height + deltaY >= GameStart.MAX_HEIGHT)
            return;

        if (deltaY < 0) {
            int ty = (int) ((y + deltaY + bounds.y) / 32);
            if (!collisionWithTile((int) (x + bounds.x) / 32, ty)
                    && !collisionWithTile((int) (x + bounds.x + bounds.width) / 32, ty)) {
                y += deltaY;
            } else {
                y = ty * 32 + 32 - bounds.y;
            }
        } else if (deltaY > 0) {
            int ty = (int) (y + deltaY + bounds.y + bounds.height) / 32;

            if (!collisionWithTile((int) (x + bounds.x) / 32, ty)
                    && !collisionWithTile((int) (x + bounds.x + bounds.width) / 32, ty)) {
                y += deltaY;
            } else {
                y = ty * 32 - bounds.y - bounds.height - 1;
            }
        }
    }

    public void move() {
        moveX();
        moveY();
    }

    public void die() {
        if (this.HP <= 0)
            this.dead = true;
    }

    public void hurt(int damage) {
        this.HP = this.HP - (damage - this.armor);
    }

    public int getMAXHP() {
        return MAXHP;
    }

    public void setMAXHP(int maxHP) {
        MAXHP = maxHP;
    }

    protected boolean collisionWithTile(int x, int y) {
        if (game.getCurrentMap().getIsRock(x, y) == 1)
            return true;
        else
            return false;
    }
    /////////////////////////Minh sua /////////////////////////
    public void setRectForAttack(int range)
    {
        rectForAttack.setBounds((int) (x + bounds.x - range), (int) (y + bounds.y - range), bounds.width + range * 2,
		bounds.height + range * 2);
    }

}