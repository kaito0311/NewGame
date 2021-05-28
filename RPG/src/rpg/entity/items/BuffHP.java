package rpg.entity.items;

import java.awt.Graphics;

import rpg.api.Texture;
import rpg.entity.creature.Player;
import rpg.game.Game;
import rpg.interact.Attack;

public class BuffHP extends Item {
    private int deltaHP;

    public BuffHP(Game game, float x, float y, int width, int height) {
        super(game, x, y, width, height);
        takeItems = new Attack();

    }
    @Override
    public void update() {
    }
    @Override
    public void render(Graphics g) {
        if (isAppear == 1)
            g.drawImage(Texture.bottleHP[0], getRectForAttack().x, getRectForAttack().y, this.width, this.height, null);
    }

    @Override
    public void itemBuff(Player player) {
        player.setHP(1500);
        System.out.println(player.getHP());
    }
}