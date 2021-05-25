package rpg.world;

public class WorldMap {
    private Map worldMap[];

    public WorldMap() {
        worldMap = new Map[3];
        initMap();
    }

    private void initMap() {
        worldMap[0] = new Map("src/assets/map3.txt");
        worldMap[0].initPort(1, 264, 350, 610);
        worldMap[0].setId(0);
        worldMap[1] = new Map("src/assets/map2.txt");
        worldMap[1].initPort(320, 1, -99, -99);
        worldMap[1].setId(1);
        worldMap[2] = new Map("src//assets/map.txt");
        worldMap[2].initPort(768, 383, -99, -99);
        worldMap[2].setId(2);
    }

    public Map getMap(int i) {
        return worldMap[i];
    }
}
