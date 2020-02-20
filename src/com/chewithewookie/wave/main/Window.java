package com.chewithewookie.wave.main;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;

public class Window extends Canvas {

    public Window(int width, int height, String title, Game game){
        int widthOffset, heightOffset;

        if(System.getProperty("java.version").startsWith("1.8.")){
            widthOffset = 6;
            heightOffset = 29;
        }else if(System.getProperty("java.version").startsWith("1.8.")){
            widthOffset = 16;
            heightOffset = 39;
        } else{
            widthOffset = 40;
            heightOffset = 20;
        }



        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width + widthOffset, height + heightOffset));
        frame.setMinimumSize(new Dimension(width + widthOffset, height + heightOffset));
        frame.setMaximumSize(new Dimension(width + widthOffset, height + heightOffset));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);

        game.start();
    }

}