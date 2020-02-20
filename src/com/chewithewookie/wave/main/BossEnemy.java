package com.chewithewookie.wave.main;

import java.awt.*;
import java.util.Random;

public class BossEnemy extends GameObject {

    Random random = new Random();

    public static int size  = Player.playerSize * 2;
    private Color color = Color.red;

    private int spawnLevel;
    public static boolean alive = false;
    public static int timeAlive = 0;
    public static boolean shooting = false;


    public BossEnemy(int x, int y, ID id) {
        super(x, y, id);

        velX = -2;
        velY = 0;

        spawnLevel = HUD.level;
        alive = true;
    }

    public void update() {
        x += velX;
        y += velY;

        Handler.addObject(new Trail((int)x, (int)y, ID.Trail, color, size, 0.05f));

        if(x <= Game.WIDTH - Game.WIDTH / 4 && shooting == false) {
            velX = 0;
            shooting = true;
            timeAlive = 0;
        }

        if(shooting){
            int bossLevel = spawnLevel / 25;

            if(velY == 0) velY = -Math.round(Game.speed / 2);
            int spawn = random.nextInt(10 - bossLevel);
            if(spawn == 0){
                Handler.addObject(new EnemyBullet((int) x, (int) y, ID.EnemyBullet));
            }
        }

        if(y <= Game.HEIGHT/4 - size || y >= Game.HEIGHT - Game.HEIGHT/4){
            velY *= -1;
        }

        if(timeAlive == 20 && shooting) {
            alive = false;
            timeAlive = 0;
            shooting = false;
            Handler.removeObject(this);
            HUD.score += 500 + 50 * (spawnLevel / 25);

            for (int i = 0; i < 3; i++) {
                Spawner.basicEnemy();
            }

            Spawner.smartEnemy();
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