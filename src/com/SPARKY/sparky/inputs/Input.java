package com.SPARKY.sparky.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener{

    public boolean[] keys=new boolean[94];
    public boolean up,down,left , right;
    public void update(){
        // KeyEvent.VK_KeyName
        up=keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
        down=keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
        right=keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
        left=keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];


    } 
    public void keyTyped(KeyEvent e) {
        

    }

    public void keyPressed(KeyEvent e) {

        	keys[e.getKeyCode()]=true;
    }

    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()]=false;
    }

}
