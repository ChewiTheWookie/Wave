package com.chewithewookie.wave.main;

import java.awt.*;

public class SmartEnemy extends GameObject {

    private GameObject player;

    public static int size  = Player.playerSize/2;
    private Color color = new Color(140, 0, 210);

    public SmartEnemy(int x, int y, ID id) {
        super(x, y, id);

        for (int i = 0; i < Handler.object.size(); i++) {
            if(Handler.object.get(i).getId() == ID.Player) player = Handler.object.get(i);
        }

        velX = Game.speed;
        velY = Game.speed;
    }

    public void update() {
        x += velX;
        y += velY;

        float distanceX = x - player.getX() - 8;
        float distanceY = y - player.getY() - 8;
        float distance = (float) Math.sqrt((x-player.getX()) * (x-player.getX()) + (y-player.getY()) * (y-player.getY()));

        velX = ((-1 / distance) * distanceX);
        velY = ((-1 / distance) * distanceY);

        Handler.addObject(new Trail((int)x, (int)y, ID.Trail, color, size, 0.05f));

        if(BossEnemy.alive){
            Handler.removeObject(this);
        }
        switch (Game.gameState){
            case Menu:
                Handler.removeObject(this);
                break;
            case Paused:
            case Shop:
                SpawnTable.smartEnemy++;
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