package com.chewithewookie.wave.main;

import java.awt.*;

public class HUD {

    public static float health = 100;

    public static int score = 0;
    public static int level = 1;

    public static void update(){
        health = Game.clamp(health, 0, 100);
    }

    public static void clicked(int mx, int my){
//        if(com.chewithewookie.wave.main.Game.mouseOver(mx, my, com.chewithewookie.wave.main.Game.BORDER, com.chewithewookie.wave.main.Game.HEIGHT - com.chewithewookie.wave.main.Game.scale/8 - com.chewithewookie.wave.main.Game.BORDER, com.chewithewookie.wave.main.Game.scale/2, com.chewithewookie.wave.main.Game.scale/8)){
//            com.chewithewookie.wave.main.Game.gameState = com.chewithewookie.wave.main.STATE.com.chewithewookie.wave.main.Shop;
//        }
    }

    public static void render(Graphics g){
        Font font = new Font("arial", 1, Game.scale/16);

        g.setFont(font);

        g.setColor(Color.red);
        g.fillRect(Game.WIDTH - 200 - Game.BORDER, Game.HEIGHT - Game.BORDER * 2, 200, 16);
        g.setColor(Color.green);
        g.fillRect(Game.WIDTH - 200 - Game.BORDER, Game.HEIGHT - Game.BORDER * 2, (int)health*2, 16);
        g.setColor(Color.gray);
        g.drawRect(Game.WIDTH - 200 - Game.BORDER, Game.HEIGHT - Game.BORDER * 2, 200, 16);

        g.drawString("Level: " + level, Game.BORDER, Game.BORDER + Game.BORDER/2);
        g.drawString("Score: " + score, Game.WIDTH - Game.BORDER - Game.stringWidth("Score: " + score, g), Game.BORDER + Game.BORDER/2);

//        g.drawRect(com.chewithewookie.wave.main.Game.BORDER, com.chewithewookie.wave.main.Game.HEIGHT - com.chewithewookie.wave.main.Game.scale/8 - com.chewithewookie.wave.main.Game.BORDER, com.chewithewookie.wave.main.Game.scale/2, com.chewithewookie.wave.main.Game.scale/8);
//        g.drawString("com.chewithewookie.wave.main.Shop", com.chewithewookie.wave.main.Game.BORDER + com.chewithewookie.wave.main.Game.scale/4 - com.chewithewookie.wave.main.Game.stringWidth("com.chewithewookie.wave.main.Shop", g)/2, com.chewithewookie.wave.main.Game.HEIGHT - com.chewithewookie.wave.main.Game.scale/32 - 4 - com.chewithewookie.wave.main.Game.BORDER);
    }

}