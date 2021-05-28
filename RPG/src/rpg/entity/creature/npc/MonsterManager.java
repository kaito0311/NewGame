package rpg.entity.creature.npc;

import java.awt.image.BufferedImage;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.Graphics;

import rpg.api.Texture;
import rpg.entity.creature.Player;
import rpg.game.Game;

public class MonsterManager {
    private Monster[] monster;
    private int countMonster;
    private Game game;
    private Player player;

    public MonsterManager(Game game, Player player, int countMonster) {
        this.game = game;
        this.player = player;
        this.countMonster = countMonster;
        monster = new Monster[countMonster];
        initPos();
    }

    private BufferedImage[] randomImage(int i) {
        if (i == 0)
            return Texture.bat;
        if (i == 1)
            return Texture.slime;
        if (i == 2)
            return Texture.spider;
        if (i == 3)
            return Texture.skeleton;
        return null;

    }

    private void initPos() {
        float center_X, center_Y;
        for (int i = 0; i < countMonster; i++) {

            center_X = ThreadLocalRandom.current().nextInt(1, 700);
            center_Y = ThreadLocalRandom.current().nextInt(1, 500);
            monster[i] = new Monster(game, player, center_X, center_Y, 32, 32);
            monster[i].setCenter_X(center_X);
            monster[i].setCenter_Y(center_Y);
            monster[i].setAnimationImage(randomImage(i % 4));
            monster[i].setIdItems(ThreadLocalRandom.current().nextInt(1, 700));

        }
    }

    public void update() {
        for (int i = 0; i < countMonster; i++) {
            if (monster[i] != null) {
                monster[i].update();
                // monster[i].player_attack(monster[i]);
                // if (monster[i].getDead()) { // loai bo doi tuong khi chet khoi man hinh
                // monster[i] = null;
                // this.countMonster--;
                // }
            }
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < countMonster; i++) {
            if (monster[i] != null)
                monster[i].render(g);
        }
    }

}
