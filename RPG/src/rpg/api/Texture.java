package rpg.api;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class Texture {
    public static BufferedImage grass, land, grass_tiny, overworld, water, player, house;// sua
    public static HashMap<String, Image> tiles = new HashMap<>();

    public static BufferedImage[] player_down; // luu anh di xuong
    public static BufferedImage[] player_up;
    public static BufferedImage[] player_left;
    public static BufferedImage[] player_right;

    public static BufferedImage[] attack_down;
    public static BufferedImage[] attack_up;
    public static BufferedImage[] attack_right;
    public static BufferedImage[] attack_left;

    // Minh sua
    public static BufferedImage monsterMove, bom;
    public static BufferedImage[] monster;

    public static BufferedImage smallBoss;
    public static BufferedImage[] slime, spider, skeleton, bat;

    //Linh
    public static BufferedImage[] boss = new BufferedImage[3];
    public static BufferedImage[][] boss_up = new BufferedImage[3][3];
    public static BufferedImage[][] boss_down = new BufferedImage[3][3]; 
    public static BufferedImage[][] boss_left = new BufferedImage[3][3]; 
    public static BufferedImage[][] boss_right = new BufferedImage[3][3]; 
    //

    public static BufferedImage[] bom_bum;
    public static BufferedImage[] fire_attack;
    public static BufferedImage fire_blue;

    // end

    public static void loadImage() {
        try {
            grass = ImageIO.read(new File("src/assets/grass.png"));
            land = ImageIO.read(new File("src/assets/land.png"));
            grass_tiny = ImageIO.read(new File("src/assets/grass_tiny.png"));
            overworld = ImageIO.read(new File("src/assets/overworld.png"));
            house = ImageIO.read(new File("src/assets/house.png"));// sua
            water = ImageIO.read(new File("src/assets/water.png"));
            // Minh sua
            player = ImageIO.read(new File("src/assets/character.png"));
            //Linh
            boss[0] = ImageIO.read(new File("src/assets/Flying1.png"));
            boss[1] = ImageIO.read(new File("src/assets/flying0.png"));
            boss[2] = ImageIO.read(new File("src/assets/flying3.png"));
            //
            bom = ImageIO.read(new File("src/assets/Fire02.png"));
            fire_blue = ImageIO.read(new File("src/assets/fire_blue.png"));
            monsterMove = ImageIO.read(new File("src/assets/boss01.png"));
            smallBoss = ImageIO.read(new File("src/assets/dead_characters.png"));
            // End
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Image getTexture(String name) {
        return tiles.get(name);
    }

    // Minh Sua
    public static int getLengthBufferedImage(BufferedImage[] Image) {
        return Image.length;
    }

    // End
    public static void loadTextures() {
        loadImage();
        tiles.put("grass_0", grass_tiny.getSubimage(0, 32 * 4, 32, 32));
        tiles.put("land_1", land.getSubimage(32 * 2, 0, 32, 32));
        tiles.put("land_2", land.getSubimage(32 * 5, 0, 32, 32));
        tiles.put("land_3", land.getSubimage(32 * 6, 0, 32, 32));
        tiles.put("land_4", land.getSubimage(32 * 7, 0, 32, 32));
        tiles.put("land_5", land.getSubimage(32 * 7, 32, 32, 32));
        tiles.put("land_6", land.getSubimage(32 * 6, 32, 32, 32));
        tiles.put("land_7", land.getSubimage(32 * 5, 32, 32, 32));
        tiles.put("land_8", land.getSubimage(32 * 7, 32 * 2, 32, 32));
        tiles.put("land_9", land.getSubimage(32 * 6, 32 * 2, 32, 32));
        tiles.put("land_10", land.getSubimage(32 * 5, 32 * 2, 32, 32));
        tiles.put("land_11", land.getSubimage(0, 32, 32, 32));
        tiles.put("land_12", land.getSubimage(32, 32, 32, 32));
        tiles.put("land_13", land.getSubimage(0, 32 * 2, 32, 32));
        tiles.put("land_14", land.getSubimage(32, 32 * 2, 32, 32));
        tiles.put("land_15", land.getSubimage(32 * 4, 32, 32, 32));
        tiles.put("tree_1", overworld.getSubimage(0 * 32, 5 * 32, 32, 32));
        tiles.put("tree_2", overworld.getSubimage(1 * 32, 5 * 32, 32, 32));
        tiles.put("tree_3", overworld.getSubimage(2 * 32, 5 * 32, 32, 32));
        tiles.put("tree_4", overworld.getSubimage(3 * 32, 5 * 32, 32, 32));
        tiles.put("water_1", water.getSubimage(2 * 32, 0, 32, 32));
        tiles.put("water_2", water.getSubimage(4 * 32, 32, 32, 32));
        tiles.put("water_3", water.getSubimage(5 * 32, 0, 32, 32));
        tiles.put("water_4", water.getSubimage(6 * 32, 0, 32, 32));
        tiles.put("water_5", water.getSubimage(7 * 32, 0, 32, 32));
        tiles.put("water_6", water.getSubimage(7 * 32, 32, 32, 32));
        tiles.put("water_7", water.getSubimage(5 * 32, 32, 32, 32));
        tiles.put("water_8", water.getSubimage(7 * 32, 32 * 2, 32, 32));
        tiles.put("water_9", water.getSubimage(6 * 32, 32 * 2, 32, 32));
        tiles.put("water_10", water.getSubimage(5 * 32, 32 * 2, 32, 32));
        tiles.put("water_11", water.getSubimage(0, 32, 32, 32));
        tiles.put("water_12", water.getSubimage(32, 32, 32, 32));
        tiles.put("water_13", water.getSubimage(32, 32 * 2, 32, 32));
        tiles.put("water_14", water.getSubimage(0, 2 * 32, 32, 32));
        tiles.put("water_15", water.getSubimage(6 * 32, 32, 32, 32));
        tiles.put("flower_1", overworld.getSubimage(0, 6 * 32, 32, 32));
        tiles.put("flower_2", overworld.getSubimage(32, 6 * 32, 32, 32));
        tiles.put("flower_3", overworld.getSubimage(32 * 2, 6 * 32, 32, 32));
        tiles.put("flower_4", overworld.getSubimage(32 * 3, 6 * 32, 32, 32));
        tiles.put("flower_5", overworld.getSubimage(32 * 4, 6 * 32, 32, 32));
        tiles.put("flower_6", overworld.getSubimage(32 * 5, 6 * 32, 32, 32));
        tiles.put("flower_7", overworld.getSubimage(32 * 6, 6 * 32, 32, 32));
        tiles.put("flower_8", overworld.getSubimage(32 * 7, 6 * 32, 32, 32));
        tiles.put("big_tree_1", overworld.getSubimage(32 * 2, 32, 32, 32));
        tiles.put("big_tree_2", overworld.getSubimage(32 * 3, 32, 32, 32));
        tiles.put("big_tree_3", overworld.getSubimage(32 * 2, 32 * 2, 32, 32));
        tiles.put("big_tree_4", overworld.getSubimage(32 * 3, 32 * 2, 32, 32));
        tiles.put("big_tree_5", overworld.getSubimage(32 * 0, 32 * 1, 32, 32));
        tiles.put("big_tree_6", overworld.getSubimage(32 * 1, 32 * 1, 32, 32));
        tiles.put("big_tree_7", overworld.getSubimage(32 * 0, 32 * 2, 32, 32));
        tiles.put("big_tree_8", overworld.getSubimage(32 * 1, 32 * 2, 32, 32));
        tiles.put("big_tree_9", overworld.getSubimage(32 * 4, 32 * 1, 32, 32));
        tiles.put("big_tree_10", overworld.getSubimage(32 * 5, 32 * 1, 32, 32));
        tiles.put("big_tree_11", overworld.getSubimage(32 * 4, 32 * 2, 32, 32));
        tiles.put("big_tree_12", overworld.getSubimage(32 * 5, 32 * 2, 32, 32));
        tiles.put("big_tree_13", overworld.getSubimage(32 * 6, 32 * 1, 32, 32));
        tiles.put("big_tree_14", overworld.getSubimage(32 * 7, 32 * 1, 32, 32));
        tiles.put("big_tree_15", overworld.getSubimage(32 * 6, 32 * 2, 32, 32));
        tiles.put("big_tree_16", overworld.getSubimage(32 * 7, 32 * 2, 32, 32));
        tiles.put("grave_0", overworld.getSubimage(32 * 3, 32 * 8, 32, 32));
        tiles.put("grave_1", overworld.getSubimage(32 * 4, 32 * 8, 32, 32));
        // sua
        tiles.put("flag_blue_1", house.getSubimage(32 * 13, 32 * 0, 32, 32));
        tiles.put("flag_blue_2", house.getSubimage(32 * 13, 32 * 1, 32, 32));
        tiles.put("flag_blue_3", house.getSubimage(32 * 13, 32 * 2, 32, 32));
        tiles.put("flag_black_1", house.getSubimage(32 * 13, 32 * 3, 32, 32));
        tiles.put("flag_black_2", house.getSubimage(32 * 13, 32 * 4, 32, 32));
        tiles.put("flag_black_3", house.getSubimage(32 * 13, 32 * 5, 32, 32));
        tiles.put("flag_red_1", house.getSubimage(32 * 15, 32 * 4, 32, 32));
        tiles.put("flag_red_2", house.getSubimage(32 * 15, 32 * 5, 32, 32));
        tiles.put("flag_red_3", house.getSubimage(32 * 15, 32 * 6, 32, 32));
        tiles.put("flag_red_3", house.getSubimage(32 * 15, 32 * 6, 32, 32));
        tiles.put("pumpkin", overworld.getSubimage(32 * 6, 32 * 20, 32, 32));
        tiles.put("puppet_1", overworld.getSubimage(32 * 3, 32 * 19, 32, 32));
        tiles.put("puppet_2", overworld.getSubimage(32 * 3, 32 * 20, 32, 32));
        tiles.put("hedge_1", overworld.getSubimage(32 * 0, 32 * 22, 32, 32));
        tiles.put("hedge_2", overworld.getSubimage(32 * 0, 32 * 23, 32, 32));
        tiles.put("hedge_3", overworld.getSubimage(32 * 2, 32 * 22, 32, 32));
        tiles.put("hedge_4", overworld.getSubimage(32 * 3, 32 * 22, 32, 32));
        tiles.put("hedge_5", overworld.getSubimage(32 * 2, 32 * 23, 32, 32));
        tiles.put("hedge_6", overworld.getSubimage(32 * 3, 32 * 23, 32, 32));
        tiles.put("hedge_6", overworld.getSubimage(32 * 3, 32 * 23, 32, 32));
        tiles.put("roadSign_1", overworld.getSubimage(32 * 2, 32 * 29, 32, 32));
        tiles.put("roadSign_2", overworld.getSubimage(32 * 5, 32 * 28, 32, 32));
        tiles.put("roadSign_3", overworld.getSubimage(32 * 5, 32 * 29, 32, 32));
        loadHouse();
        loadHouseNormal();

        // Minh Sua
        player_down = new BufferedImage[4];
        player_up = new BufferedImage[4];
        player_right = new BufferedImage[4];
        player_left = new BufferedImage[4];
        attack_up = new BufferedImage[4];
        attack_down = new BufferedImage[4];
        attack_right = new BufferedImage[4];
        attack_left = new BufferedImage[4];

        player_down[0] = player.getSubimage(0, 5, 16, 23);
        player_down[1] = player.getSubimage(16, 5, 16, 23);
        player_down[2] = player.getSubimage(32, 5, 16, 23);
        player_down[3] = player.getSubimage(48, 5, 16, 23);

        player_up[0] = player.getSubimage(0, 69, 16, 23);
        player_up[1] = player.getSubimage(16, 69, 16, 23);
        player_up[2] = player.getSubimage(32, 69, 16, 23);
        player_up[3] = player.getSubimage(48, 69, 16, 23);

        player_left[0] = player.getSubimage(0, 101, 16, 23);
        player_left[1] = player.getSubimage(16, 101, 16, 23);
        player_left[2] = player.getSubimage(32, 101, 16, 23);
        player_left[3] = player.getSubimage(48, 101, 16, 23);

        player_right[0] = player.getSubimage(0, 37, 16, 23);
        player_right[1] = player.getSubimage(16, 37, 16, 23);
        player_right[2] = player.getSubimage(32, 37, 16, 23);
        player_right[3] = player.getSubimage(48, 37, 16, 23);

        attack_down[0] = player.getSubimage(7, 133, 18, 23);
        attack_down[1] = player.getSubimage(39, 133, 18, 23);
        attack_down[2] = player.getSubimage(71, 133, 18, 23);
        attack_down[3] = player.getSubimage(104, 133, 18, 23);

        attack_up[0] = player.getSubimage(7, 165, 18, 23);
        attack_up[1] = player.getSubimage(39, 165, 18, 23);
        attack_up[2] = player.getSubimage(71, 165, 18, 23);
        attack_up[3] = player.getSubimage(104, 165, 18, 23);

        attack_right[0] = player.getSubimage(8, 198, 18, 23);
        attack_right[1] = player.getSubimage(40, 198, 21, 23);
        attack_right[2] = player.getSubimage(71, 198, 18, 23);
        attack_right[3] = player.getSubimage(104, 198, 18, 23);

        attack_left[0] = player.getSubimage(8, 230, 16, 23);
        attack_left[1] = player.getSubimage(32, 230, 20, 23);
        attack_left[2] = player.getSubimage(67, 230, 18, 23);
        attack_left[3] = player.getSubimage(100, 230, 20, 23);

        //linh
        int i;
        for(i = 0; i < 3; ++i) {
	        boss_up[i][0] = boss[i].getSubimage(0, 0, 136, 122);
	        boss_up[i][1] = boss[i].getSubimage(145, 0, 136, 122);
	        boss_up[i][2] = boss[i].getSubimage(291, 0, 136, 122);
	
	        boss_down[i][0] = boss[i].getSubimage(0, 266, 136, 122);
	        boss_down[i][1] = boss[i].getSubimage(145, 266, 136, 122);
	        boss_down[i][2] = boss[i].getSubimage(291, 266, 136, 122);
	
	        boss_right[i][0] = boss[i].getSubimage(0, 122, 136, 122);
	        boss_right[i][1] = boss[i].getSubimage(145, 122, 136, 122);
	        boss_right[i][2] = boss[i].getSubimage(291, 122, 136, 122);
	
	        boss_left[i][0] = boss[i].getSubimage(0, 389, 136, 122);
	        boss_left[i][1] = boss[i].getSubimage(145, 389, 136, 122);
	        boss_left[i][2] = boss[i].getSubimage(291, 389, 136, 122);
        
        }
        //


        bom_bum = new BufferedImage[25];

        bom_bum[0] = bom.getSubimage(0, 0, 320, 232);
        bom_bum[1] = bom.getSubimage(320, 0, 320, 232);
        bom_bum[2] = bom.getSubimage(640, 0, 320, 232);
        bom_bum[3] = bom.getSubimage(960, 0, 320, 232);
        bom_bum[4] = bom.getSubimage(1280, 0, 320, 232);
        bom_bum[5] = bom.getSubimage(0, 232, 320, 232);
        bom_bum[6] = bom.getSubimage(320, 232, 320, 232);
        bom_bum[7] = bom.getSubimage(640, 232, 320, 232);
        bom_bum[8] = bom.getSubimage(960, 232, 320, 232);
        bom_bum[9] = bom.getSubimage(1280, 232, 320, 232);
        bom_bum[10] = bom.getSubimage(0, 464, 320, 232);
        bom_bum[11] = bom.getSubimage(320, 464, 320, 232);
        bom_bum[12] = bom.getSubimage(640, 464, 320, 232);
        bom_bum[13] = bom.getSubimage(960, 464, 320, 232);
        bom_bum[14] = bom.getSubimage(1280, 464, 320, 232);
        bom_bum[15] = bom.getSubimage(0, 696, 320, 232);
        bom_bum[16] = bom.getSubimage(320, 696, 320, 232);
        bom_bum[17] = bom.getSubimage(640, 696, 320, 232);
        bom_bum[18] = bom.getSubimage(960, 696, 320, 232);
        bom_bum[19] = bom.getSubimage(1280, 696, 320, 232);
        bom_bum[20] = bom.getSubimage(0, 696, 320, 232);
        bom_bum[21] = bom.getSubimage(320, 696, 320, 232);
        bom_bum[22] = bom.getSubimage(640, 696, 320, 232);
        bom_bum[23] = bom.getSubimage(960, 696, 320, 232);
        bom_bum[24] = bom.getSubimage(1280, 696, 320, 232);

        fire_attack = new BufferedImage[20];

        fire_attack[0] = fire_blue.getSubimage(0, 0, 192, 192);
        fire_attack[1] = fire_blue.getSubimage(192, 0, 192, 192);
        fire_attack[2] = fire_blue.getSubimage(384, 0, 192, 192);
        fire_attack[3] = fire_blue.getSubimage(576, 0, 192, 192);
        fire_attack[4] = fire_blue.getSubimage(768, 0, 192, 192);
        fire_attack[5] = fire_blue.getSubimage(0, 192, 192, 192);
        fire_attack[6] = fire_blue.getSubimage(192, 192, 192, 192);
        fire_attack[7] = fire_blue.getSubimage(384, 192, 192, 192);
        fire_attack[8] = fire_blue.getSubimage(576, 192, 192, 192);
        fire_attack[9] = fire_blue.getSubimage(768, 192, 192, 192);
        fire_attack[10] = fire_blue.getSubimage(0, 384, 192, 192);
        fire_attack[11] = fire_blue.getSubimage(192, 384, 192, 192);
        fire_attack[12] = fire_blue.getSubimage(384, 384, 192, 192);
        fire_attack[13] = fire_blue.getSubimage(576, 384, 192, 192);
        fire_attack[14] = fire_blue.getSubimage(768, 384, 192, 192);
        fire_attack[15] = fire_blue.getSubimage(0, 576, 192, 192);
        fire_attack[16] = fire_blue.getSubimage(192, 576, 192, 192);
        fire_attack[17] = fire_blue.getSubimage(384, 576, 192, 192);
        fire_attack[18] = fire_blue.getSubimage(576, 576, 192, 192);
        fire_attack[19] = fire_blue.getSubimage(768, 576, 192, 192);

        monster = new BufferedImage[8];
        monster[0] = monsterMove.getSubimage(0, 0, 140, 140);
        monster[1] = monsterMove.getSubimage(140, 0, 140, 140);
        monster[2] = monsterMove.getSubimage(280, 0, 140, 140);
        monster[3] = monsterMove.getSubimage(420, 0, 140, 140);
        monster[4] = monsterMove.getSubimage(558, 0, 140, 140);
        monster[5] = monsterMove.getSubimage(0, 149, 140, 140);
        monster[6] = monsterMove.getSubimage(140, 149, 140, 140);
        monster[7] = monsterMove.getSubimage(280, 149, 140, 140);

        spider = new BufferedImage[1];
        skeleton = new BufferedImage[1];
        slime = new BufferedImage[1];
        bat = new BufferedImage[1];

        spider[0] = smallBoss.getSubimage(16, 48, 16, 16);
        skeleton[0] = smallBoss.getSubimage(0, 32, 16, 16);
        slime[0] = smallBoss.getSubimage(16, 32, 16, 16);
        bat[0] = smallBoss.getSubimage(32, 32, 16, 16);

        // End
    }

    private static void loadHouse() {
        int count = 0;
        for (int j = 11; j <= 14; j++) {
            for (int i = 3; i <= 7; i++) {
                count++;
                tiles.put("house_" + count, house.getSubimage(32 * i, 32 * j, 32, 32));

            }
        }
    }

    private static void loadHouseNormal() {
        int count = 0;
        for (int j = 11; j <= 14; j++) {
            for (int i = 11; i <= 15; i++) {
                if (((j == 11) && (i == 11)) || ((j == 11) && (i == 15)))
                    continue;
                count++;
                tiles.put("house_normal_" + count, house.getSubimage(32 * i, 32 * j, 32, 32));

            }
        }
    }
}