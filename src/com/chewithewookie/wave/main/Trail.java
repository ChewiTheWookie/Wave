package com.chewithewookie.wave.main;

import java.awt.*;

public class Trail extends GameObject {

    private float alpha = 1;
    private Color color;
    private int size;
    private float life;

    public Trail(int x, int y, ID id, Color color, int size, float life){
        super(x, y, id);
        this.color = color;
        this.size = size;
        this.life = life;
    }

    public void update() {
        if(alpha > life){
            alpha -= life - 0.0001f;
        }else {
            Handler.removeObject(this);
        }
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setComposite(makeTransparent(alpha));
        g.setColor(color);
        g.fillRect((int)x, (int)y, size, size);

        g2d.setComposite(makeTransparent(1));
    }

    private AlphaComposite makeTransparent(float alpha){
        int type = AlphaComposite.SRC_OVER;
        return AlphaComposite.getInstance(type, alpha);
    }

    public Rectangle getBounds() {
        return null;
    }

}