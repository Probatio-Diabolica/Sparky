package com.SPARKY.sparky.inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

//note:	In java , you can implement multiple interfaces but you can't extend more than single class

//!! angle of shooting is in mob.java while radian is in MC.java
public class Mouse implements MouseListener,MouseMotionListener{
    
    // mouse movement: right left
    private static int mouseX=-1;
    
    // Mouse movement: up down
    private static int mouseY=-1;

    //mouseB is just the middle button
    private static int mouseB=-1;

    
    public static int getX(){ 
        /* getX() returns the input of mouse on the X-axis. */

        return mouseX;
    }

    public static int getY(){
        /* getY() returns the input of mouse on the Y-axis. */
        return mouseY;
    }

    public static int getButton(){
        /* getButton() returns the input of mouse on the Button. */
		/*
		-> 1 == leftbuton
		-> 2 == middle button
		-> 3== right button
		 */
        return mouseB;
    }

	public void mouseDragged(MouseEvent e) {
		mouseX=e.getX(); mouseY=e.getY();
		// System.out.println("Dragged ----|| X = " +mouseX+" Y= "+mouseY);
	}

	public void mouseMoved(MouseEvent e) {
		mouseX=e.getX();
		mouseY=e.getY();
		// System.out.println("moved ----|| X = " +mouseX+" Y= "+mouseY);
	}

	public void mouseClicked(MouseEvent e) {
		//note: using mouseclicked gives auto shooting feeling which is why it's better to not use this
		//mouseB=e.getButton();
		//mouseX=e.getX();
		//mouseY=e.getY();
		// System.out.println("clicked ----|| X = " +mouseX+" Y= "+mouseY);
	}

	public void mousePressed(MouseEvent e) {
		mouseB=e.getButton();
		mouseX=e.getX();
		mouseY=e.getY();
		// System.out.println("pressed ----|| X = " +mouseX+" Y= "+mouseY);
	}

	public void mouseReleased(MouseEvent e) {
		mouseB=-1;
		mouseX=e.getX();
		mouseY=e.getY();
		// System.out.println("REleased----|| X = " +mouseX+" Y= "+mouseY);
	}

	public void mouseEntered(MouseEvent e) {
		//This means mouse has entered our game window
		mouseX=e.getX();
		mouseY=e.getY();
		// System.out.println("\nentered ----|| X = " +mouseX+" Y= "+mouseY);
	}

	public void mouseExited(MouseEvent e) {
		//This means mouse has left our game window
	}

}
