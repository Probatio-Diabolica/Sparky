package com.SPARKY.sparky.Graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	
    private String path;
    public int SIZE;
    public int[] pixels;
    
    public static SpriteSheet primitiveTile = new SpriteSheet("Resources/Textures/SpriteDemo.png",256);
    public static SpriteSheet Grassland = new SpriteSheet("Resources/Textures/Nature/Grassland.png",256);
    public static SpriteSheet bullet = new SpriteSheet("Resources/Textures/Bullets/bullet.png",48);
    public static SpriteSheet PlayerTest= new SpriteSheet("Resources/Textures/Teste.png", 192);

    // -> removing bc it's redundant
    //public static SpriteSheet bulletB = new SpriteSheet("Resources/Textures/Bullets/bullet.png",48);
    
    public SpriteSheet(String path, int size){
        SIZE=size;
        this.path=path;
        pixels=new int[SIZE*SIZE];
        load(this.path);
    }

    private void load(String path){
        try {
            
            BufferedImage image = ImageIO.read(new File(path));
            int width = image.getWidth();
            int height=image.getHeight();
            image.getRGB(0, 0,width,height,pixels,0,width);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
