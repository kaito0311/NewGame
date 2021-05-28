package rpg.entity.items;

import java.awt.Graphics;

import rpg.api.Texture;
import rpg.entity.creature.Player;
import rpg.game.Game;
import rpg.interact.Attack;

public class BuffDefense extends Item {
   

    public BuffDefense(Game game, float x, float y, int width, int height) {
        super(game, x, y, width, height);
        takeItems = new Attack();

    }
    @Override
    public void update() {
    }

    @Override
    public void render(Graphics g) {
        if (isAppear == 1)
            g.drawImage(Texture.bottleHP[1], getRectForAttack().x, getRectForAttack().y, this.width, this.height, null);
    }

    @Override
    public void itemBuff(Player player) {
        System.out.println("tang defense");
        player.setArmor((int)(player.getArmor()*1.2));
        ///
    }
}