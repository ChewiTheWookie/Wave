package com.chewithewookie.wave.main;

import java.awt.*;

public class Shop {

    public static void clicked(int mx, int my) {
        if(Game.mouseOver(mx, my, Game.BORDER, Game.HEIGHT - Game.scale/8 - Game.BORDER, Game.scale/2, Game.scale/8)){
            Game.gameState = STATE.Game;

            Spawner.player();
        }
    }

    public static void render(Graphics g){
        Font  font = new Font("arial", 1, Game.scale/2);
        Font font2 = new Font("arial", 1, Game.scale/16);

        g.setFont(font);

        g.setColor(Color.white);
        g.drawString("com.chewithewookie.wave.main.Shop", Game.WIDTH/2 - Game.stringWidth("com.chewithewookie.wave.main.Shop", g)/2, Game.HEIGHT/5);

        g.setFont(font2);

        g.drawRect(Game.BORDER, Game.HEIGHT - Game.scale/8 - Game.BORDER, Game.scale/2, Game.scale/8);
        g.drawString("Exit", Game.BORDER + Game.scale/4 - Game.stringWidth("Exit", g)/2, Game.HEIGHT - Game.scale/32 - 4 - Game.BORDER);
    }
}