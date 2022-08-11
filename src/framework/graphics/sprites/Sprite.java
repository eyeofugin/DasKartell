package framework.graphics.sprites;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Sprite {
    private String path;
    private final int WIDTH,HEIGHT;
    private int[] pixels;

    public Sprite(String path, int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;
        this.path = path;
        this.pixels = new int[width*height];
        load();
    }
    private void load() {
        try {
            BufferedImage image = ImageIO.read(new File(this.path));
            int width = image.getWidth();
            int height = image.getHeight();
            int[] source = new int[width*height];
            image.getRGB(0, 0,width,height,source,0,width);
            convert(source,width);
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }

    private void convert(int[] source,int size) {
        int mult = this.WIDTH / size;

        for(int y = 0; y < this.HEIGHT; y++) {
            for(int x = 0; x < this.WIDTH; x++) {
                this.pixels[x+y*this.WIDTH] = source[(x/mult)+(y/mult)*size];
            }
        }

    }
    public int[] forMult(int mult) {
        int[] result = new int[this.pixels.length * mult * mult];
        int newHeight = this.HEIGHT * mult;
        for(int y = 0; y < newHeight; y++) {
            for(int x = 0; x < newHeight; x++) {
                result[x+y*newHeight] = this.pixels[(x/mult)+(y/mult)*this.WIDTH];
            }
        }
        return result;
    }

    public int[] getPixels() {
        return this.pixels;
    }
}
