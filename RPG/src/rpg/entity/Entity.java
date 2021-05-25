package rpg.entity;

import java.awt.Graphics;

import rpg.game.Game;
import java.awt.Rectangle;
public abstract class Entity {
    protected float x, y;
    protected int width, height;
    public Game game;
    // Minh sua // 
    protected Rectangle rectForAttack; 

    public Entity(Game game, float x, float y, int width, int height) {
        this.game = game;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        rectForAttack =new Rectangle((int)x,(int) y, width, height);
    }
    // Minh Sua

    public Rectangle getRectForAttack()
    {
        return this.rectForAttack;
    }
    public void setRectForAttack( int x, int y, int width, int height)
    {
        rectForAttack.setBounds(x, y, width, height);;
    }
    //-------------------------------------

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public abstract void update();

    public abstract void render(Graphics g);
}