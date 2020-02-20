package com.chewithewookie.wave.main;

import java.awt.*;

public class FastEnemy extends GameObject {

    public static int size  = Player.playerSize/2;
    private Color color = Color.cyan;
    private int spawnLevel;
    private int lifeSpan = 5;

    public FastEnemy(int x, int y, ID id) {
        super(x, y, id);

        velX = Game.speed * 2 - Game.speed /5 * 2;
        velY = Game.speed * 2 - Game.speed /5 * 2;

        spawnLevel = HUD.level;
    }

    public void update() {
        x += velX;
        y += velY;

        if(y <= 0 || y + size + 1 >= Game.HEIGHT) velY *= -1;
        if(x <= 0 || x + size + 1 >= Game.WIDTH) velX *= -1;

        Handler.addObject(new Trail((int)x, (int)y, ID.Trail, color, size, 0.05f));

        if(HUD.level == spawnLevel + lifeSpan || BossEnemy.alive){
            Handler.removeObject(this);
        }
        switch (Game.gameState){
            case Menu:
                Handler.removeObject(this);
                break;
            case Paused:
            case Shop:
                SpawnTable.fastEnemy++;
                Handler.removeObject(this);
                break;
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