package rpg.entity.creature.npc;

import java.awt.Graphics;

import rpg.api.Animation;
import rpg.api.Texture;
import rpg.entity.Entity;
import rpg.game.Game;

public class Fire extends Entity {

    private Animation fire;
    private float deltaX, deltaY;
    private boolean flip;
    private boolean isBreak;
    private int picture_attack;
    public Fire(Game game, float x, float y, int width, int height, int picture_attack)
    {
        super(game, x, y, width, height);
        fire = new Animation(Texture.fire_attack, 50);
        this.picture_attack = picture_attack;
        flip = false;
        isBreak = false;
    }
    public void setToado(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public void setRoad(float player_x, float player_y) {

        if (player_y > this.y)
            flip = true;
        else
            flip = false;
        deltaX = (player_x - this.x) / fire.getImageLength() * 1.0f;
        deltaY = (player_y - this.y) / fire.getImageLength() * 1.0f;
        // System.out.println(moveX + " " + moveY);
    }
    public void setFlip(boolean flip)
    {
        this.flip = flip;
    }
    public void setIsBreak( boolean isBreak)
    {
        this.isBreak = isBreak;
    }
    public Animation getFire()
    {
        return fire;
    }

    @Override
    public void update() {
        x += deltaX;
        y += deltaY;
        fire.setIndex(picture_attack);
        fire.update();
    }
    public void setPictureAttack(int picture_attack)
    {
        this.picture_attack = picture_attack;
    }

    @Override
    public void render(Graphics g) {
        if (!flip)
        g.drawImage(fire.getCurrentImage(Texture.fire_attack), (int) (x - width / 2), (int) (y - height / 2), 192,
                192, null);
    else
        g.drawImage(fire.getCurrentImage(Texture.fire_attack), (int) (x - width / 2),
                (int) (y - height / 2) + height, 192, -192, null);
        
    }
    
    
}
