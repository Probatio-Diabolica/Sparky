package com.SPARKY.sparky.Audio;

import java.io.File;
import java.io.IOException;

// {a,b},{a,b},{a-b-a-b-a} <-cheer drum pattern a,b ∈ range {39-50}


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Bgm {
    private String path;
    public static Bgm Title = new Bgm("Resources/Music/Title.wav");
    public static Bgm bulletSnd= new Bgm("REsources/Noises/pop.wav");

    public Bgm(String path){
        // Only wav/AU/AIF
        /*
        ??    Issues as of now:
            -> Nothing would be done unless music is completed
        
        !! pros:
            -> good for very very short sound
         * 
        */
        this.path=path;
    }

    public void playBgm(){
                try{
            // Loading the audio file
            File audioFile = new File(path);
            //File audioFile = new File("resources/Title.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            // create a clip
            Clip clip = AudioSystem.getClip();

            clip.open(audioStream);

            // Audio starts
            clip.start();
            // Wait for the clip to finish playing            
            Thread.sleep(clip.getMicrosecondLength()/1000);

            //close the audio
            clip.close();
            audioStream.close();

        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }

    }

   /* public static void main(String[] args) {
        Bgm bg=new Bgm("Resources/Music/Title.wav");
        bg.playBgm();
    }*/
}
