package com.chewithewookie.wave.main;

import java.awt.*;

public class Pause {

    public static void clicked(int mx, int my) {
        if(Game.mouseOver(mx, my,Game.WIDTH/2 - Game.scale/2, Game.HEIGHT/2-Game.scale/4, Game.scale, Game.scale/4)){
            Game.gameState = STATE.Game;

            Spawner.player();
        }

        if(Game.mouseOver(mx, my, Game.WIDTH/2 - Game.scale/2, Game.HEIGHT/2 + Game.scale/8, Game.scale, Game.scale/4)){
            Game.gameState = STATE.Menu;
        }

        if(Game.mouseOver(mx, my, Game.WIDTH/2 - Game.scale/2, Game.HEIGHT/2 + Game.scale/2, Game.scale, Game.scale/4)){
            System.exit(1);
        }
    }

    public static void render(Graphics g) {
        Font  font = new Font("arial", 1, Game.scale/2);
        Font font2 = new Font("arial", 1, Game.scale/8);

        g.setFont(font);

        g.setColor(Color.white);
        g.drawString("Game Paused", Game.WIDTH/2 - Game.stringWidth("Game Paused", g)/2, Game.HEIGHT/5);

        g.setFont(font2);

        g.drawRect(Game.WIDTH/2 - Game.scale/2, Game.HEIGHT/2-Game.scale/4, Game.scale, Game.scale/4);
        g.drawString("Resume", Game.WIDTH/2 - Game.stringWidth("Resume", g)/2, Game.HEIGHT/2 - Game.scale/16 - 8);

        g.drawRect(Game.WIDTH/2 - Game.scale/2, Game.HEIGHT/2 + Game.scale/8, Game.scale, Game.scale/4);
        g.drawString("Main Menu", Game.WIDTH/2 - Game.stringWidth("Main Menu", g)/2, Game.HEIGHT/2 + Game.scale/4 + 8);

        g.drawRect(Game.WIDTH/2 - Game.scale/2, Game.HEIGHT/2 + Game.scale/2, Game.scale, Game.scale/4);
        g.drawString("Exit Game", Game.WIDTH/2 - Game.stringWidth("Exit Game", g)/2, Game.HEIGHT/2 + Game.scale/3*2);
    }
}