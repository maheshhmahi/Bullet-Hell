package com.bullethell.game.characters.entity;

public enum EntityType {

    MID_BOSS_B(100, 100, "midBossB.png", 80, 150),

    HERO(50, 50, "playerShip1_red.png", 80, 200),

    GEN_ENEMY_A(20, 20, "enemyTexture.png", 40, 200);

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
