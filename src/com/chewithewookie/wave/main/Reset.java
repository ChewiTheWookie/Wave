package com.chewithewookie.wave.main;

public class Reset {

    public static void resetGame() {
        HUD.score = 0;
        HUD.level = 0;
        HUD.health = Game.startHealth;

        SpawnTable.scoreKeep = 0;

        BossEnemy.alive = false;
        BossEnemy.shooting = false;
        BossEnemy.timeAlive = 0;
    }

}