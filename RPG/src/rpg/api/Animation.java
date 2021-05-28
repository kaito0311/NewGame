package rpg.api;

import java.awt.image.BufferedImage;

public class Animation {
    private int index, deltatime;
    private BufferedImage[] Images;
    private long time, last_time;

    public Animation(BufferedImage[] Image, int deltatime) {
        this.Images = Image;
        this.deltatime = deltatime;
        index = 0;
        time = 0;
        last_time = System.currentTimeMillis();
    }

    public int getImageLength() {
        return Images.length;
    }

    public void update() {
        time += System.currentTimeMillis() - last_time;
        last_time = System.currentTimeMillis();
        if (time > deltatime) {
            index++;
            time = 0;
            if (index >= Images.length)
                index = 0;
        }
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public BufferedImage getCurrentImage(BufferedImage[] Images) {
        return Images[index];
    }

}