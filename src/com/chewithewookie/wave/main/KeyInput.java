package com.chewithewookie.wave.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Boolean[] keyDown = new Boolean[4];

    public KeyInput() {

        keyDown[0] = false; // W
        keyDown[1] = false; // A
        keyDown[2] = false; // S
        keyDown[3] = false; // D
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        for (int i = 0; i < Handler.object.size(); i++){
            GameObject tempObject = Handler.object.get(i);

            if(tempObject.getId() == ID.Player){
                switch (key){
                    case KeyEvent.VK_W:
                    case KeyEvent.VK_UP:
                        tempObject.setVelY(-Game.speed);
                        keyDown[0] = true;
                        break;
                    case KeyEvent.VK_A:
                    case KeyEvent.VK_LEFT:
                        tempObject.setVelX(-Game.speed);
                        keyDown[1] = true;
                        break;
                    case KeyEvent.VK_S:
                    case KeyEvent.VK_DOWN:
                        tempObject.setVelY(Game.speed);
                        keyDown[2] = true;
                        break;
                    case KeyEvent.VK_D:
                    case KeyEvent.VK_RIGHT:
                        tempObject.setVelX(Game.speed);
                        keyDown[3] = true;
                        break;
                }
            }
        }

        if(key == KeyEvent.VK_ESCAPE) {
            switch (Game.gameState){
                case Menu:
                    System.exit(1);
                    break;
                case Game:
                    Game.gameState = STATE.Paused;
                    break;
                case Shop:
                    Game.gameState = STATE.Game;
                    Spawner.player();
                    break;
            }
        }
    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        for (int i = 0; i < Handler.object.size(); i++){
            GameObject tempObject = Handler.object.get(i);

            if(tempObject.getId() == ID.Player){
                switch (key) {
                    case KeyEvent.VK_W:
                    case KeyEvent.VK_UP:
                        keyDown[0] = false;
                        break;
                    case KeyEvent.VK_A:
                    case KeyEvent.VK_LEFT:
                        keyDown[1] = false;
                        break;
                    case KeyEvent.VK_S:
                    case KeyEvent.VK_DOWN:
                        keyDown[2] = false;
                        break;
                    case KeyEvent.VK_D:
                    case KeyEvent.VK_RIGHT:
                        keyDown[3] = false;
                        break;
                }

                // Vertical movement
                if(!keyDown[0] && !keyDown[2]) tempObject.setVelY(0);
                if(keyDown[0] && !keyDown[2]) tempObject.setVelY(-5);
                if(!keyDown[0] && keyDown[2]) tempObject.setVelY(5);

                // Horizontal movement
                if(!keyDown[1] && !keyDown[3]) tempObject.setVelX(0);
                if(keyDown[1] && !keyDown[3]) tempObject.setVelX(-5);
                if(!keyDown[1] && keyDown[3]) tempObject.setVelX(5);
            }
        }
    }

}