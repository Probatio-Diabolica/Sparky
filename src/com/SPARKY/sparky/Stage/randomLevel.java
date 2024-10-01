package com.SPARKY.sparky.Stage;

import java.util.Random;

public class randomLevel extends BaseLevel{

    private static final Random random=new Random();
    
    public randomLevel(int height, int width) {
        super(height, width);

    }
     
    protected void genStage(){
        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++){
                tileBL[x+y*width]=random.nextInt(4);
            }
        }
    }

}
