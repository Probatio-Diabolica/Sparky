package com.SPARKY.sparky.Stage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;



public class Home extends BaseLevel{
//

	// private int[] tiles;
	
	public  Home(String path){	
		super(path); 
	}

	protected void loadLevel(String path) {
		try {
			BufferedImage image= ImageIO.read(new File(path)); 
			// -> Certain arrangements , 
			int widthH=width=image.getWidth(); int heightH=height= image.getHeight(); 

			//tiles=new Tile[height*width];
			tiles=new int[widthH*heightH];
			image.getRGB(0,0,widthH, heightH,tiles,0,width);

			
		} catch (IOException e) {
			// -> It looks a little suspicious here , so can I just come here directly if in case it does not loads the file
			e.printStackTrace();
			System.out.println("Could Not load Level file; Exception at Home");
		}
	} 
	//	ff in "0xff" denotes alpha channel , ff means its 100% opaque while 00 means its 0% opaque aka its transparent
	// grass= 0x16FF45
	// rock = 0xBE796D
	// flower=0xE70000
	//pod = 0x7F0000
	protected void genStage() {
		/*for (int i = 0; i < levelPixy.length; i++) {
			if(levelPixy[i]==0xff16FF45) tiles[i]=Tile.grass;
			if(levelPixy[i]==0xffBE796D) tiles[i]=Tile.rock;
			if(levelPixy[i]==0xffE70000) tiles[i]=Tile.Flower;
			if(levelPixy[i]==0xff7F0000) tiles[i]=Tile.pod;
		}*/
	}

}
