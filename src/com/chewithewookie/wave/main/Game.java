package com.chewithewookie.wave.main;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable{

    public static final String TITLE = "Wave";
    public static final int WIDTH = 1024;
    public static final int HEIGHT = WIDTH / 12 * 9 + 3;
    public static final int BORDER = 16;
    public static int speed = 5;
    public static int scale = WIDTH/4;
    public static final float startHealth = HUD.health;
    public static STATE gameState = STATE.Menu;

    public static Random staticRandom = new Random();

    private Thread thread;
    private boolean running = false;


    public Game() {
        new Window(this);
        new SpawnTable();

        this.addKeyListener(new KeyInput());
        this.addMouseListener(new MouseInput());
    }

    public static void main (String[] args){
        new Game();
    }

    public void update() {
        Handler.update();
        if(gameState == STATE.Game){
            HUD.update();
            SpawnTable.update();
        }
        if(gameState == STATE.Menu){
            Menu.update();
        }

        if(HUD.health <= 0){
            gameState = STATE.GameOver;
            Handler.clearObject();
        }
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        Handler.render(g);

        switch (gameState){
            case Game:
                HUD.render(g);
                break;
            case Menu:
                Menu.render(g);
                break;
            case Paused:
                Pause.render(g);
                break;
            case GameOver:
                GameOver.render(g);
                break;
            case Shop:
                Shop.render(g);
                break;
        }

        g.dispose();
        bs.show();
    }

    public static float clamp(float var, float min, float max) {
        if(var >= max){
            return var = max;
        }else if(var <= min){
            return var = min;
        }else {
            return var;
        }

    }

    public static int stringWidth(String string, Graphics g){
        return g.getFontMetrics().stringWidth(string);
    }

    public static boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if(mx > x && mx < x + width){
            if(my > y && my < y +height){
                return true;
            }
        }
        return false;
    }

    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();

        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while(delta >= 1){
                update();
                delta--;
            }

            if(running){
                render();
            }

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
            }
        }

        stop();
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try{
            thread.join();
            running = false;
        } catch (InterruptedException e){
            System.err.println(e);
        }
    }

}