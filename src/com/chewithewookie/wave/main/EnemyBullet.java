package com.chewithewookie.wave.main;

import java.awt.*;
import java.util.Random;

public class EnemyBullet extends GameObject {

    Random random = new Random();

    public static int size  = Player.playerSize/2;
    private Color color = Color.red;
    private int spawnLevel;
    private int lifeSpan = 15;

    public EnemyBullet(int x, int y, ID id) {
        super(x, y, id);

        velX = -5;
        velY = random.nextInt(10) + -5;

        spawnLevel = HUD.level;
        lifeSpan += HUD.level - 2;
    }

    public void update() {
        x += velX;
        y += velY;

        Handler.addObject(new Trail((int)x, (int)y, ID.Trail, color, size, 0.05f));

        if(y <= 0 - size || y >= Game.HEIGHT || x <= 0 - size){
            Handler.removeObject(this);
        }
    }

    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect((int)x, (int)y, size, size);
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, size, size);
    }
}