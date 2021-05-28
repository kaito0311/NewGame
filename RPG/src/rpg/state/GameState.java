package rpg.state;

import java.awt.Graphics;
import rpg.entity.creature.Player;
import rpg.entity.creature.npc.Boss;
import rpg.entity.creature.npc.MonsterManager;
import rpg.game.Game;

public class GameState {
    private Game game;
    private Player player;
    private Boss[] boss = new Boss[3]; //
    private MonsterManager monsters1, monsters2, monsters0;

    public GameState(Game game) {
        this.game = game;
        player = new Player(game, 96, 96, 32, 32);
        monsters0 = new MonsterManager(game, player, 10);
        monsters1 = new MonsterManager(game, player, 14);
        monsters2 = new MonsterManager(game, player, 18);
        // khai bao 3 con boss
        // }
        boss[0] = new Boss(game, player, 400,400,105,90, 0);
        boss[1] = new Boss(game, player, 400,400,105,90, 1);
        boss[2] = new Boss(game, player, 400,400,105,90, 2);
    }

    public void update() {
        player.update();
        int i = this.game.getCurrentMap().getId();
        if (i == 0) {
            monsters0.update();

        } else if (i == 1) {
            monsters1.update(); 
            // boss1.update();
        } else if (i == 2) {
            monsters2.update(); 
            // boss2.update();
        }
        boss[i].update();

    }

    public void render(Graphics g) {
        player.render(g);
        int i = this.game.getCurrentMap().getId();
        if (game.getCurrentMap().getId() == 0) {
            monsters0.render(g);

        } else if (game.getCurrentMap().getId() == 1) {
            monsters1.render(g);

            // boss1.render(g);
        } else if (game.getCurrentMap().getId() == 2) {
            monsters2.render(g);

            // boss2.render(g);
        }
        boss[i].render(g);
    }

    public Player getPlayer() {
        return this.player;
    }
}
