package com.chewithewookie.wave.main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        switch (Game.gameState){
            case Menu:
                Menu.clicked(mx, my);
                break;
            case Game:
                HUD.clicked(mx, my);
                break;
            case Paused:
                Pause.clicked(mx, my);
                break;
            case Shop:
                Shop.clicked(mx, my);
                break;
            case GameOver:
                GameOver.clicked(mx, my);
                break;
        }
    }
}