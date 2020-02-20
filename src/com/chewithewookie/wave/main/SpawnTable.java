package com.chewithewookie.wave.main;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class SpawnTable {

    private static Timer timer = new Timer();
    private static TimerTask task = new Helper();

    public static int scoreKeep;
    public static int basicEnemy, fastEnemy, smartEnemy;

    public SpawnTable() {
        timer.schedule(task, 1, 1000);
    }

    public static void update() {

        if(basicEnemy != 0) {
            Spawner.basicEnemy();
            basicEnemy--;
        }
        if(fastEnemy != 0){
            Spawner.fastEnemy();
            fastEnemy--;
        }
        if(smartEnemy != 0){
            Spawner.smartEnemy();
            smartEnemy--;
        }

        if(scoreKeep >= 10) {
            scoreKeep = 0;
            HUD.level += 1;
            HUD.score += 100;

            switch (HUD.level){
                case 2:
                case 3:
                case 4:
                case 6:
                case 7:
                case 8:
                case 9:
                    Spawner.basicEnemy();
                    break;
                case 5:
                    Spawner.smartEnemy();
                    Spawner.fastEnemy();
                    break;
            }

            if(HUD.level % 2 == 1){
                if(HUD.level > 10){
                    if(HUD.level % 25 != 0){
                        Spawner.basicEnemy();
                    }
                }
            }

            if(HUD.level % 10 == 0) {
                if(HUD.level % 25 != 0){
                    for (int i = 0; i < HUD.level / 10; i++) {
                        Spawner.fastEnemy();
                    }
                }
            }

            if(HUD.level % 25 == 0){
                Spawner.bossEnemy();
            }
        }
    }

}

class Helper extends TimerTask{

    Random random = new Random();

    public void run() {
        if(!BossEnemy.alive && Game.gameState == STATE.Game){
            SpawnTable.scoreKeep++;
            HUD.score += 1 + random.nextInt(4);
        }
        if(BossEnemy.alive){
            BossEnemy.timeAlive++;
            HUD.score += 6 + random.nextInt(4);
        }
    }

}