package com.chewithewookie.wave.main;

public class Spawner {

    public static void basicEnemy(){
        Handler.addObject(new BasicEnemy(BasicEnemy.size + Game.staticRandom.nextInt(Game.WIDTH - BasicEnemy.size*2), BasicEnemy.size + Game.staticRandom.nextInt(Game.HEIGHT - BasicEnemy.size * 2), ID.BasicEnemy));
    }

    public static void fastEnemy(){
        Handler.addObject(new FastEnemy(FastEnemy.size + Game.staticRandom.nextInt(Game.WIDTH - FastEnemy.size*2), FastEnemy.size + Game.staticRandom.nextInt(Game.HEIGHT - FastEnemy.size * 2), ID.FastEnemy));
    }

    public static void smartEnemy() {
        Handler.addObject(new SmartEnemy(SmartEnemy.size + Game.staticRandom.nextInt(Game.WIDTH - SmartEnemy.size*2), SmartEnemy.size + Game.staticRandom.nextInt(Game.HEIGHT - SmartEnemy.size * 2), ID.SmartEnemy));
    }

    public static void bossEnemy() {
        Handler.addObject(new BossEnemy( Game.WIDTH + BossEnemy.size * 2, Game.HEIGHT/2 - BossEnemy.size/2, ID.BossEnemy));
    }

    public static void player(){
        Handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-Player.playerSize/2, ID.Player));
    }

}