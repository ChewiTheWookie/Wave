package com.chewithewookie.wave.main;

import javax.swing.JFrame;
import java.awt.*;

public class Window extends Canvas {

    public Window(Game game){
        int width = Game.WIDTH;
        int height = Game.HEIGHT;

        JFrame frame = new JFrame(Game.TITLE);

        frame.pack();
        Insets inset = frame.getInsets();
        width += inset.left + inset.right;
        height += inset.top + inset.bottom;

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);

        game.start();
    }

}