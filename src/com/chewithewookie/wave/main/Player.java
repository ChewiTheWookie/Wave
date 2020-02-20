package com.chewithewookie.wave.main;

import java.awt.*;

public class Player extends GameObject {

    public static int playerSize = 32;

    public Player(int x, int y, ID id){
        super(x, y, id);
    }

    public void update() {

        if(BossEnemy.alive && x >= Game.WIDTH - Game.WIDTH / 4){
            x += -Game.speed;
        }else{
            x += velX;
        }

        y += velY;

        x = Game.clamp((int)x, 0, Game.WIDTH - playerSize);
        y = Game.clamp((int)y, 0, Game.HEIGHT - playerSize);

        switch (Game.gameState){
            case Paused:
            case Shop:
                Handler.removeObject(this);
                break;
        }

        collision();
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect((int)x, (int)y, playerSize, playerSize);
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, playerSize, playerSize);
    }

    public void collision() {
        for (int i = 0; i < Handler.object.size(); i++) {

            GameObject tempObject = Handler.object.get(i);

            switch (tempObject.getId()) {
                case BasicEnemy:
                case FastEnemy:
                case EnemyBullet:
                    if(getBounds().intersects(tempObject.getBounds())){
                        HUD.health -= 2;
                    }
                    break;
                case SmartEnemy:
                case BossEnemy:
                    if(getBounds().intersects(tempObject.getBounds())){
                        HUD.health -= 1;
                    }
                    break;
            }
        }
    }
}