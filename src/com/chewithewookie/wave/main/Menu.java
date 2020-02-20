package com.chewithewookie.wave.main;

import java.awt.*;

public class Menu {

    private static boolean newGame;

    public static void clicked(int mx, int my) {
        if(Game.mouseOver(mx, my, Game.WIDTH/2 - Game.scale/2, Game.HEIGHT/2-Game.scale/4, Game.scale, Game.scale/4)){
            if(newGame){
                Game.gameState = STATE.Game;

                Spawner.player();
                Spawner.basicEnemy();
            }else{
                Game.gameState = STATE.Game;

                Spawner.player();
            }
        }

        if(Game.mouseOver(mx, my, Game.WIDTH/2 - Game.scale/2, Game.HEIGHT/2 + Game.scale/8, Game.scale, Game.scale/4)){
            System.exit(1);
        }
    }

    public static void update() {
        if(HUD.score == 0 && SpawnTable.scoreKeep == 0 && HUD.health == Game.startHealth){
            newGame = true;
        }else {
            newGame = false;
        }
    }

    public static void render(Graphics g){
        Font font = new Font("arial", 1, Game.scale/2);
        Font font2 = new Font("arial", 1, Game.scale/8);
        Font font3 = new Font("arial", 1, Game.scale/16);

        g.setColor(Color.white);
        g.setFont(font);

        g.drawString(Game.TITLE, Game.WIDTH/2 - Game.stringWidth(Game.TITLE, g)/2, Game.HEIGHT/5);

        g.setFont(font2);

        g.drawRect(Game.WIDTH/2 - Game.scale/2, Game.HEIGHT/2-Game.scale/4, Game.scale, Game.scale/4);
        if(newGame) {
            g.drawString("Play", Game.WIDTH/2 - Game.stringWidth("Play", g)/2, Game.HEIGHT/2 - Game.scale/16 - 8);
        }else{
            g.drawString("Continue", Game.WIDTH/2 - Game.stringWidth("Continue", g)/2, Game.HEIGHT/2 - Game.scale/16 - 8);
        }

        g.drawRect(Game.WIDTH/2 - Game.scale/2, Game.HEIGHT/2 + Game.scale/8, Game.scale, Game.scale/4);
        g.drawString("Exit Game", Game.WIDTH/2 - Game.stringWidth("Exit Game", g)/2, Game.HEIGHT/2 + Game.scale/4 + 8);

        g.setFont(font3);

        g.drawString("By: Chewi The Wookie", Game.BORDER, Game.HEIGHT - Game.scale/32 - 4 - Game.BORDER);
    }

}