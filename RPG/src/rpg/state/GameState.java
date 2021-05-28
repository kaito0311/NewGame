package rpg.state;

import java.awt.Graphics;
import rpg.entity.creature.Player;
import rpg.entity.creature.npc.Boss;
import rpg.entity.creature.npc.MonsterManager;
import rpg.game.Game;

public class GameState {
    private Game game;
    private Player player;
    private Boss boss1, boss2, boss0; //
    private MonsterManager monsters1, monsters2, monsters0;

    public GameState(Game game) {
        this.game = game;
        player = new Player(game, 96, 96, 32, 32);
        monsters0 = new MonsterManager(game, player, 10);
        monsters1 = new MonsterManager(game, player, 14);
        monsters2 = new MonsterManager(game, player, 18);
        // khai bao 3 con boss
        // }
        boss0 = new Boss(game, player, 400,400,105,90);
    }

    public void update() {
        if(!player.getDead()) {
        	player.update();
        	if (this.game.getCurrentMap().getId() == 0) {
                monsters0.update();
                boss0.update();
            } else if (this.game.getCurrentMap().getId() == 1) {
                monsters1.update(); boss0.update();
                // boss1.update();
            } else if (this.game.getCurrentMap().getId() == 2) {
                monsters2.update(); boss0.update();
                // boss2.update();
            }
        }
    }

    public void render(Graphics g) {
        if(!player.getDead()) {
        	player.render(g);
        	if (game.getCurrentMap().getId() == 0) {
                monsters0.render(g);
                boss0.render(g);
            } else if (game.getCurrentMap().getId() == 1) {
                monsters1.render(g);
                boss0.render(g);
                // boss1.render(g);
            } else if (game.getCurrentMap().getId() == 2) {
                monsters2.render(g);
                boss0.render(g);
                // boss2.render(g);
            }
        }
    }

    public Player getPlayer() {
        return this.player;
    }
}
