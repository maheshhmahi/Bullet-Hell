package com.bullethell.game.characters.entity;

public enum EntityType {

    MID_BOSS_B(100, 100, "monster.png", 80, 15),
    MID_BOSS_A(100, 100, "monsterboss.png", 80, 20),
    HERO(50, 50, "playerShip1_red.png", 80, 3),
    FINAL_BOSS_1(100,100 ,"finalBoss.png" ,80,1 ),
    GEN_ENEMY_B(20, 20, "enemy2.png", 40, 1),
    GEN_ENEMY_A(75, 50, "monster.png", 40, 15);

    private int height, width;
    private String image;
    private int speed;
    private int live;

    EntityType(int height, int width, String image, int speed, int live) {
        this.height = height;
        this.width = width;
        this.image = image;
        this.speed = speed;
        this.live = live;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public String getImage() {
        return image;
    }

    public int getSpeed() {
        return speed;
    }

    public int getLive() {
        return live;
    }

}
