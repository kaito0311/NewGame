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
    private Boss[] boss = new Boss[3];
    private MonsterManager monsters1, monsters2, monsters0;

    public GameState(Game game) {
        this.game = game;
        player = new Player(game, 96, 96, 32, 32);
        monsters0 = new MonsterManager(game, player, 10);
        monsters1 = new MonsterManager(game, player, 14);
        monsters2 = new MonsterManager(game, player, 18);
        // khai bao 3 con boss
        // }
        //Linh...
        boss0 = new Boss(game, 400,400,105,90, player, 0);
        boss1 = new Boss(game, 400,400,105,90, player, 1);
        boss2 = new Boss(game, 400,400,105,90, player, 2);
 
        for(int i = 0; i < 3; ++i)
        {
        	boss[i] = new Boss(game, 400,400,105,90, player, i);
        }
        //...
    }

    //Linh...
    public void update() {
    	int i = this.game.getCurrentMap().getId();
        player.update();

        if (i == 0) {
            monsters0.update();
        } else if (i == 1) {
            monsters1.update(); 
        } else if (i == 2) {
            monsters2.update(); 
        }
        boss[i].update();

    }

    public void render(Graphics g) {
    	int i = this.game.getCurrentMap().getId();
        player.render(g);
        if (i == 0) {
            monsters0.render(g);
        } else if (i == 1) {
            monsters1.render(g);
        } else if (i == 2) {
            monsters2.render(g);
        }
        boss[i].render(g);
    }
    //...
    
    public Player getPlayer() {
        return this.player;
    }
}
